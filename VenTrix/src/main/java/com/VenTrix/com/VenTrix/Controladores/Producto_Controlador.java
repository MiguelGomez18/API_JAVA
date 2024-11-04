package com.VenTrix.com.VenTrix.Controladores;

import com.VenTrix.com.VenTrix.Entidades.Categoria;
import com.VenTrix.com.VenTrix.Entidades.Producto;
import com.VenTrix.com.VenTrix.Repositorios.Categoria_Repositorio;
import com.VenTrix.com.VenTrix.Servicios.Producto_Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/producto")
public class Producto_Controlador {

    private static final String DIRECTORIO_IMAGENES = "src/main/resources/imagenes/";

    @Autowired
    private Producto_Servicio servicio;

    @Autowired
    private Categoria_Repositorio repositorio;

    // Crear un nuevo producto
    @PostMapping("/registrar_producto")
    public ResponseEntity<Producto> crearProducto(
            @RequestParam("id_producto") int idProducto,
            @RequestParam("nombre") String nombre,
            @RequestParam("precio") float precio,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("disponibilidad") boolean disponibilidad,
            @RequestParam("id_categoria") String categoriaId,
            @RequestParam("imagen") MultipartFile imagen) {

        try {
            String nombreArchivo = null;
            if (!imagen.isEmpty()) {
                nombreArchivo = guardarImagenEnDirectorio(imagen);
            }

            Categoria categoria = repositorio.getReferenceById(categoriaId);

            Producto producto = new Producto();
            producto.setId_producto(idProducto);
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setDescripcion(descripcion);
            producto.setDisponibilidad(disponibilidad);
            producto.setImagen(nombreArchivo != null ? "/imagenes/" + nombreArchivo : null);  // Ruta pública
            producto.setCategoria(categoria);

            Producto nuevoProducto = servicio.guardarProducto(producto);
            return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private String guardarImagenEnDirectorio(MultipartFile imagen) throws IOException {
        String nombreArchivo = System.currentTimeMillis() + "_" + imagen.getOriginalFilename();
        Files.copy(imagen.getInputStream(), Paths.get(DIRECTORIO_IMAGENES + nombreArchivo), StandardCopyOption.REPLACE_EXISTING);
        return nombreArchivo;
    }


    // Obtener todos los productos
    @GetMapping()
    public ResponseEntity<List<Producto>> obtenerTodosLosProductos() {
        List<Producto> productos = servicio.listarProductos();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    // Obtener los producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable int id) {
        Producto producto = servicio.obtenerProductoPorId(id);
        return producto != null ? new ResponseEntity<>(producto, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Actualizar un producto existente
    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable int id,
                                                       @RequestParam("nombre") String nombre,
                                                       @RequestParam("precio") Integer precio,
                                                       @RequestParam("id_categoria") String categoriaId,
                                                       @RequestParam("descripcion") String descripcion,
                                                       @RequestParam("imagen") MultipartFile imagen,
                                                       @RequestParam("disponibilidad") boolean disponibilidad) {

        try {
            String nombreArchivo = null;
            if (!imagen.isEmpty()) {
                nombreArchivo = guardarImagenEnDirectorio(imagen);
            }

            Categoria categoria = repositorio.getReferenceById(categoriaId);

            Producto producto = new Producto();
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCategoria(categoria);
            producto.setDescripcion(descripcion);
            producto.setDisponibilidad(disponibilidad);
            producto.setImagen(nombreArchivo != null ? "/imagenes/" + nombreArchivo : null);  // Ruta pública
            Producto productoActualizado = servicio.actualizarProducto(id, producto);
            return productoActualizado != null ? new ResponseEntity<>(productoActualizado, HttpStatus.OK) :
                    new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Eliminar un producto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable int id) {
        boolean eliminado = servicio.eliminarProducto(id);
        return eliminado ? new ResponseEntity<>(HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
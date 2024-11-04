package com.VenTrix.com.VenTrix.Servicios;

import com.VenTrix.com.VenTrix.Entidades.Categoria;
import com.VenTrix.com.VenTrix.Entidades.Producto;
import com.VenTrix.com.VenTrix.Repositorios.Producto_Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Producto_Servicio {

    @Autowired
    private Producto_Repositorio repositorio;

    // Implementar métodos para CRUD en la entidad Producto

    public Producto guardarProducto(Producto producto) {
        return repositorio.save(producto);
    }

    public List<Producto> listarProductos() {
        return repositorio.findAll();
    }

    public Producto obtenerProductoPorId(int id) {
        return repositorio.findById(id).orElse(null);
    }

    public Producto actualizarProducto(int id, Producto productoDetalles) {
        Producto producto = repositorio.findById(id).orElse(null);
        if (producto != null) {
            producto.setNombre(productoDetalles.getNombre());
            producto.setPrecio(productoDetalles.getPrecio());
            producto.setCategoria(productoDetalles.getCategoria());
            producto.setDescripcion(productoDetalles.getDescripcion());
            producto.setImagen(productoDetalles.getImagen());
            producto.setDisponibilidad(productoDetalles.isDisponibilidad());
            repositorio.save(producto);
        }
        return producto;
    }

    public boolean eliminarProducto(int id) {
        repositorio.deleteById(id);
        return true;
    }

}
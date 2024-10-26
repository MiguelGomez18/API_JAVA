package com.VenTrix.com.VenTrix.Controladores;

import com.VenTrix.com.VenTrix.Entidades.Restaurante;
import com.VenTrix.com.VenTrix.Servicios.Restaurante_Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "localhost:5173")
@RestController
@RequestMapping("/restaurante")
public class Restaurante_Controlador {

    // Aquí se definiran las rutas para los endpoints del restaurantes

    @Autowired
    private Restaurante_Servicio servicio;

    @PostMapping() // Crear un nuevo restaurante
    public ResponseEntity<Restaurante> crearRestaurante(@RequestBody Restaurante restaurante){
        Restaurante saveRestaurante = servicio.addRestaurante(restaurante);
        return new ResponseEntity<>(saveRestaurante, HttpStatus.CREATED);
    }

    @GetMapping() // Listar todos los restaurantes
    public ResponseEntity<Iterable<Restaurante>> listarRestaurantes(){
        List<Restaurante> lista = servicio.listar();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}") // Obtener un restaurante por su id
    public ResponseEntity<Restaurante> getRestauranteById(@PathVariable Integer id){
        Restaurante restaurante = servicio.getRestauranteById(id);
        return new ResponseEntity<>(restaurante, HttpStatus.OK);
    }

    @PutMapping("/{id}") // Actualizar un restaurante por su id
    public ResponseEntity<Restaurante> updateRestaurante(@PathVariable Integer id, @RequestBody Restaurante restaurante){
        Restaurante saveRestaurante = servicio.updateRestaurante(id, restaurante);
        return new ResponseEntity<>(saveRestaurante, HttpStatus.OK);
    }

    @DeleteMapping("/{id}") // Eliminar un restaurante por su id
    public ResponseEntity<Void> deleteRestaurante(@PathVariable Integer id){
        servicio.deleteRestaurante(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

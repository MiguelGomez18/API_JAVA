package com.VenTrix.com.VenTrix.Controladores;

import com.VenTrix.com.VenTrix.Entidades.Sucursal;
import com.VenTrix.com.VenTrix.Servicios.Sucursal_Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "localhost:5173")
@RestController
@RequestMapping("/sucursal")
public class Sucursal_Controlador {

    // Aquí se crean los endpoints para las operaciones CRUD de la entidad Sucursal

    @Autowired
    private Sucursal_Servicio servicio;

    @PostMapping() // Crear una nueva sucursal
    public ResponseEntity<Sucursal> crearSucursal(Sucursal sucursal) {
        Sucursal saveSucursal = servicio.addSucursal(sucursal);
        return new ResponseEntity<>(saveSucursal, HttpStatus.CREATED);
    }

    @GetMapping() // Listar todas las sucursales
    public ResponseEntity<List<Sucursal>> listar() {
        List<Sucursal> lista = servicio.listar();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}") // Obtener una sucursal por su ID
    public ResponseEntity<Sucursal> obtenerSucursal(@PathVariable Integer id) {
        Sucursal sucursal = servicio.getSucursalById(id);
        return new ResponseEntity<>(sucursal, HttpStatus.OK);
    }

    @PutMapping("/{id}") // Actualizar una sucursal por su ID
    public ResponseEntity<Sucursal> actualizarSucursal(@PathVariable Integer id, @RequestBody Sucursal sucursal) {
        Sucursal updateSucursal = servicio.updateSucursal(id, sucursal);
        return new ResponseEntity<>(updateSucursal, HttpStatus.OK);
    }

    @DeleteMapping("/{id}") // Eliminar una sucursal por su ID
    public ResponseEntity<Void> eliminarSucursal(@PathVariable Integer id) {
        servicio.deleteSucursal(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

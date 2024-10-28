package com.VenTrix.com.VenTrix.Controladores;

import com.VenTrix.com.VenTrix.Entidades.Sucursal;
import com.VenTrix.com.VenTrix.Servicios.Sucursal_Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/sucursal")
public class Sucursal_Controlador {

    // Aquí se crean los endpoints para las operaciones CRUD de la entidad Sucursal

    @Autowired
    private Sucursal_Servicio servicio;

    @PostMapping() // Crear una nueva sucursal
    public ResponseEntity<Sucursal> crearSucursal(@RequestBody Sucursal sucursal) {
        Sucursal saveSucursal = servicio.addSucursal(sucursal);
        return new ResponseEntity<>(saveSucursal, HttpStatus.CREATED);
    }

    @GetMapping("/id_sucursal/{id_restaurante}")
    public ResponseEntity<List<Sucursal>> getIdSucursal(@PathVariable("id_restaurante") String restaurante) {
        List<Sucursal> sucursales = servicio.getIdSucursalById(restaurante);
        return ResponseEntity.ok(sucursales);
    }

    @GetMapping("/{id}") // Obtener una sucursal por su ID
    public ResponseEntity<Sucursal> obtenerSucursal(@PathVariable String id_sucursal) {
        Sucursal sucursal = servicio.getSucursalById(id_sucursal);
        return new ResponseEntity<>(sucursal, HttpStatus.OK);
    }

    @PutMapping("/{id}") // Actualizar una sucursal por su ID
    public ResponseEntity<Sucursal> actualizarSucursal(@PathVariable String id_sucursal, @RequestBody Sucursal sucursal) {
        Sucursal updateSucursal = servicio.updateSucursal(id_sucursal, sucursal);
        return new ResponseEntity<>(updateSucursal, HttpStatus.OK);
    }

    @DeleteMapping("/{id}") // Eliminar una sucursal por su ID
    public ResponseEntity<Void> eliminarSucursal(@PathVariable String id_sucursal) {
        servicio.deleteSucursal(id_sucursal);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

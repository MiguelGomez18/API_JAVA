package com.VenTrix.com.VenTrix.Controladores;

import com.VenTrix.com.VenTrix.Entidades.Mesa;
import com.VenTrix.com.VenTrix.Entidades.Sucursal;
import com.VenTrix.com.VenTrix.Servicios.Mesa_Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/mesa")
public class Mesa_Controlador {

    // Aquí se crean los endpoints para las operaciones CRUD de la entidad Mesa

    @Autowired
    private Mesa_Servicio servicio;

    @PostMapping() // Crear una nueva mesa
    public ResponseEntity<Mesa> crearMesa(@RequestBody Mesa mesa) {
        Mesa saveMesa = servicio.addMesa(mesa);
        return new ResponseEntity<>(saveMesa, HttpStatus.CREATED);
    }

    @GetMapping() // Listar todas las mesas
    public ResponseEntity<List<Mesa>> listar() {
        List<Mesa> lista = servicio.listar();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}") // Obtener una mesa por su ID
    public ResponseEntity<Mesa> getMesaById(@PathVariable String id) {
        Mesa mesa = servicio.getMesaById(id);
        return new ResponseEntity<>(mesa, HttpStatus.OK);
    }

    @PutMapping("/{id}") // Actualizar una mesa por su ID
    public ResponseEntity<Mesa> updateMesa(@PathVariable int id, @RequestBody Mesa mesa) {
        Mesa updateMesa = servicio.updateMesa(id, mesa);
        return new ResponseEntity<>(updateMesa, HttpStatus.OK);
    }

    @DeleteMapping("/{id}") // Eliminar una mesa por su ID
    public ResponseEntity<Void> deleteMesa(@PathVariable String id) {
        servicio.deleteMesa(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }









}

package com.VenTrix.com.VenTrix.Controladores;

import com.VenTrix.com.VenTrix.Entidades.Tipo_pago;
import com.VenTrix.com.VenTrix.Servicios.Tipo_pago_Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/tipo_pago")
public class Tipo_pago_Controlador {


    @Autowired
    private Tipo_pago_Servicio tipoPagoServicio;



    // Obtener todos los tipos de pago
    @GetMapping
    public ResponseEntity<List<Tipo_pago>> obtenerTiposPago() {
        List<Tipo_pago> tiposPago = tipoPagoServicio.listarTiposPago();
        return new ResponseEntity<>(tiposPago, HttpStatus.OK);
    }

    // Obtener un tipo de pago por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Tipo_pago> obtenerTipoPago(@PathVariable int id) {
        Tipo_pago tipoPago = tipoPagoServicio.getTipoPagoById(id);
        if (tipoPago == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tipoPago, HttpStatus.OK);
    }

    // Registrar un nuevo tipo de pago
    @PostMapping("/registrar")
    public ResponseEntity<Tipo_pago> registrarTipoPago(@RequestBody Tipo_pago tipoPago) {
        if (tipoPagoServicio.getTipoPagoById(tipoPago.getId()) != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // El ID ya existe
        }
        Tipo_pago nuevoTipoPago = tipoPagoServicio.addTipoPago(tipoPago);
        return new ResponseEntity<>(nuevoTipoPago, HttpStatus.CREATED);
    }

    // Actualizar un tipo de pago por su ID
    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarTipoPago(@PathVariable int id, @RequestBody Tipo_pago tipoPago) {
        Tipo_pago tipoPagoExistente = tipoPagoServicio.getTipoPagoById(id);
        if (tipoPagoExistente == null) {
            return new ResponseEntity<>("Tipo de pago no encontrado", HttpStatus.NOT_FOUND);
        }
        tipoPago.setId(id); // Asegurar que se actualiza el registro correcto
        tipoPagoServicio.updateTipoPago(id, tipoPago);
        return new ResponseEntity<>("Tipo de pago actualizado correctamente", HttpStatus.OK);
    }
    // Eliminar un tipo de pago por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTipoPago(@PathVariable int id) {
        Tipo_pago tipoPagoExistente = tipoPagoServicio.getTipoPagoById(id);
        if (tipoPagoExistente == null) {
            return new ResponseEntity<>("Tipo de pago no encontrado", HttpStatus.NOT_FOUND);
        }
        tipoPagoServicio.deleteTipoPago(id);
        return new ResponseEntity<>("Tipo de pago eliminado correctamente", HttpStatus.OK);
    }
}
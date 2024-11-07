
package com.VenTrix.com.VenTrix.Servicios;

import com.VenTrix.com.VenTrix.Entidades.Tipo_pago;
import com.VenTrix.com.VenTrix.Repositorios.Tipo_pago_Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Tipo_pago_Servicio {

    private final Tipo_pago_Repositorio repositorio;

    @Autowired
    public Tipo_pago_Servicio(Tipo_pago_Repositorio repositorio) {this.repositorio = repositorio;}

    // Método para agregar un nuevo tipo de pago
    public Tipo_pago addTipoPago(Tipo_pago tipo_pago) { return repositorio.save(tipo_pago);}

    // Método para obtener un tipo de pago por su ID
    public Tipo_pago getTipoPagoById(int id) { return repositorio.findById(id).orElse(null);}

    // Método para actualizar un tipo de pago
    public Tipo_pago updateTipoPago(int id, Tipo_pago tipoPago) {
        if (repositorio.existsById(id)) {
            tipoPago.setId(id); // Asegurarse de establecer el ID correcto
            return repositorio.save(tipoPago);
        } else {
            return null;
        }
    }

    // Método para eliminar un tipo de pago por su ID
    public void deleteTipoPago(int id) {
        repositorio.deleteById(id);
    }

    // Método para listar todos los tipos de pago
    public List<Tipo_pago> listarTiposPago() {
        return repositorio.findAll();
    }
}

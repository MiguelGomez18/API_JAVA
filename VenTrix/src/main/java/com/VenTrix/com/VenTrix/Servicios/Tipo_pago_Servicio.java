
package com.VenTrix.com.VenTrix.Servicios;

import com.VenTrix.com.VenTrix.Entidades.Tipo_pago;
import com.VenTrix.com.VenTrix.Repositorios.Tipo_pago_Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Tipo_pago_Servicio {

    @Autowired
    private final Tipo_pago_Repositorio repositorio;

    // metodos de la clase

    public Tipo_pago_Servicio(Tipo_pago_Repositorio repositorio) {this.repositorio = repositorio;}

    public Tipo_pago addTipoPago(Tipo_pago tipo_pago) { return repositorio.save(tipo_pago);}

    public Tipo_pago getTipoPagoById(int id) { return repositorio.findById(id).orElse(null);}

    public List<Tipo_pago> getAllTipoPagos() { return repositorio.findAll();}

    public Tipo_pago updateTipoPago(int id, Tipo_pago tipo_pago) { return repositorio.save(tipo_pago);}

    public void deleteTipoPago(int id) { repositorio.deleteById(id);}

}

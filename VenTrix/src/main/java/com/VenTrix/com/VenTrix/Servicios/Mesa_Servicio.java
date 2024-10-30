package com.VenTrix.com.VenTrix.Servicios;

import com.VenTrix.com.VenTrix.Entidades.Mesa;
import com.VenTrix.com.VenTrix.Entidades.Sucursal;
import com.VenTrix.com.VenTrix.Repositorios.Mesa_Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Mesa_Servicio {

    @Autowired
    private Mesa_Repositorio repositorio;

    // Métodos de la clase

    public Mesa addMesa(Mesa mesa) { // Agregar una mesa
        return repositorio.save(mesa);
    }

    public List<Mesa> listarPorSucursal() { // Listar mesas
        return repositorio.findAll();
    }

    public Mesa getMesaById(String id) { // Obtener una mesa por su ID
        return repositorio.findById(id).orElse(null);
    }

    public Mesa updateMesa(Integer id, Mesa mesa) { // Actualizar una mesa
        return repositorio.save(mesa);
    }

    public void deleteMesa(String id) { // Eliminar una mesa
        repositorio.deleteById(id);
    }

    public List<Mesa> listar() {
        return repositorio.findAll();
    }
}
package com.VenTrix.com.VenTrix.Servicios;

import com.VenTrix.com.VenTrix.Entidades.Sucursal;
import com.VenTrix.com.VenTrix.Repositorios.Sucursal_Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Sucursal_Servicio {

    @Autowired
    private Sucursal_Repositorio repositorio;

    //metodos de la clase

    public Sucursal addSucursal(Sucursal sucursal){ //agregar sucursal
        return repositorio.save(sucursal);
    }

    public List<Sucursal> listar(){ //listar todas las sucursales
        return repositorio.findAll();
    }

    public Sucursal getSucursalById(Integer id){ //buscar sucursal por id
        return repositorio.findById(id).orElse(null);
    }

    public Sucursal updateSucursal(Integer id,Sucursal sucursal){ //actualizar sucursal
        return repositorio.save(sucursal);
    }

    public void deleteSucursal(Integer id){ //eliminar sucursal
        repositorio.deleteById(id);
    }

}

package com.VenTrix.com.VenTrix.Servicios;

import com.VenTrix.com.VenTrix.Entidades.Restaurante;
import com.VenTrix.com.VenTrix.Entidades.Rol_Usuario;
import com.VenTrix.com.VenTrix.Entidades.Sucursal;
import com.VenTrix.com.VenTrix.Entidades.Usuario;
import com.VenTrix.com.VenTrix.Repositorios.Restaurante_Repositorio;
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

    public Sucursal getSucursalById(String id){ //buscar sucursal por id
        return repositorio.findById(id).orElse(null);
    }

    public String getByAdministrador(String administrador) { // Obtener un usuario por su correo
        Sucursal sucursal = repositorio.findByAdministrador(administrador);
        if (sucursal != null) {
            return sucursal.getId();
        } else {
            return null;
        }
    }

    public Sucursal updateSucursal(String id_sucursal, Sucursal sucursal) { // actualizar sucursal
        if (repositorio.existsById(id_sucursal)) {
            sucursal.setId(id_sucursal);
            return repositorio.save(sucursal);
        } else {
            return null;
        }
    }

    public void deleteSucursal(String id){ //eliminar sucursal
        repositorio.deleteById(id);
    }

}

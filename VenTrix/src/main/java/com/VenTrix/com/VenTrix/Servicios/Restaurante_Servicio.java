package com.VenTrix.com.VenTrix.Servicios;

import com.VenTrix.com.VenTrix.Entidades.Restaurante;
import com.VenTrix.com.VenTrix.Repositorios.Restaurante_Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Restaurante_Servicio {

    @Autowired
    private Restaurante_Repositorio repositorio;

    //metodos para el CRUD

    public Restaurante addRestaurante(Restaurante restaurante){ //agregar un nuevo restaurante
        return repositorio.save(restaurante);
    }

    public Restaurante getRestauranteById(Integer id) { //obtener un restaurante por su id
        return repositorio.findById(id).orElse(null);
    }

    public Restaurante updateRestaurante(Integer id,Restaurante restaurante){ //actualizar un restaurante
        return repositorio.save(restaurante);
    }

    public void deleteRestaurante(Integer id){ //eliminar un restaurante
        repositorio.deleteById(id);
    }

    public List<Restaurante> listar(){
        return repositorio.findAll();
    }


}

package com.VenTrix.com.VenTrix.Servicios;

import com.VenTrix.com.VenTrix.Entidades.Restaurante;
import com.VenTrix.com.VenTrix.Entidades.Usuario;
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

    public String getIdByDocumentoUsuario(String documentoUsuario) {
        Restaurante restaurante = repositorio.findByUsuarioDocumento(documentoUsuario);
        return restaurante.getId();
    }

    public String getRestauranteById(String id) { //obtener un restaurante por su id
       Restaurante restaurante = repositorio.findById(id).orElse(null);
        if (restaurante != null) {
            return restaurante.getNombre();
        } else {
            return null;
        }
    }

    public Restaurante updateRestaurante(String id_restaurante,Restaurante restaurante){ //actualizar un restaurante
        if (repositorio.existsById(id_restaurante)) {
            return repositorio.save(restaurante);
        } else {
            return null;
        }
    }

    public void deleteRestaurante(String id){ //eliminar un restaurante
        repositorio.deleteById(id);
    }

    public List<Restaurante> listar(){
        return repositorio.findAll();
    }


}

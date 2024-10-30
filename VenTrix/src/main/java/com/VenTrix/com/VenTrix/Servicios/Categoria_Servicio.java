package com.VenTrix.com.VenTrix.Servicios;

import com.VenTrix.com.VenTrix.Entidades.Categoria;
import com.VenTrix.com.VenTrix.Repositorios.Categoria_Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class Categoria_Servicio {

    @Autowired
    private Categoria_Repositorio repositorio;

    // Métodos de la clase

    public Categoria_Servicio(Categoria_Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Categoria addCategoria(Categoria categoria) { // Agregar una nueva categoría
        return repositorio.save(categoria);
    }

    public Categoria getCategoriaById(String id) { // Obtener una categoría por su ID
        return repositorio.findById(id).orElse(null);
    }

    public Categoria updateCategoria(String id, Categoria categoria) { // Actualizar una categoría
        return repositorio.save(categoria);
    }

    public void deleteCategoria(String id) { // Eliminar una categoría
        repositorio.deleteById(id);
    }

    public List<Categoria> listarCategorias() {
        return repositorio.findAll();
    }
}

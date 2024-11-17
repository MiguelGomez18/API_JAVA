package com.VenTrix.com.VenTrix.Repositorios;

import com.VenTrix.com.VenTrix.Entidades.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Sucursal_Repositorio extends JpaRepository<Sucursal, String> {

    Sucursal findByAdministrador(String administrador);
}

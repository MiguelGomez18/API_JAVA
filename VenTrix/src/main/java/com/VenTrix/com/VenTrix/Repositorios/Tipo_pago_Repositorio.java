package com.VenTrix.com.VenTrix.Repositorios;

import com.VenTrix.com.VenTrix.Entidades.Tipo_pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Tipo_pago_Repositorio extends JpaRepository<Tipo_pago, Integer> {
    // No es necesario agregar métodos adicionales en este momento, JpaRepository ya proporciona los métodos CRUD básicos.
}

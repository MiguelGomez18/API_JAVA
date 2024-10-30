package com.VenTrix.com.VenTrix.Entidades;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data // Incluye los getters, setters y toString
@NoArgsConstructor
@AllArgsConstructor

public class Categoria {

    @Id
    @Column(unique = true, nullable = false, length = 100)
    private String id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = true, length = 100)
    private String descripcion;

    @OneToMany(targetEntity = Producto.class, fetch = FetchType.LAZY, mappedBy = "categoria")
    @JsonManagedReference
    private List<Producto> producto;


}

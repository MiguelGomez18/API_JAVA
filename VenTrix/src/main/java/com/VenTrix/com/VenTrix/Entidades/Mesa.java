package com.VenTrix.com.VenTrix.Entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data // Incluye los getters, setters y toString
@NoArgsConstructor
@AllArgsConstructor

public class Mesa {
    @Id
    @Column(unique = true, nullable = false, length = 100)
    private String id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @ManyToOne(targetEntity = Sucursal.class)
    @JoinColumn(name = "id_sucursal")
    private Sucursal sucursal;

    @OneToMany(targetEntity = Pedido.class, fetch = FetchType.LAZY, mappedBy = "mesa")
    private List<Pedido> pedido;
}

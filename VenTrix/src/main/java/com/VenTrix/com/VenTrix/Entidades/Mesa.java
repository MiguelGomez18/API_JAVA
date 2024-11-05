package com.VenTrix.com.VenTrix.Entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data // Incluye los getters, setters y toString
@NoArgsConstructor
@AllArgsConstructor
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Estado_Mesa estado;

    @ManyToOne(targetEntity = Sucursal.class)
    @JoinColumn(name = "id_sucursal")
    private Sucursal sucursal;

    @OneToMany(targetEntity = Pedido.class, fetch = FetchType.LAZY, mappedBy = "mesa")
    private List<Pedido> pedido;
}

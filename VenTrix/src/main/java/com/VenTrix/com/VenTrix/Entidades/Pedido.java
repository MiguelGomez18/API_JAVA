package com.VenTrix.com.VenTrix.Entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pedido;

    @Column(nullable = false, columnDefinition = "DATE")
    private LocalDate fecha_pedido;

    @Column(nullable = false, columnDefinition = "TIME")
    private LocalTime hora_pedido;

    @Column(nullable = true)
    private float total_pedido;

    @ManyToOne(targetEntity = Mesa.class)
    @JoinColumn(name = "id_mesa")
    private Mesa mesa;

    @ManyToOne
    @JoinColumn(name = "id_tipo_pago")
    private Tipo_pago tipo_pago;

    @OneToMany(targetEntity = Detalle_Pedido.class, fetch = FetchType.LAZY, mappedBy = "pedido")
    private List<Detalle_Pedido> detalle_pedido;

}

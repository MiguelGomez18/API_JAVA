package com.VenTrix.com.VenTrix.Entidades;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_producto;


    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = true, length = 200)
    private String descripcion;

    @Column(nullable = false)
    private float precio;

    @Column(nullable = true, length = 1000)
    private String imagen;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Disponibilidad disponibilidad;

    @OneToMany(targetEntity = Detalle_Pedido.class, mappedBy = "producto", cascade = CascadeType.ALL)
    private List<Detalle_Pedido> detalle_pedido;





}

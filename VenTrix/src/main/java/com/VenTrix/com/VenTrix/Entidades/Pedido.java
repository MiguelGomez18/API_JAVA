package com.VenTrix.com.VenTrix.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pedido;

    @Column(nullable = false)
    private  int numero_pedido;

    @Column(nullable = false, columnDefinition = "DATE")
    private LocalDate fecha_pedido;

    @Column(nullable = false, columnDefinition = "DATE")
    private LocalDate hora_pedido;

    @Column(nullable = false)
    private float total_pedido;















}

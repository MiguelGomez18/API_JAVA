package com.VenTrix.com.VenTrix.Entidades;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data // Incluye los getters, setters y toString
@NoArgsConstructor
@AllArgsConstructor
public class Sucursal {

    // Atributos de la clase Sucursal

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_sucursal;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 200)
    private String direccion;

    @Column(nullable = false, length = 100)
    private String ciudad;

    @Column(nullable = false, length = 10)
    private String telefono;

    @Column(nullable = false, columnDefinition = "DATE")
    private LocalDate fecha_apertura;

    @Enumerated(EnumType.STRING)
    private Estado_Sucursal estado;

    @ManyToOne(targetEntity = Restaurante.class)
    @JoinColumn(name = "id_restaurante")
    private Restaurante restaurante;


}

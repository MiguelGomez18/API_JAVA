package com.VenTrix.com.VenTrix.Entidades;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data // Incluye los getters, setters y toString
@NoArgsConstructor
@AllArgsConstructor
public class Restaurante {

    // Atributos de la clase Restaurante

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_restaurante;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = true, length = 200)
    private String descripcion;

    @Column(nullable = false, length = 10)
    private String telefono;

    @Column(nullable = false, length = 200)
    private String direccion;

    @Column(nullable = false, length = 100)
    private String correo;

    @Column(nullable = false)
    private String imagen;

    @Column(nullable = false, columnDefinition = "DATE")
    private LocalDate fecha_creacion;

    @Column(nullable = false, columnDefinition = "DATE")
    private LocalDate fecha_finalizacion;

    @Enumerated(EnumType.STRING)
    private Estado_Restaurante estado;

    @ManyToOne(targetEntity = Usuario.class)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

}

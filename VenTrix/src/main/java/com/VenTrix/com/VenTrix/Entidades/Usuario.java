package com.VenTrix.com.VenTrix.Entidades;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data // Incluye los getters, setters y toString
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "contrasenia")
public class Usuario {

    // Atributos de la clase Usuario

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuario;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String correo;

    @Column(nullable = false, length = 50)
    private String contrasenia;

    @Enumerated(EnumType.STRING)
    private Rol_Usuario rol;

    @Column(nullable = false, columnDefinition = "DATE")
    private LocalDate fecha_creacion;

    @OneToMany(targetEntity = Restaurante.class, fetch = FetchType.LAZY, mappedBy = "usuario")
    private List<Restaurante> restaurantes;

}

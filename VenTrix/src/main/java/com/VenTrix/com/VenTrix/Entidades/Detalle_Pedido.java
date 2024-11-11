package com.VenTrix.com.VenTrix.Entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // Incluye los getters, setters y toString
@NoArgsConstructor
@AllArgsConstructor
public class Detalle_Pedido {

     // Atributos de la clase Detalle_Pedido
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id_detalle_pedido;

     @Column(nullable = false)
     private int cantidad;

     @Column(nullable = false)
     private float precio_unitario;

     @Column(nullable = false)
     private float precio_total;

     @ManyToOne
     @JoinColumn(name = "id_producto")
     private Producto producto;
}

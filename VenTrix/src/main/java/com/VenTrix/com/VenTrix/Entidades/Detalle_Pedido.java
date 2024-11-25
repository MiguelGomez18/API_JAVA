package com.VenTrix.com.VenTrix.Entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

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

     @Column(nullable = false, columnDefinition = "TIME")
     private LocalTime hora_detalle;

     @Column(nullable = true, length = 200)
     private String descripcion;

     @Column(nullable = false)
     private float precio_total;

     @Column(nullable = false)
     private String sucursal;

     @ManyToOne(targetEntity = Producto.class)
     @JoinColumn(name = "id_producto")
     @JsonIncludeProperties({"id_producto", "nombre", "imagen"})
     private Producto producto;

     @ManyToOne(targetEntity = Pedido.class)
     @JoinColumn(name = "id_pedido")
     @JsonIncludeProperties({"id_pedido, fecha_pedido"})
     private Pedido pedido;
}

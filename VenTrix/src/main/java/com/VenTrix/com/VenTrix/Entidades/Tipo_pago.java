
package com.VenTrix.com.VenTrix.Entidades;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tipo_pago")
public class Tipo_pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String descripcion;

    @OneToMany(targetEntity = Pedido.class, fetch = FetchType.LAZY, mappedBy = "tipo_pago")
    @JsonManagedReference
    private List<Pedido> pedidos;
}


package com.VenTrix.com.VenTrix.Entidades;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
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

    @Column(nullable = false)
    private String sucursal;

    @OneToMany(targetEntity = Pedido.class, fetch = FetchType.LAZY, mappedBy = "tipo_pago")
    @JsonIncludeProperties("id_pedidos")
    private List<Pedido> pedidos;
}

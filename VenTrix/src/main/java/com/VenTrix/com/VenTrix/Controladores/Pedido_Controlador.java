package com.VenTrix.com.VenTrix.Controladores;

import java.io.IOException;
import java.util.List;

import com.VenTrix.com.VenTrix.Entidades.Estado_Pedido;
import com.VenTrix.com.VenTrix.Entidades.Pedido;
import com.VenTrix.com.VenTrix.Entidades.Tipo_pago;
import com.VenTrix.com.VenTrix.Servicios.Pedido_Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/pedidos")
public class Pedido_Controlador {

    @Autowired
    private Pedido_Servicio pedidoServicio;

    @PostMapping
    public int crearPedido(@RequestBody Pedido pedido) {
        int id = pedidoServicio.crearPedido(pedido);
        return id;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> actualizarPedido(@PathVariable int id,
                                   @RequestParam("total_pedido") float total_pedido,
                                   @RequestParam("tipo_pago") Tipo_pago tipo_pago,
                                   @RequestParam("estado") Estado_Pedido estado) {

        Pedido pedidoExistente = pedidoServicio.obtenerPedidoPorId(id);

        pedidoExistente.setTotal_pedido(total_pedido);
        pedidoExistente.setTipo_pago(tipo_pago);
        pedidoExistente.setEstado(estado);

        Pedido pedidoActualizado = pedidoServicio.actualizarPedido(id, pedidoExistente);

        return new ResponseEntity<>(pedidoActualizado, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Pedido obtenerPedido(@PathVariable int id) {
        return pedidoServicio.obtenerPedidoPorId(id);
    }

    @GetMapping
    public List<Pedido> obtenerTodosLosPedidos() {
        return pedidoServicio.obtenerTodosLosPedidos();
    }

    @DeleteMapping("/{id}")
    public void eliminarPedido(@PathVariable int id) {
        pedidoServicio.eliminarPedido(id);
    }

}

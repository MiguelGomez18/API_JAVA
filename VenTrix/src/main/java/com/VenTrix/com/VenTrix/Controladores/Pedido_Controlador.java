package com.VenTrix.com.VenTrix.Controladores;

import java.util.List;
import com.VenTrix.com.VenTrix.Entidades.Pedido;
import com.VenTrix.com.VenTrix.Servicios.Pedido_Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class Pedido_Controlador {

    @Autowired
    private Pedido_Servicio pedidoServicio;

    @PostMapping
    public Pedido crearPedido(@RequestBody Pedido pedido) {
        return pedidoServicio.crearPedido(pedido);
    }

    @PutMapping("/{id}")
    public Pedido actualizarPedido(@PathVariable int id, @RequestBody Pedido pedido) {
        return pedidoServicio.actualizarPedido(id, pedido);
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

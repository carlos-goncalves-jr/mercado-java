package com.acme.supermercado.controllers;

import com.acme.supermercado.dtos.TotalDTO;
import com.acme.supermercado.services.interfaces.PedidoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private final PedidoInterface pedidoService;

    @Autowired
    public PedidoController(PedidoInterface pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TotalDTO> totalizarPedido(@PathVariable Long id) {
        return ResponseEntity.ok(pedidoService.resumoPedido(id));
    }
}

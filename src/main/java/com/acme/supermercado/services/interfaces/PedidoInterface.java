package com.acme.supermercado.services.interfaces;

import com.acme.supermercado.dtos.TotalDTO;

public interface PedidoInterface {
    TotalDTO resumoPedido(Long idCarrinho);
    Double encerrarPedido(Long idCarrinho);
}

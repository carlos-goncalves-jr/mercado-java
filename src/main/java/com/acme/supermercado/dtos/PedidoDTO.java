package com.acme.supermercado.dtos;

import com.acme.supermercado.entities.Produto;

public record PedidoDTO(Produto produto, Integer quantidade, Integer valor){
}

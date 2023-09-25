package com.acme.supermercado.dtos;

import java.util.List;

public record TotalDTO(List<PedidoDTO> pedidoDTOS, Integer valorTotal) {
}

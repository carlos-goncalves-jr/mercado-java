package com.acme.supermercado.dtos;

import com.acme.supermercado.entities.enums.UnidadeDeMedida;

public record ProdutoDTO(String nome, UnidadeDeMedida unidadeDeMedida, Long idCategoria, Integer valor) {
}

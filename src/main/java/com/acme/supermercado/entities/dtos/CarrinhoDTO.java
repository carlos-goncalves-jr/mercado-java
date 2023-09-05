package com.acme.supermercado.entities.dtos;

import com.acme.supermercado.entities.Carrinho;
import com.acme.supermercado.entities.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarrinhoDTO {
    private Long id;

    private Map<Produto,Integer> mapDeProdutos;

    public CarrinhoDTO(Carrinho carrinho) {
        this.id = carrinho.getId();
        this.mapDeProdutos = carrinho.getMapDeProdutos();
    }
}

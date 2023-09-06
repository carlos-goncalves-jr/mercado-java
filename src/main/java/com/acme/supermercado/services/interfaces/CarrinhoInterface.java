package com.acme.supermercado.services.interfaces;

import com.acme.supermercado.dtos.PedidoDTO;
import com.acme.supermercado.entities.Carrinho;

public interface CarrinhoInterface {

    Carrinho adicionarProduto(Long id, PedidoDTO pedidoDTO);
    void removerProduto(Long id, PedidoDTO pedidoDTO);
    Carrinho listarCarrinho(Long id);

    Carrinho criarCarrinho();
}

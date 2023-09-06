package com.acme.supermercado.services.interfaces;

import com.acme.supermercado.dtos.ProdutoDTO;
import com.acme.supermercado.entities.Carrinho;

public interface CarrinhoInterface {

    Carrinho adicionarProduto(Long id, ProdutoDTO produtoDTO);
    void removerProduto(Long id, ProdutoDTO produtoDTO);
    Carrinho listarCarrinho(Long id);

    Carrinho criarCarrinho();
}

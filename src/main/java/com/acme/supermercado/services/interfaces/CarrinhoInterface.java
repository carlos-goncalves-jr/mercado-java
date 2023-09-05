package com.acme.supermercado.services.interfaces;

import com.acme.supermercado.entities.Carrinho;
import com.acme.supermercado.entities.ProdutoCarrinho;

public interface CarrinhoInterface {

    Carrinho adicionarProduto(Long id, ProdutoCarrinho produtoCarrinho);
    void removerProduto(Long id, ProdutoCarrinho produtoCarrinho);
    Carrinho listarCarrinho(Long id);

    Carrinho criarCarrinho();
}

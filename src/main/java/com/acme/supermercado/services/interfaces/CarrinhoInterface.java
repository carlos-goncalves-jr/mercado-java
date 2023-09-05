package com.acme.supermercado.services.interfaces;

import com.acme.supermercado.entities.Carrinho;
import com.acme.supermercado.entities.dtos.CarrinhoDTO;
import com.acme.supermercado.entities.dtos.ProdutoDTO;

public interface CarrinhoInterface {

    Carrinho adicionarProduto(Long id, ProdutoDTO produtoDto);
    void removerProduto(Long id, ProdutoDTO produtoDto );
    CarrinhoDTO listarCarrinho(Long id);

    Carrinho criarCarrinho();
}

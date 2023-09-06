package com.acme.supermercado.services.interfaces;

import com.acme.supermercado.dtos.CarrinhoDTO;
import com.acme.supermercado.entities.Carrinho;

public interface CarrinhoInterface {

    Carrinho adicionarProduto(Long id, CarrinhoDTO carrinhoDTO);
    void removerProduto(Long id, CarrinhoDTO carrinhoDTO);
    Carrinho listarCarrinho(Long id);

    Carrinho criarCarrinho();
}

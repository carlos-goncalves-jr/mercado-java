package com.acme.supermercado.services.interfaces;


import com.acme.supermercado.entities.Produto;

import java.util.List;

public interface ProdutoInterface {

    Produto findById(Long id);
    Produto findByNome(String nome);
    List<Produto> findAll();

    Produto createProduto(Produto produto);
    Produto updateProduto(Long id ,Produto newProduto);

    void deleteProdutoById(Long id);
}

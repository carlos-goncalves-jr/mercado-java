package com.acme.supermercado.services.interfaces;


import com.acme.supermercado.dtos.ProdutoDTO;
import com.acme.supermercado.entities.Produto;

import java.util.List;

public interface ProdutoInterface {

    Produto findById(Long id);
    Produto findByNome(String nome);
    List<Produto> findAll();

    Produto createProduto(ProdutoDTO produto);
    Produto updateProduto(Long id , ProdutoDTO newProduto);

    void deleteProdutoById(Long id);
}

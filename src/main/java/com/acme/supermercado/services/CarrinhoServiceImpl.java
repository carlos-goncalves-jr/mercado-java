package com.acme.supermercado.services;

import com.acme.supermercado.entities.Carrinho;
import com.acme.supermercado.entities.ProdutoCarrinho;
import com.acme.supermercado.exceptions.IdNotFoundException;
import com.acme.supermercado.repositories.CarrinhoRepository;
import com.acme.supermercado.services.interfaces.CarrinhoInterface;
import com.acme.supermercado.services.interfaces.ProdutoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarrinhoServiceImpl implements CarrinhoInterface {

    @Autowired
    CarrinhoRepository carrinhoRepository;

    @Autowired
    ProdutoInterface produtoService;

    @Override
    public Carrinho adicionarProduto(Long id, ProdutoCarrinho produtoCarrinho) {
        Carrinho carrinho = findById(id);
        produtoService.findById(produtoCarrinho.getId_produto());
        carrinho.getListaDeProdutos().add(produtoCarrinho);
        return carrinhoRepository.save(carrinho);
    }

    @Override
    public void removerProduto(Long id, ProdutoCarrinho produtoCarrinho) {
        Carrinho carrinho = findById(id);
        carrinho.getListaDeProdutos().remove(produtoCarrinho);
        carrinhoRepository.save(carrinho);
    }

    @Override
    public Carrinho listarCarrinho(Long id) {
        return findById(id);
    }

    @Override
    public Carrinho criarCarrinho() {
        return carrinhoRepository.save(new Carrinho());
    }

    public Carrinho findById(Long id) {
        return carrinhoRepository.findById(id).orElseThrow(() -> new IdNotFoundException("ID NAO ENCONTRADO : " + id));
    }
}

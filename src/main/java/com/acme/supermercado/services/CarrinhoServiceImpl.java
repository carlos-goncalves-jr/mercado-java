package com.acme.supermercado.services;

import com.acme.supermercado.dtos.CarrinhoDTO;
import com.acme.supermercado.entities.Carrinho;
import com.acme.supermercado.entities.Produto;
import com.acme.supermercado.exceptions.IdNotFoundException;
import com.acme.supermercado.repositories.CarrinhoRepository;
import com.acme.supermercado.services.interfaces.CarrinhoInterface;
import com.acme.supermercado.services.interfaces.ProdutoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarrinhoServiceImpl implements CarrinhoInterface {

    @Autowired
    private final CarrinhoRepository carrinhoRepository;

    @Autowired
    private final ProdutoInterface produtoService;

    @Autowired
    public CarrinhoServiceImpl(CarrinhoRepository carrinhoRepository, ProdutoInterface produtoService) {
        this.carrinhoRepository = carrinhoRepository;
        this.produtoService = produtoService;
    }

    @Override
    public Carrinho adicionarProduto(Long id, CarrinhoDTO carrinhoDTO) {
        Carrinho carrinho = findById(id);
        Produto produto = produtoService.findById(carrinhoDTO.idProduto());
        carrinho.getMapDeProdutos().put(produto.getNome(), carrinhoDTO.quantidade());
        return carrinhoRepository.save(carrinho);
    }

    @Override
    public void removerProduto(Long id, CarrinhoDTO carrinhoDTO) {
        Carrinho carrinho = findById(id);
        Produto produto = produtoService.findById(carrinhoDTO.idProduto());
        carrinho.getMapDeProdutos().remove(produto.getNome());
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

package com.acme.supermercado.services;

import com.acme.supermercado.entities.Carrinho;
import com.acme.supermercado.entities.Produto;
import com.acme.supermercado.entities.dtos.CarrinhoDTO;
import com.acme.supermercado.entities.dtos.ProdutoDTO;
import com.acme.supermercado.exceptions.IdNotFoundException;
import com.acme.supermercado.repositories.CarrinhoRepository;
import com.acme.supermercado.services.interfaces.CarrinhoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarrinhoServiceImpl implements CarrinhoInterface {

    @Autowired
    CarrinhoRepository carrinhoRepository;

    @Override
    public Carrinho adicionarProduto(Long id, ProdutoDTO produtoDto) {
        Carrinho carrinho = findById(id);
        Produto produto = new Produto(produtoDto);
        carrinho.getMapDeProdutos().put(produto, produtoDto.getQuantidade());
        return carrinhoRepository.save(carrinho);
    }

    @Override
    public void removerProduto(Long id, ProdutoDTO produtoDto) {
        Carrinho carrinho = findById(id);
        Produto produto = new Produto(produtoDto);
        carrinho.getMapDeProdutos().remove(produto);
        carrinhoRepository.save(carrinho);
    }

    @Override
    public CarrinhoDTO listarCarrinho(Long id) {
        return new CarrinhoDTO(findById(id));
    }

    @Override
    public Carrinho criarCarrinho() {
        return carrinhoRepository.save(new Carrinho());
    }

    public Carrinho findById(Long id) {
        return carrinhoRepository.findById(id).orElseThrow(() -> new IdNotFoundException("ID NAO ENCONTRADO : " + id));
    }
}

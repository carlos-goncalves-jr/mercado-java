package com.acme.supermercado.services;

import com.acme.supermercado.entities.Produto;
import com.acme.supermercado.exceptions.DuplicateException;
import com.acme.supermercado.exceptions.IdNotFoundException;
import com.acme.supermercado.exceptions.NomeNotFoundException;
import com.acme.supermercado.repositories.ProdutoRepository;
import com.acme.supermercado.services.interfaces.ProdutoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoInterface {


    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public Produto findById(Long id) {
        return produtoRepository.findById(id).orElseThrow(() -> new IdNotFoundException("ID NÃO ENCONTRADO : " + id));
    }

    @Override
    public Produto findByNome(String nome) {
        return produtoRepository.findByNome(nome).orElseThrow(() -> new NomeNotFoundException("NOME NAO ENCONTRADO : " + nome));
    }

    @Override
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto createProduto(Produto produto) {
        if(checkProdutoExistence(produto)) {
            throw new DuplicateException("PRODUTO JA CADASTRADO : " + produto.getNome());
        }
        return produtoRepository.save(produto);
    }

    @Override
    public Produto updateProduto(Long id, Produto produto) {
        Produto novoProduto = produtoRepository.findById(id).orElseThrow(() -> new IdNotFoundException("ID NAO ENCONTRADO : " + id));
        novoProduto.setNome(produto.getNome());
        novoProduto.setCategoria(produto.getCategoria());
        novoProduto.setUnidadeDeMedida(produto.getUnidadeDeMedida());
        return produtoRepository.save(novoProduto);
    }

    @Override
    public void deleteProdutoById(Long id) {
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new IdNotFoundException("ID NAO ENCONTRADO : " + id));
        produtoRepository.deleteById(id);
    }

    public boolean checkProdutoExistence(Produto produto) {
        return produtoRepository.existsByNome(produto.getNome());
    }
}

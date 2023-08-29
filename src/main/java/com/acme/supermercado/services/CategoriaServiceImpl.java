package com.acme.supermercado.services;

import com.acme.supermercado.entities.Categoria;
import com.acme.supermercado.exceptions.DuplicateCategoriaException;
import com.acme.supermercado.exceptions.NomeNotFoundException;
import com.acme.supermercado.repositories.CategoriaRepository;
import com.acme.supermercado.exceptions.ExceptionObject;
import com.acme.supermercado.exceptions.IdNotFoundException;
import com.acme.supermercado.services.interfaces.CategoriaInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaInterface {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public Categoria findById(Long id) {
        return categoriaRepository.findById(id).orElseThrow(() -> new IdNotFoundException("ID NAO ENCONTRADO : " + id));
    }

    @Override
    public Categoria findByNome(String nome) {
        return categoriaRepository.findByNome(nome).orElseThrow(() -> new NomeNotFoundException("NOME NAO ENCONTRADO : " + nome));
    }

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria createCategoria(Categoria categoria) {
        if(checkCategoriaExistence(categoria)) {
            throw new DuplicateCategoriaException("CATEGORIA JA EXISTENTE : " + categoria.getNome());
        }
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria updateCategoria(Long id, Categoria novaCategoria) {
        Categoria categoriaAtual = categoriaRepository.findById(id).orElseThrow(() -> new IdNotFoundException("ID NAO ENCONTRADO : " + id));
        if(checkCategoriaExistence(novaCategoria)) {
            throw new DuplicateCategoriaException("CATEGORIA JA EXISTENTE : " + novaCategoria.getNome());
        }
        categoriaAtual.setNome(novaCategoria.getNome());
        return categoriaRepository.save(categoriaAtual);

    }

    @Override
    public void deleteCategoria(Long id) {
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(() -> new IdNotFoundException("ID NAO ENCONTRADO : " + id));
        categoriaRepository.deleteById(id);
    }

    public boolean checkCategoriaExistence(Categoria categoria) {
        return categoriaRepository.existsByNome(categoria.getNome());
    }
}

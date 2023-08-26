package com.acme.supermercado.services.interfaces;

import com.acme.supermercado.entities.Categoria;

import java.util.List;

public interface CategoriaInterface {

    Categoria findById(Long id);
    Categoria findByNome(String nome);
    List<Categoria> findAll();

    Categoria createCategoria(Categoria categoria);
    Categoria updateCategoria(Long id ,Categoria newCategoria);

    void deleteCategoria(Long id);
}

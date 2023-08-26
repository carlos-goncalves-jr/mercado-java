package com.acme.supermercado.services;

import com.acme.supermercado.entities.Categoria;
import com.acme.supermercado.repositories.CategoriaRepository;
import com.acme.supermercado.services.interfaces.CategoriaInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService implements CategoriaInterface {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public Categoria findById(Long id) {
        return categoriaRepository.findById(id).orElseThrow();
    }

    @Override
    public Categoria findByNome(String nome) {
        return categoriaRepository.findByNome(nome).orElseThrow();
    }

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria createCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria updateCategoria(Long id, Categoria novaCategoria) {
        Categoria categoriaAtual = categoriaRepository.findById(id).orElseThrow();
        categoriaAtual.setNome(novaCategoria.getNome());
        return categoriaRepository.save(categoriaAtual);
    }

    @Override
    public void deleteCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
}

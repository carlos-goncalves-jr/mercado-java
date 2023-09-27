package com.acme.supermercado.services;

import com.acme.supermercado.entities.Categoria;
import com.acme.supermercado.entities.Produto;
import com.acme.supermercado.exceptions.DuplicateException;
import com.acme.supermercado.exceptions.IdNotFoundException;
import com.acme.supermercado.exceptions.NomeNotFoundException;
import com.acme.supermercado.repositories.CategoriaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CategoriaServiceTest {

    @InjectMocks
    CategoriaServiceImpl categoriaService;

    @Mock
    CategoriaRepository categoriaRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    @DisplayName("testCategoriaCreateCategoria")
    public void testCreateCategoria() {
        Categoria categoria = new Categoria(1L, "Alimentos", new ArrayList<>());
        Mockito.when(categoriaRepository.save(categoria)).thenReturn(categoria);

        Categoria result = categoriaService.createCategoria(categoria);
        assertEquals(result.getId(), categoria.getId());
    }

    @Test
    @DisplayName("testCategoriaCreateCategoriaDuplicateException")
    public void testCreateCategoriaDuplicateException() {
        Categoria categoria = new Categoria(1L, "Alimentos", new ArrayList<>());

        Mockito.when(categoriaRepository.save(categoria)).thenReturn(categoria);
        Mockito.when(categoriaRepository.existsByNome(categoria.getNome())).thenReturn(true);

        assertThrows(DuplicateException.class, () -> categoriaService.createCategoria(categoria));
    }



    @Test
    @DisplayName("testCategoriaFindById")
    public void testFindById() {
        List<Produto> produtos = new ArrayList<>();
        Categoria categoria3 = new Categoria(3L, "Peixes",produtos);

        Mockito.when(categoriaRepository.findById(3L)).thenReturn(Optional.of(categoria3));
        Categoria resultado = categoriaService.findById(3L);

        assertEquals(categoria3.getNome(), resultado.getNome());
    }

    @Test
    @DisplayName("testCategoriaFindByIdNotFoundException")
    public void testFindByIdNotFoundException() {
        Categoria categoria = new Categoria(3L, "Peixes",new ArrayList<>());

        Mockito.when(categoriaRepository.findById(3L)).thenReturn(Optional.of(categoria));
        assertThrows(IdNotFoundException.class, () -> categoriaService.findById(1L));
    }

    @Test
    @DisplayName("testCategoriaFindByNome")
    public void testFindByNome() {
        Categoria categoria = new Categoria(3L, "Peixes",new ArrayList<>());

        Mockito.when(categoriaRepository.findByNome("Peixes")).thenReturn(Optional.of(categoria));
        Categoria resultado = categoriaService.findByNome("Peixes");

        assertEquals(categoria.getNome(), resultado.getNome());
    }

    @Test
    @DisplayName("testCategoriaFindByNomeNotFoundException")
    public void testFindByNomeNotFoundException() {
        Categoria categoria = new Categoria(1L, "Peixes",new ArrayList<>());

        Mockito.when(categoriaRepository.findByNome("Peixes")).thenReturn(Optional.of(categoria));

        assertThrows(NomeNotFoundException.class, () -> categoriaService.findByNome("Leite"));
    }

    @Test
    @DisplayName("testCategoriafindAll")
    public void testFindAll() {
        List<Categoria> listaDeCategorias = new ArrayList<>(){{
            add(new Categoria(1L, "Peixes",new ArrayList<>()));
            add(new Categoria(2L, "Frutas",new ArrayList<>()));
            add(new Categoria(3L, "Alimentos",new ArrayList<>()));
            add(new Categoria(4L, "Bebidas",new ArrayList<>()));
        }};

        categoriaRepository.saveAll(listaDeCategorias);
        Mockito.when(categoriaRepository.findAll()).thenReturn(listaDeCategorias);

        assertEquals(4, listaDeCategorias.size());
    }


    @Test
    @DisplayName("testCategoriaUpdateCategoria")
    public void testUpdateCategoria() {
        Categoria categoria = new Categoria(2L, "Peixes",new ArrayList<>());
        Categoria categoria2 = new Categoria(2L, "Frutas",new ArrayList<>());

        Mockito.when(categoriaRepository.findById(2L)).thenReturn(Optional.of(categoria));
        Mockito.when(categoriaRepository.save(categoria2)).thenReturn(categoria2);
        Categoria resultado = categoriaService.updateCategoria(2L, categoria2);

        assertEquals(categoria2.getNome(), resultado.getNome());
    }

    @Test
    @DisplayName("testCategoriaUpdateCategoriaDuplicateException")
    public void testUpdateCategoriaDuplicateException() {
        Categoria categoria = new Categoria(2L, "Peixes",new ArrayList<>());

        Mockito.when(categoriaRepository.findById(2L)).thenReturn(Optional.of(categoria));
        Mockito.when(categoriaRepository.save(categoria)).thenReturn(categoria);
        Mockito.when(categoriaRepository.existsByNome(categoria.getNome())).thenReturn(true);

        assertThrows(DuplicateException.class, () -> categoriaService.updateCategoria(2L, categoria));

    }

}

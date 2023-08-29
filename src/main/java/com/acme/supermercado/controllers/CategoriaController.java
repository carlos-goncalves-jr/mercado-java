package com.acme.supermercado.controllers;

import com.acme.supermercado.entities.Categoria;
import com.acme.supermercado.services.CategoriaService;
import com.acme.supermercado.services.interfaces.CategoriaInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoriaInterface categoriaService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Categoria> findById(@PathVariable Long id) {
        return ResponseEntity.ok(categoriaService.findById(id));
    }

    @GetMapping(value = "/nome/{nome}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Categoria> findByNome(@PathVariable String nome) {
        return ResponseEntity.ok(categoriaService.findByNome(nome));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Categoria> findAll() {
        return categoriaService.findAll();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Categoria> createCategoria(@RequestBody Categoria categoria) {
        return ResponseEntity.ok(categoriaService.createCategoria(categoria));
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Categoria> updateCategoria(@PathVariable Long id, @RequestBody Categoria novaCategoria) {
        return ResponseEntity.ok(categoriaService.updateCategoria(id, novaCategoria));
    }

    @DeleteMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> deleteCategoria(@PathVariable Long id) {
        categoriaService.deleteCategoria(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

package com.acme.supermercado.controllers;

import com.acme.supermercado.entities.Categoria;
import com.acme.supermercado.services.interfaces.CategoriaInterface;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoriaInterface categoriaService;

    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Retorna a categoria com sucesso"),
            @ApiResponse(responseCode = "404", description = "Id não encontrado")
    })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Categoria> findById(@PathVariable Long id) {
        return ResponseEntity.ok(categoriaService.findById(id));
    }

    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Retorna a categoria com sucesso"),
            @ApiResponse(responseCode = "404", description = "Id não encontrado")
    })
    @GetMapping(value = "/nome/{nome}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Categoria> findByNome(@PathVariable String nome) {
        return ResponseEntity.ok(categoriaService.findByNome(nome));
    }

    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Retorna a categoria com sucesso"),
            @ApiResponse(responseCode = "404", description = "Id não encontrado")
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Categoria> findAll() {
        return categoriaService.findAll();
    }


    @ApiResponses( value = {
            @ApiResponse(responseCode = "201", description = "Categoria criada com sucesso"),
            @ApiResponse(responseCode = "409", description = "Categoria ja cadastrada")
    })
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Categoria> createCategoria(@RequestBody Categoria categoria) {
        return new ResponseEntity<>(categoriaService.createCategoria(categoria), HttpStatus.CREATED);
    }

    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Categoria atualizada com sucesso"),
            @ApiResponse(responseCode = "409", description = "Categoria ja cadastrada")
    })
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Categoria> updateCategoria(@PathVariable Long id, @RequestBody Categoria novaCategoria) {
        return ResponseEntity.ok(categoriaService.updateCategoria(id, novaCategoria));
    }

    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Categoria removida com sucesso"),
            @ApiResponse(responseCode = "404", description = "Id não encontrado")
    })
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> deleteCategoria(@PathVariable Long id) {
        categoriaService.deleteCategoria(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

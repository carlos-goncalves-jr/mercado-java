package com.acme.supermercado.controllers;

import com.acme.supermercado.dtos.ProdutoDTO;
import com.acme.supermercado.entities.Produto;
import com.acme.supermercado.services.interfaces.ProdutoInterface;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoInterface produtoService;


    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Retorna o produto com sucesso"),
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Produto>> findAll() {
        return ResponseEntity.ok(produtoService.findAll());
    }

    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Retorna o produto com sucesso"),
            @ApiResponse(responseCode = "404", description = "Id não encontrado")
    })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Produto> findByid(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.findById(id));
    }

    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Retorna o produto com sucesso"),
            @ApiResponse(responseCode = "404", description = "Id não encontrado")
    })
    @GetMapping(value = "/nome/{nome}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Produto> findByNome(@PathVariable String nome) {
        return ResponseEntity.ok(produtoService.findByNome(nome));
    }

    @ApiResponses( value = {
            @ApiResponse(responseCode = "201", description = "Produto criado com sucesso"),
            @ApiResponse(responseCode = "409", description = "Produto ja cadastrado")
    })
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Produto> createProduto(@RequestBody ProdutoDTO produtoDTO) {
        return new ResponseEntity<Produto>(produtoService.createProduto(produtoDTO), HttpStatus.CREATED);
    }

    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso"),
            @ApiResponse(responseCode = "409", description = "Produto ja cadastrado")
    })
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Produto> updateProduto(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO) {
        return ResponseEntity.ok(produtoService.updateProduto(id, produtoDTO));
    }

    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Produto removido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Id não encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteProduto(@PathVariable Long id) {
        produtoService.deleteProdutoById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}

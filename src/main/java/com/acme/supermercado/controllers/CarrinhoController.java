package com.acme.supermercado.controllers;

import com.acme.supermercado.dtos.ProdutoDTO;
import com.acme.supermercado.entities.Carrinho;
import com.acme.supermercado.services.interfaces.CarrinhoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    @Autowired
    CarrinhoInterface carrinhoService;

    @GetMapping("/{id}")
    public ResponseEntity<Carrinho> listarCarrinho(@PathVariable Long id) {
        return ResponseEntity.ok(carrinhoService.listarCarrinho(id));
    }

    @PostMapping("/{id}")
    public ResponseEntity<Carrinho> adicionarProduto(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO) {
        return new ResponseEntity<Carrinho>(carrinhoService.adicionarProduto(id, produtoDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> removerProduto(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO) {
        carrinhoService.removerProduto(id, produtoDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Carrinho> criarCarrinho() {
        Carrinho carrinho = carrinhoService.criarCarrinho();
        return new ResponseEntity<>(carrinho, HttpStatus.CREATED);
    }
}

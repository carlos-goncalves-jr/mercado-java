package com.acme.supermercado.controllers;

import com.acme.supermercado.dtos.CarrinhoDTO;
import com.acme.supermercado.entities.Carrinho;
import com.acme.supermercado.services.interfaces.CarrinhoInterface;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    @Autowired
    private final CarrinhoInterface carrinhoService;

    @Autowired
    public CarrinhoController(CarrinhoInterface carrinhoService) {
        this.carrinhoService = carrinhoService;
    }

    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Retorna os produtos e quantidades com sucesso"),
    })
    @GetMapping("/{id}")
    public ResponseEntity<Carrinho> listarCarrinho(@PathVariable Long id) {
        return ResponseEntity.ok(carrinhoService.listarCarrinho(id));
    }

    @ApiResponses( value = {
            @ApiResponse(responseCode = "201", description = "Adiciona o produto x quantidade ao carrinho"),
    })
    @PostMapping("/{id}")
    public ResponseEntity<Carrinho> adicionarProduto(@PathVariable Long id, @RequestBody CarrinhoDTO carrinhoDTO) {
        return new ResponseEntity<Carrinho>(carrinhoService.adicionarProduto(id, carrinhoDTO), HttpStatus.CREATED);
    }

    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Produto removido do carrinho com sucesso"),
            @ApiResponse(responseCode = "404", description = "Id do Produto não encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> removerProduto(@PathVariable Long id, @RequestBody CarrinhoDTO carrinhoDTO) {
        carrinhoService.removerProduto(id, carrinhoDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiResponses( value = {
            @ApiResponse(responseCode = "201", description = "Retorna um carrinho novo"),
    })
    @GetMapping
    public ResponseEntity<Carrinho> criarCarrinho() {
        Carrinho carrinho = carrinhoService.criarCarrinho();
        return new ResponseEntity<>(carrinho, HttpStatus.CREATED);
    }
}

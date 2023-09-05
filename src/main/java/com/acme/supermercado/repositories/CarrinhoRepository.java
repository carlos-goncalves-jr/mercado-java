package com.acme.supermercado.repositories;

import com.acme.supermercado.entities.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {

}

package com.acme.supermercado.repositories;

import com.acme.supermercado.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Optional<Produto> findByNome(String nome);

    boolean existsByNome(String nome);
}

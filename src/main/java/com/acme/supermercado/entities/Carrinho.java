package com.acme.supermercado.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TBL_CARRINHO")
public class Carrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    @CollectionTable(name = "tbl_produto_quantidade", joinColumns = @JoinColumn(name = "carrinho_id"))
    @MapKeyColumn(name = "nome")
    @Column(name = "quantidade_produto")
    private Map<String, Integer> mapDeProdutos;

}

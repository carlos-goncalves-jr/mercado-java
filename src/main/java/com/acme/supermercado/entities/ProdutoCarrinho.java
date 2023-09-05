package com.acme.supermercado.entities;

import com.acme.supermercado.entities.enums.UnidadeDeMedida;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TBL_PRODUTO_CARRINHO")
public class ProdutoCarrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProdutoCarrinho;

    private Long id_produto;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Carrinho id_carrinho;

    private String nome;
    private UnidadeDeMedida unidadeDeMedida;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;
    private Integer valor;
    private Integer quantidade;



}

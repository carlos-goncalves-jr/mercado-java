package com.acme.supermercado.entities;

import com.acme.supermercado.entities.enums.UnidadeDeMedida;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TBL_PRODUTO")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String nome;
    @Enumerated(EnumType.STRING)
    private UnidadeDeMedida unidadeDeMedida;
    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;
    @NotNull
    private Integer valor;

    public Produto(ProdutoCarrinho produtoCarrinho) {
        this.id = produtoCarrinho.getId_produto();
        this.nome = produtoCarrinho.getNome();
        this.unidadeDeMedida = produtoCarrinho.getUnidadeDeMedida();
        this.categoria = produtoCarrinho.getCategoria();
        this.valor = produtoCarrinho.getValor();
    }

}

package com.acme.supermercado.entities;

import com.acme.supermercado.dtos.ProdutoDTO;
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

    public Produto(ProdutoDTO produtoDto, Categoria categoria) {
        this.nome = produtoDto.nome();
        this.valor = produtoDto.valor();
        this.unidadeDeMedida = produtoDto.unidadeDeMedida();
        this.valor = produtoDto.valor();
        this.categoria = categoria;
    }
}

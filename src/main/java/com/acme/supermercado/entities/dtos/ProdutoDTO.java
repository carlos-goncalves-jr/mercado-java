package com.acme.supermercado.entities.dtos;

import com.acme.supermercado.entities.Categoria;
import com.acme.supermercado.entities.enums.UnidadeDeMedida;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {

    private Long id;
    private String nome;
    private UnidadeDeMedida unidadeDeMedida;
    private Categoria categoria;
    private Integer valor;
    private Integer quantidade;

}

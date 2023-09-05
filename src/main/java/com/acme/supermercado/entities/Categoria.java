package com.acme.supermercado.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "TBL_CATEGORIA")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String nome;

    @OneToMany(mappedBy = "categoria")
    @JsonIgnore
    private List<Produto> produtos;

    public Categoria(String nome) {
        this.nome = nome;
    }

}

package com.github.produtos.domain.entity;


import com.github.produtos.controller.enums.StatusProduto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private Double price;
    private String description;
    private String tamanho;
    private String genero;
    @Enumerated(EnumType.STRING)
    private StatusProduto status;
}

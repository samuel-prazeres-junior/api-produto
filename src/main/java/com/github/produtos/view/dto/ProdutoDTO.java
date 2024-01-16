package com.github.produtos.view.dto;

import com.github.produtos.controller.enums.StatusProduto;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ProdutoDTO {

    @NotBlank
    private String name;
    @Positive
    private Double price;
    @NotBlank
    @Size(max = 255)
    private String description;
    @NotBlank
    private String tamanho;
    @NotBlank
    private String genero;
    @Enumerated(EnumType.STRING)
    private StatusProduto status;
}

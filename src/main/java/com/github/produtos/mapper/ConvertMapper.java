package com.github.produtos.mapper;

import com.github.produtos.domain.entity.Produto;
import com.github.produtos.view.dto.ProdutoDTO;

public class ConvertMapper {
    public static Produto produtoDTOToProduto(ProdutoDTO dto){
        Produto produto = new Produto();
        produto.setDescription(dto.getDescription());
        produto.setName(dto.getName());
        produto.setPrice(dto.getPrice());
        produto.setGenero(dto.getGenero());
        produto.setTamanho(dto.getTamanho());
        produto.setStatus(dto.getStatus());
        return  produto;
    }
}

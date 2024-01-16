package com.github.produtos.service;

import com.github.produtos.domain.entity.Produto;
import com.github.produtos.view.dto.ProdutoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ProdutoService {

    void salvarProduto(ProdutoDTO produto);
//    Page<Produto> getProdutosAtivos(Pageable pageable);
    List<ProdutoDTO> findAll();
    Produto getProdutoId(UUID uuid);
    void removerProduto(UUID uuid);
}

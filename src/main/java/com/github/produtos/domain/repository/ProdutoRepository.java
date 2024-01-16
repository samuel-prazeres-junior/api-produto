package com.github.produtos.domain.repository;

import com.github.produtos.domain.entity.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, UUID> {
//    Page<Produto> findByProdutoStatus(String status);
}

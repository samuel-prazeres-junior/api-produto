package com.github.produtos.controller;

import com.github.produtos.domain.entity.Produto;
import com.github.produtos.service.ProdutoServiceImpl;
import com.github.produtos.view.dto.ProdutoDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/produtos")
public class ProdutoController {

    private final ProdutoServiceImpl service;

    //    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    public Page<Produto> getProdutosAtivos(Pageable page){
//        return service.getProdutosAtivos(page);
//    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProdutoDTO> getProdutosAtivos() {
        return service.findAll();
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void salvarProduto(@Valid @RequestBody ProdutoDTO dto) {
        service.salvarProduto(dto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{uuid}")
    public Produto getProdutoId(@PathVariable("uuid") UUID uuid) {
        return service.getProdutoId(uuid);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{uuid}")
    public void deleteProduto(@PathVariable UUID uuid) {
        service.removerProduto(uuid);
    }
}

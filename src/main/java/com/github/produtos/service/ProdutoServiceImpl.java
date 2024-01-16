package com.github.produtos.service;

import com.github.produtos.config.exception.ProductNotFoundException;
import com.github.produtos.config.exception.RequestNoContentException;
import com.github.produtos.domain.entity.Produto;
import com.github.produtos.domain.repository.ProdutoRepository;
import com.github.produtos.mapper.ConvertMapper;
import com.github.produtos.view.dto.ProdutoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository repository;

    @Override
    public void salvarProduto(ProdutoDTO produto) {
        Produto entity = ConvertMapper.produtoDTOToProduto(produto);
        repository.save(entity);
    }

    @Override
    public List<ProdutoDTO> findAll() {
        List<ProdutoDTO> list = repository.findAll().stream().map(this::convertModelToDto).toList();
        if (list.isEmpty()) throw new RequestNoContentException();
        else return list;
    }
//    @Override
//    public Page<Produto> getProdutosAtivos(Pageable pageable) {
//        Page<Produto> produtoAtivo = repository.getProdutoAtivo();
//        if (produtoAtivo.getSize() <= 0) throw new ProductNotFoundException();
//        return produtoAtivo;
//    }

    @Override
    public Produto getProdutoId(UUID uuid) {
        return repository.findById(uuid).orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public void removerProduto(UUID uuid) {
        if (!repository.existsById(uuid)) throw new ProductNotFoundException();
        repository.deleteById(uuid);
    }

    private ProdutoDTO convertModelToDto(Produto entity) {
        return ProdutoDTO
                .builder()
                .name(entity.getName())
                .description(entity.getDescription())
                .price(entity.getPrice())
                .tamanho(entity.getTamanho())
                .genero(entity.getGenero())
                .status(entity.getStatus())
                .build();
    }
}

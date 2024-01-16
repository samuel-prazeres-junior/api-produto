package com.github.produtos.service;

import com.github.produtos.config.exception.RequestNoContentException;
import com.github.produtos.controller.enums.StatusProduto;
import com.github.produtos.domain.entity.Produto;
import com.github.produtos.domain.repository.ProdutoRepository;
import com.github.produtos.view.dto.ProdutoDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


class ProdutoServiceImplTest {

    @Mock
    private ProdutoRepository repository;

    private ProdutoServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new ProdutoServiceImpl(repository);
    }

    @Test
    void salvarProduto() {
        when(repository.save(any())).thenReturn(mockProduto());
        service.salvarProduto(mockProdutoDTO());
        verify(repository, times(1)).save(any());
    }

    @Test
    void findAll() {
        when(repository.findAll()).thenReturn(massaDadosFindAllEntity());
        List<ProdutoDTO> dto = service.findAll();
        verify(repository, times(1)).findAll();
        assertEquals(massaDadosFindAllDTO().get(0).getName(), dto.get(0).getName());
        assertEquals(massaDadosFindAllDTO().get(0).getDescription(), dto.get(0).getDescription());
        assertEquals(massaDadosFindAllDTO().get(0).getPrice(), dto.get(0).getPrice());
        assertEquals(massaDadosFindAllDTO().get(0).getTamanho(), dto.get(0).getTamanho());
        assertEquals(massaDadosFindAllDTO().get(0).getGenero(), dto.get(0).getGenero());
        assertEquals(massaDadosFindAllDTO().get(0).getStatus(), dto.get(0).getStatus());
    }

    @Test
    void findAllEmpty() {
        when(repository.findAll()).thenReturn(new ArrayList<>());
        assertThrows(RequestNoContentException.class, () -> service.findAll());
        verify(repository, times(1)).findAll();
    }

    private ProdutoDTO mockProdutoDTO(){
        return ProdutoDTO.builder().name("Camisaseta Polo").description("Camiseta Polo com tecido de algodão").price(200.0).tamanho("GG").genero("Masculino").status(StatusProduto.ATIVO).build();
    }

    private Produto mockProduto(){
        Produto produto = new Produto();
        produto.setId(UUID.randomUUID());
        produto.setName("Camiseta Polo");
        produto.setDescription("Camiseta Polo com tecido de algodão");
        produto.setPrice(200.00);
        produto.setTamanho("GG");
        produto.setGenero("Masculino");
        produto.setStatus(StatusProduto.ATIVO);
        return produto;
    }

    public List<ProdutoDTO> massaDadosFindAllDTO(){
        List<ProdutoDTO> list = new ArrayList<>();
        list.add(ProdutoDTO.builder().name("Camisaseta Polo").description("Camiseta Polo com tecido de algodão").price(200.0).tamanho("GG").genero("Masculino").status(StatusProduto.ATIVO).build());
        list.add(ProdutoDTO.builder().name("Vestido Lacoste").description("Vestido Lacoste com tecido de algodão").price(100.0).tamanho("GG").genero("Feminino").status(StatusProduto.ATIVO).build());
        list.add(ProdutoDTO.builder().name("Top Nike").description("Top Nike com tecido de algodão").price(300.0).tamanho("GG").genero("Feminino").status(StatusProduto.ATIVO).build());
        return list;
    }

    public List<Produto> massaDadosFindAllEntity(){
        List<Produto> list = new ArrayList<>();
        list.add(Produto.builder().id(UUID.randomUUID()).name("Camisaseta Polo").description("Camiseta Polo com tecido de algodão").price(200.0).tamanho("GG").genero("Masculino").status(StatusProduto.ATIVO).build());
        list.add(Produto.builder().id(UUID.randomUUID()).name("Vestido Lacoste").description("Vestido Lacoste com tecido de algodão").price(100.0).tamanho("GG").genero("Feminino").status(StatusProduto.ATIVO).build());
        list.add(Produto.builder().id(UUID.randomUUID()).name("Top Nike").description("Top Nike com tecido de algodão").price(300.0).tamanho("GG").genero("Feminino").status(StatusProduto.ATIVO).build());
        return list;
    }
}
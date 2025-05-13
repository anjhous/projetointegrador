package com.example.AulaTeste.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AulaTeste.model.ProdutoModel;
import com.example.AulaTeste.repository.IProdutoRepository;

import jakarta.transaction.Transactional;
@Service
public class ProdutoService {
    @Autowired
    private IProdutoRepository produtoRepository;

    public ProdutoModel criarProduto(ProdutoModel ProdutoModel) {
       

        return produtoRepository.save(ProdutoModel);
    }

    public List<ProdutoModel> listarProdutos() {
        return produtoRepository.findAll();
    }

    public ProdutoModel buscarProduto(String email) {
        return produtoRepository.findByEmail(email);
    }

    @Transactional
    public void deletarProduto(String email) {
        produtoRepository.deleteByEmail(email);
    }
}
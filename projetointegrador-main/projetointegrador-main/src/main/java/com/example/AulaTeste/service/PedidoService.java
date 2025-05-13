package com.example.AulaTeste.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AulaTeste.model.PedidoModel;
import com.example.AulaTeste.repository.IPedidoRepository;

import jakarta.transaction.Transactional;
@Service
public class PedidoService {
    @Autowired
    private IPedidoRepository pedidoRepository;

    public PedidoModel criarPedido(PedidoModel PedidoModel) {
       

        return pedidoRepository.save(PedidoModel);
    }

    public List<PedidoModel> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public PedidoModel buscarPedido(String email) {
        return pedidoRepository.findByEmail(email);
    }

    @Transactional
    public void deletarPedido(String email) {
        pedidoRepository.deleteByEmail(email);
    }
}

package com.example.AulaTeste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.AulaTeste.errors.PedidoJaExiste;
import com.example.AulaTeste.model.PedidoModel;
import com.example.AulaTeste.service.PedidoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/criar")
    public ResponseEntity<?> criarPedido(@RequestBody PedidoModel PedidoModel) {
        try {
            var user = pedidoService.criarPedido(PedidoModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        } catch (PedidoJaExiste e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/todos")
    public ResponseEntity<List<PedidoModel>> getAllPedidos() {
        var users = pedidoService.listarPedidos();
        if (users.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(users);
    }

    @GetMapping("/buscar")
    public ResponseEntity<PedidoModel> getUser(@RequestParam String email) {
        var user = pedidoService.buscarPedido(email);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/deletar")
    public ResponseEntity<Void> deletUser(@RequestParam String email) {
        pedidoService.deletarPedido(email);
        return ResponseEntity.ok().build();
    }
}

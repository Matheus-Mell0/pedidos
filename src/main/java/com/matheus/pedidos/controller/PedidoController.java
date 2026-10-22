package com.matheus.pedidos.controller;

import com.matheus.pedidos.model.Pedido;
import com.matheus.pedidos.repository.PedidoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoRepository pedidoRepository;

    public PedidoController(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    // POST /pedidos - Criar pedido
    @PostMapping
    public ResponseEntity<Pedido> criar(
            @RequestBody Pedido pedido) {

        Pedido pedidoSalvo = pedidoRepository.save(pedido);

        return ResponseEntity.status(201).body(pedidoSalvo);
    }

    // GET /pedidos - Listar todos
    @GetMapping
    public ResponseEntity<List<Pedido>> listar() {
        return ResponseEntity.ok(pedidoRepository.findAll());
    }

    // GET /pedidos/{id} - Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPorId(
            @PathVariable Long id) {

        return pedidoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // PUT /pedidos/{id} - Atualizar pedido
    @PutMapping("/{id}")
    public ResponseEntity<Pedido> atualizar(
            @PathVariable Long id,
            @RequestBody Pedido dadosPedido) {

        return pedidoRepository.findById(id)
                .map(pedidoExistente -> {
                    pedidoExistente.setCliente(dadosPedido.getCliente());
                    pedidoExistente.setDescricao(dadosPedido.getDescricao());
                    pedidoExistente.setStatus(dadosPedido.getStatus());
                    pedidoExistente.setPrazoEntrega(dadosPedido.getPrazoEntrega());

                    Pedido atualizado = pedidoRepository.save(pedidoExistente);

                    return ResponseEntity.ok(atualizado);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // DELETE /pedidos/{id} - Excluir pedido
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {

        if (!pedidoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        pedidoRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
package com.example.demo.controller;

import com.example.demo.model.Produto;
import com.example.demo.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos") // Essa será a URL principal para produtos
@CrossOrigin(origins = "*") // Permite que o seu Frontend consiga acessar o Backend sem bloqueios
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    // GET: Retorna a lista de todos os produtos
    @GetMapping
    public List<Produto> listar() {
        return produtoService.listarTodos();
    }

    // GET: Retorna um único produto pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
        Optional<Produto> produto = produtoService.buscarPorId(id);
        return produto.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST: Adiciona um novo produto
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto adicionar(@RequestBody Produto produto) {
        return produtoService.salvar(produto);
    }

    // PUT: Atualiza as informações de um produto existente
    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {
        Optional<Produto> produtoExistente = produtoService.buscarPorId(id);

        if (produtoExistente.isPresent()) {
            produtoAtualizado.setId(id); // Garante que estamos atualizando o produto certo
            return ResponseEntity.ok(produtoService.salvar(produtoAtualizado));
        }

        return ResponseEntity.notFound().build();
    }

    // DELETE: Remove um produto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Optional<Produto> produtoExistente = produtoService.buscarPorId(id);

        if (produtoExistente.isPresent()) {
            produtoService.deletar(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
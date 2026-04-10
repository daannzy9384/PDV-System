package com.example.demo.service; // ATENÇÃO: Verifique se o nome do seu pacote é esse mesmo!

import com.example.demo.model.Produto; // Importa a sua entidade Produto
import com.example.demo.repository.ProdutoRepository; // Importa o seu repositório
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    // 1. Listar todos os produtos do estoque
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    // 2. Buscar um produto específico pelo ID
    public Optional<Produto> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }

    // 3. Cadastrar um novo produto ou atualizar um existente
    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    // 4. Excluir um produto do estoque
    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }
}
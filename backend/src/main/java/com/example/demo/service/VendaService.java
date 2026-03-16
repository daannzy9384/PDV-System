
package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.model.Venda;
import com.example.demo.dto.VendaDTO;
import com.example.demo.repository.VendaRepository;

@Service
public class VendaService {

    // Aqui nós chamamos o Repository para podermos usar o banco de dados
    @Autowired
    private VendaRepository vendaRepository;

    public Venda salvarVenda(VendaDTO dto) {
        
        // 1. Criamos uma nova venda vazia
        Venda novaVenda = new Venda();
        
        // 2. Preenchemos ela com os dados que vieram do DTO (do Front-end)
        novaVenda.setValorTotal(dto.getValorTotal());
        novaVenda.setFormaPagamento(dto.getFormaPagamento());
        
        // 3. Mandamos o Repository salvar no banco de dados!
        return vendaRepository.save(novaVenda);
    }
}
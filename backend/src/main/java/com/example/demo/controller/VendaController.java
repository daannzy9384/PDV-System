
package com.example.demo.controller;
import org.springframework.http.ResponseEntity;
import com.example.demo.dto.VendaDTO;
import com.example.demo.model.Venda;
import com.example.demo.service.VendaService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/api/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @PostMapping
    public ResponseEntity<Venda> realizarVenda(@RequestBody VendaDTO dto) {
        Venda novaVenda = vendaService.salvarVenda(dto);
        return ResponseEntity.ok(novaVenda);
    }
}
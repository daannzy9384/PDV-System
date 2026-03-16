
package com.example.demo.dto;

import java.math.BigDecimal;

public class VendaDTO {

    // O DTO não precisa de ID ou Data, pois quem gera isso é o próprio sistema.
    // O Front-end só precisa mandar o valor e como o cliente pagou.
    
    private BigDecimal valorTotal;
    private String formaPagamento;

    // Getters e Setters
    public BigDecimal getValorTotal() { return valorTotal; }
    public void setValorTotal(BigDecimal valorTotal) { this.valorTotal = valorTotal; }

    public String getFormaPagamento() { return formaPagamento; }
    public void setFormaPagamento(String formaPagamento) { this.formaPagamento = formaPagamento; }
}
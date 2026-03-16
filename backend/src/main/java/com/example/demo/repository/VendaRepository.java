package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Venda;

// O JpaRepository pede duas coisas: <A Classe do Modelo, O tipo do ID do Modelo>
public interface VendaRepository extends JpaRepository<Venda, Long> {
    
  
}

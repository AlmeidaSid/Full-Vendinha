package com.api_vendinha.api.domain.repository;

import com.api_vendinha.api.domain.entities.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Long> {
}

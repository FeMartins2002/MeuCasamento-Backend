package br.com.MeuCasamento.repositories;

import br.com.MeuCasamento.entities.Allocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllocationRepository extends JpaRepository<Allocation, Long> {

}

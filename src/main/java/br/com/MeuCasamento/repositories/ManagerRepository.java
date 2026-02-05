package br.com.MeuCasamento.repositories;

import br.com.MeuCasamento.entities.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {

}

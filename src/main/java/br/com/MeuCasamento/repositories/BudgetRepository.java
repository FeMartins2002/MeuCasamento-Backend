package br.com.MeuCasamento.repositories;

import br.com.MeuCasamento.entities.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetRepository extends JpaRepository<Budget, Long> {

}

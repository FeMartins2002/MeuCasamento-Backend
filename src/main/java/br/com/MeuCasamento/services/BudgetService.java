package br.com.MeuCasamento.services;

import br.com.MeuCasamento.entities.Budget;
import br.com.MeuCasamento.repositories.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BudgetService {
    @Autowired
    private BudgetRepository budgetRepository;

    public Budget save(Budget budget) {
        Budget existingBudget = budgetRepository.findByPartyId(budget.getParty().getId());

        if(existingBudget != null) {
            throw new RuntimeException("Festa já possui um orçamento");
        }
        return budgetRepository.save(budget);
    }
}

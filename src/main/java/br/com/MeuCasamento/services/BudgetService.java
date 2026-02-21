package br.com.MeuCasamento.services;

import br.com.MeuCasamento.dtos.request.budget.CreateBudgetDTO;
import br.com.MeuCasamento.dtos.response.budget.BudgetResponseDTO;
import br.com.MeuCasamento.entities.Budget;
import br.com.MeuCasamento.entities.Party;
import br.com.MeuCasamento.exceptions.PartyNotFoundException;
import br.com.MeuCasamento.mappers.BudgetMapper;
import br.com.MeuCasamento.repositories.BudgetRepository;
import br.com.MeuCasamento.repositories.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BudgetService {
    @Autowired
    private BudgetRepository budgetRepository;

    @Autowired
    private PartyRepository partyRepository;

    @Autowired
    private BudgetMapper budgetMapper;

    public BudgetResponseDTO save(CreateBudgetDTO newBudget) {
        Party party = partyRepository.findByExternalId(newBudget.getExternalPartyId())
                .orElseThrow(() -> new PartyNotFoundException("Festa não encontrada para o id: " + newBudget.getExternalPartyId()));

        Budget existingBudget = budgetRepository.findByPartyId(party.getId());

        if(existingBudget != null) {
            throw new RuntimeException("Festa já possui um orçamento");
        }

        LocalDate now = LocalDate.now();

        Budget budget = new Budget(now, newBudget.getTotalValue(), party, null);
        party.setBudget(budget);

        return budgetMapper.toResponse(budgetRepository.save(budget));
    }
}

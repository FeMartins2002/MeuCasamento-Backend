package br.com.MeuCasamento.dtos.response.budget;

import br.com.MeuCasamento.entities.Party;

import java.time.LocalDate;

public class BudgetResponseDTO {
    private Long id;
    private LocalDate generationDate;
    private double totalValue;
    private Party party;

    public BudgetResponseDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getGenerationDate() {
        return generationDate;
    }

    public void setGenerationDate(LocalDate generationDate) {
        this.generationDate = generationDate;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }
}

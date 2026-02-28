package br.com.MeuCasamento.dtos.request.budget;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class CreateBudgetDTO {
    @NotBlank
    private double totalValue;

    @NotBlank
    private UUID externalPartyId;

    public CreateBudgetDTO() {

    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public UUID getExternalPartyId() {
        return externalPartyId;
    }

    public void setExternalPartyId(UUID externalPartyId) {
        this.externalPartyId = externalPartyId;
    }
}

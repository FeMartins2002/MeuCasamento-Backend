package br.com.MeuCasamento.dtos.request.party;

import jakarta.validation.constraints.Future;

import java.time.LocalDate;

public class CreatePartyDTO {

    @Future
    private LocalDate partyDate;

    public CreatePartyDTO() {

    }

    public LocalDate getPartyDate() {
        return partyDate;
    }

    public void setPartyDate(LocalDate partyDate) {
        this.partyDate = partyDate;
    }
}

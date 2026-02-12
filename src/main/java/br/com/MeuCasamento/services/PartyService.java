package br.com.MeuCasamento.services;

import br.com.MeuCasamento.entities.Party;
import br.com.MeuCasamento.repositories.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartyService {
    @Autowired
    private PartyRepository partyRepository;

    public Party save(Party newParty) {
        if (newParty.getManager() == null) {
            throw new RuntimeException("Gerente é obrigatório");
        }

        newParty.getManager().getParties().add(newParty);

        return partyRepository.save(newParty);
    }
}

package br.com.MeuCasamento.services;

import br.com.MeuCasamento.entities.PartyHall;
import br.com.MeuCasamento.enums.Availability;
import br.com.MeuCasamento.repositories.PartyHallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartyHallService {
    @Autowired
    private PartyHallRepository partyHallRepository;

    public PartyHall save(PartyHall newPartyHall) {
        if(newPartyHall.getManager() == null) {
            throw new RuntimeException("Gerente do salão não pode ser nulo");
        }

        partyHallRepository
                .findByNameAndAddress(newPartyHall.getName(), newPartyHall.getAddress())
                .ifPresent(existing -> {
                    throw new RuntimeException("Já existe um salão com esse nome e endereço");
                });

        newPartyHall.getManager().getPartyHalls().add(newPartyHall);

        return partyHallRepository.save(newPartyHall);
    }

    public PartyHall updateAvailability(Long id, Availability availability) {
        PartyHall partyHall = partyHallRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Salão não encontrado"));

        partyHall.setAvailability(availability);

        return partyHallRepository.save(partyHall);
    }
}

package br.com.MeuCasamento.services;

import br.com.MeuCasamento.dtos.request.partyhall.CreatePartyHallDTO;
import br.com.MeuCasamento.dtos.response.partyhall.PartyHallResponseDTO;
import br.com.MeuCasamento.entities.Manager;
import br.com.MeuCasamento.entities.PartyHall;
import br.com.MeuCasamento.mappers.PartyHallMapper;
import br.com.MeuCasamento.repositories.ManagerRepository;
import br.com.MeuCasamento.repositories.PartyHallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartyHallService {
    @Autowired
    private PartyHallRepository partyHallRepository;

    @Autowired
    private PartyHallMapper partyHallMapper;

    @Autowired
    private ManagerRepository managerRepository;

    public PartyHallResponseDTO save(CreatePartyHallDTO newPartyHall) {
        // Id do Manager logado - futura implementação...
        long id = 1;

        if(findManager(id) == null) {
            throw new RuntimeException("Gerente não encontrado");
        }
        Manager manager = findManager(id);

        validatePartyHall(newPartyHall);
        PartyHall partyhall = partyHallMapper.toEntity(newPartyHall, manager);

        manager.getPartyHalls().add(partyhall);

        return partyHallMapper.toResponse(partyHallRepository.save(partyhall));
    }

    private void validatePartyHall(CreatePartyHallDTO partyHall) {
        partyHallRepository
                .findByNameAndAddress(partyHall.getName(), partyHall.getAddress())
                .ifPresent(existing -> {
                    throw new RuntimeException("Salão já cadastrado");
                });
    }

    private Manager findManager(Long id) {
        return managerRepository.findById(id).orElse(null);
    }
}

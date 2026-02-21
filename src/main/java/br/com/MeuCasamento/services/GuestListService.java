package br.com.MeuCasamento.services;

import br.com.MeuCasamento.dtos.request.guest.CreateGuestDTO;
import br.com.MeuCasamento.entities.Guest;
import br.com.MeuCasamento.entities.GuestList;
import br.com.MeuCasamento.entities.Party;
import br.com.MeuCasamento.exceptions.PartyNotFoundException;
import br.com.MeuCasamento.repositories.GuestListRepository;
import br.com.MeuCasamento.repositories.GuestRepository;
import br.com.MeuCasamento.repositories.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GuestListService {
    @Autowired
    private GuestListRepository guestListRepository;

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private PartyRepository partyRepository;

    public void save(UUID externalPartyId) {
        Party party = findParty(externalPartyId);
        GuestList guestList = findGuestList(party.getId());

        if (guestList != null) {
            throw new RuntimeException("Festa já possui uma lista de convidados");
        }

        GuestList newGuestList = new GuestList(party);
        party.setGuestList(newGuestList);

        guestListRepository.save(newGuestList);
    }

    public Guest addGuest(CreateGuestDTO newGuest) {
        Party party = findParty(newGuest.getExternalPartyId());
        GuestList guestList = findGuestList(party.getId());

        if(guestList == null) {
            throw new RuntimeException("Festa não possui uma lista de convidados");
        }

        if (validateGuest(newGuest, guestList.getId())) {
            throw new RuntimeException("Convidado já está na lista");
        }

        Guest guest = new Guest(newGuest.getName(), newGuest.getPhone(), newGuest.getEmail(), newGuest.getAddress(), guestList);
        guestList.addGuest(guest);

        return guestRepository.save(guest);
    }

    public void deleteGuest(Long guestId, Long guestListId) {
        Guest  guest = findGuest(guestId);
        GuestList guestList = findGuestList(guestListId);

        if (guestList == null) {
            throw new RuntimeException("Lista de convidados não encontrada");
        }

        if (!guest.getGuestList().getId().equals(guestList.getId())) {
            throw new RuntimeException("Convidado não pertence a esta lista");
        }

        guestList.removeGuest(guest);
        guestRepository.delete(guest);
    }

    private boolean validateGuest(CreateGuestDTO guest, Long guestListId) {
        return guestRepository.existsGuest(guest.getName(), guest.getPhone(), guest.getEmail(), guest.getAddress(), guestListId);
    }

    private Party findParty(UUID externalPartyId) {
        return partyRepository.findByExternalId(externalPartyId)
                .orElseThrow(() -> new PartyNotFoundException("Festa não encontrada para o id: " + externalPartyId));
    }

    private Guest findGuest(Long Id) {
        return guestRepository.findById(Id)
                .orElseThrow(() -> new RuntimeException("Convidado não encontrado"));
    }

    private GuestList findGuestList(Long partyId) {
        return guestListRepository.findByPartyId(partyId)
                .orElseThrow(() -> new RuntimeException("Festa ainda não possui uma lista de convidados"));
    }
}

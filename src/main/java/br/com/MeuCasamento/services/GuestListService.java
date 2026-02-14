package br.com.MeuCasamento.services;

import br.com.MeuCasamento.entities.Guest;
import br.com.MeuCasamento.entities.GuestList;
import br.com.MeuCasamento.repositories.GuestListRepository;
import br.com.MeuCasamento.repositories.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestListService {
    @Autowired
    private GuestListRepository guestListRepository;

    @Autowired
    private GuestRepository guestRepository;

    public GuestList save(GuestList newGuestList) {

        GuestList existingGuestList =
                guestListRepository.findByPartyId(newGuestList.getParty().getId());

        if (existingGuestList != null) {
            throw new IllegalStateException("Festa já possui uma lista de convidados");
        }

        return guestListRepository.save(newGuestList);
    }

    public Guest addGuest(Guest newGuest, GuestList guestList) {

        boolean exists = guestRepository.existsGuest(
                newGuest.getName(),
                newGuest.getPhone(),
                newGuest.getEmail(),
                newGuest.getAddress(),
                guestList.getId()
        );

        if (exists) {
            throw new IllegalStateException("Convidado já está na lista");
        }

        newGuest.setGuestList(guestList);
        return guestRepository.save(newGuest);
    }

    public void deleteGuest(Long guestId, Long guestListId) {
        Guest guest = guestRepository.findById(guestId)
                .orElseThrow(() -> new RuntimeException("Convidado não encontrado"));

        if (!guest.getGuestList().getId().equals(guestListId)) {
            throw new IllegalStateException("Convidado não pertence a esta lista");
        }

        guestRepository.delete(guest);
    }
}

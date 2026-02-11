package br.com.MeuCasamento.services;

import br.com.MeuCasamento.entities.Guest;
import br.com.MeuCasamento.repositories.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {
    @Autowired
    private GuestRepository guestRepository;

    public List<Guest> findAll() {
        return guestRepository.findAll();
    }

    public Guest save(Guest newGuest) {
        Guest existingGuest = guestRepository.findByEmail(newGuest.getEmail());

        if (existingGuest != null) {
            throw new IllegalArgumentException("Convidado está na lista");
        }
        return guestRepository.save(newGuest);
    }

    public void remove(Long guestId) {
        Guest guest = guestRepository.findById(guestId)
                .orElseThrow(() -> new IllegalArgumentException("Convidado não encontrado"));
        guestRepository.delete(guest);
    }
}

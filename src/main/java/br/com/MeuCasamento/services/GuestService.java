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
}

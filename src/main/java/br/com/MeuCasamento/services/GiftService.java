package br.com.MeuCasamento.services;

import br.com.MeuCasamento.entities.Gift;
import br.com.MeuCasamento.repositories.GiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiftService {
    @Autowired
    private GiftRepository giftRepository;

    public List<Gift> findAll() {
        return giftRepository.findAll();
    }
}

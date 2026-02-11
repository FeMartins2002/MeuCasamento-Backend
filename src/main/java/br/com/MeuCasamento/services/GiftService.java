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

    public Gift save(Gift newGift) {
        Gift existingGift = giftRepository.findByName(newGift.getName());

        if (existingGift != null) {
            throw new IllegalArgumentException("Já existe um presente com este nome");
        }
        return giftRepository.save(newGift);
    }

    public void remove(Long giftId) {
        Gift gift = giftRepository.findById(giftId)
                .orElseThrow(() -> new IllegalArgumentException("Presente não encontrado"));
        giftRepository.delete(gift);
    }
}

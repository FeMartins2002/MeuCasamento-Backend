package br.com.MeuCasamento.services;

import br.com.MeuCasamento.entities.Gift;
import br.com.MeuCasamento.entities.GiftList;
import br.com.MeuCasamento.repositories.GiftListRepository;
import br.com.MeuCasamento.repositories.GiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GiftListService {
    @Autowired
    private GiftListRepository giftListRepository;

    @Autowired
    GiftRepository giftRepository;

    public GiftList save(GiftList newGiftList) {
        GiftList existingGiftList = giftListRepository.findByPartyId(newGiftList.getParty().getId());

        if(existingGiftList != null) {
            throw new RuntimeException("Festa já possui uma lista de presentes");
        }

        return giftListRepository.save(newGiftList);
    }

    public Gift addGift(Gift newGift, GiftList giftList) {
        boolean existingGift = giftRepository.existsGift(
                newGift.getName(),
                newGift.getPrice(),
                newGift.getStore(),
                giftList.getId()
        );

        if (existingGift) {
            throw new RuntimeException("Presente já está na lista");
        }

        newGift.setGiftList(giftList);
        return giftRepository.save(newGift);
    }

    public void deleteGift(Long giftId, Long giftListId) {

        Gift gift = giftRepository.findById(giftId)
                .orElseThrow(() -> new RuntimeException("Presente não encontrado"));

        if (!gift.getGiftList().getId().equals(giftListId)) {
            throw new IllegalStateException("Presente não pertence a esta lista");
        }

        giftRepository.delete(gift);
    }
}

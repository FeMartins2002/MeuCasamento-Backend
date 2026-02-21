package br.com.MeuCasamento.services;

import br.com.MeuCasamento.dtos.request.gift.CreateGiftDTO;
import br.com.MeuCasamento.entities.Gift;
import br.com.MeuCasamento.entities.GiftList;
import br.com.MeuCasamento.entities.Party;
import br.com.MeuCasamento.exceptions.PartyNotFoundException;
import br.com.MeuCasamento.repositories.GiftListRepository;
import br.com.MeuCasamento.repositories.GiftRepository;
import br.com.MeuCasamento.repositories.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GiftListService {
    @Autowired
    private GiftListRepository giftListRepository;

    @Autowired
    GiftRepository giftRepository;

    @Autowired
    private PartyRepository partyRepository;

    public void save(UUID externalPartyId) {
        Party party = findParty(externalPartyId);
        GiftList existingGiftList = findGiftList(party.getId());

        if(existingGiftList != null) {
            throw new RuntimeException("Festa já possui uma lista de presentes");
        }

        GiftList newGiftList = new GiftList(party);
        party.setGiftList(newGiftList);

        giftListRepository.save(newGiftList);
    }

    public Gift addGift(CreateGiftDTO newGift) {
        Party party = findParty(newGift.getExternalPartyId());
        GiftList giftList = findGiftList(party.getId());

        if(giftList == null) {
            throw new RuntimeException("Festa não possui uma lista de presentes");
        }

        if (validateGift(newGift, giftList.getId())) {
            throw new RuntimeException("Presente já está na lista");
        }

        Gift gift = new Gift(newGift.getName(), newGift.getStore(), newGift.getPrice(), giftList);
        giftList.addGift(gift);

        return giftRepository.save(gift);
    }

    public void deleteGift(Long giftId, Long giftListId) {
        Gift gift = findGift(giftId);
        GiftList giftList = giftListRepository.findById(giftListId).orElse(null);

        if(giftList == null) {
            throw new RuntimeException("Lista de presentes não encontrada");
        }

        if (!gift.getGiftList().getId().equals(giftList.getId())) {
            throw new RuntimeException("Presente não pertence a esta lista");
        }

        giftList.removeGift(gift);
        giftRepository.delete(gift);
    }

    private boolean validateGift(CreateGiftDTO gift, Long giftListId) {
        return giftRepository.existsGift(gift.getName(), gift.getPrice(), gift.getStore(), giftListId);
    }

    private Party findParty(UUID externalPartyId) {
        return partyRepository.findByExternalId(externalPartyId)
                .orElseThrow(() -> new PartyNotFoundException("Festa não encontrada para o id: " + externalPartyId));
    }

    private Gift findGift(Long Id) {
        return giftRepository.findById(Id)
                .orElseThrow(() -> new RuntimeException("Presente não encontrado"));
    }

    private GiftList findGiftList(Long partyId) {
        return giftListRepository.findByPartyId(partyId)
                .orElseThrow(() -> new RuntimeException("Festa ainda não possui uma lista de presentes"));
    }
}

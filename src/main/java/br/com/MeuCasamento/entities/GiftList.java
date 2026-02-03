package br.com.MeuCasamento.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class GiftList implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "Party_Id", nullable = false, unique = true)
    private Party party;

    @OneToMany(mappedBy = "giftList")
    private List<Gift> gifts = new ArrayList<>();

    public GiftList() {

    }

    public GiftList(Party party) {
        this.party = party;
    }

    public void addGift(Gift gift) {
        gifts.add(gift);
        gift.setGiftList(this);
    }

    public void removeGift(Gift gift) {
        gifts.remove(gift);
        gift.setGiftList(null);
    }
}

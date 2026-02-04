package br.com.MeuCasamento.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class GiftList implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
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

    public List<Gift> getGifts() {
        return gifts;
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

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
public class GuestList implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "Party_ID", nullable = false, unique = true)
    private Party party;

    @OneToMany(mappedBy = "guestList")
    private List<Guest> guests = new ArrayList<>();

    public GuestList() {

    }

    public GuestList(Party party) {
        this.party = party;
    }

    public Long getId() {
        return id;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void addGuest(Guest guest) {
        guests.add(guest);
        guest.setGuestList(this);
    }

    public void removeGuest(Guest guest) {
        guests.remove(guest);
        guest.setGuestList(null);
    }
}

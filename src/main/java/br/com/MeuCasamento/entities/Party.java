package br.com.MeuCasamento.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Party implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "external_id", nullable = false, unique = true, updatable = false)
    private UUID externalId;

    @OneToMany(mappedBy = "party")
    private List<Spouse> spouses = new ArrayList<>();

    @OneToOne(mappedBy = "party")
    private GiftList giftList;

    @OneToOne(mappedBy = "party")
    private GuestList guestList;

    @ManyToOne(optional = false)
    @JoinColumn(name = "manager_id", nullable = false)
    private Manager manager;

    @OneToOne(mappedBy = "party")
    private Budget budget;

    public Party() {

    }

    public Party(LocalDate date, Manager manager) {
        this.date = date;
        this.manager = manager;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public UUID getExternalId() {
        return externalId;
    }

    public List<Spouse> getSpouses() {
        return spouses;
    }

    public void setSpouses(List<Spouse> spouses) {
        this.spouses = spouses;
    }

    public GiftList getGiftList() {
        return giftList;
    }

    public void setGiftList(GiftList giftList) {
        this.giftList = giftList;
    }

    public GuestList getGuestList() {
        return guestList;
    }

    public void setGuestList(GuestList guestList) {
        this.guestList = guestList;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    @PrePersist
    private void generateCode() {
        this.externalId = UUID.randomUUID();
    }

    public void addSpouse(Spouse spouse) {
        if (spouses.size() >= 2) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A festa ja possui dois cônjuges."
            );
        }
        else {
            spouses.add(spouse);
            spouse.setParty(this);
        }
    }

    public void createGiftList() {
        if (this.giftList != null) {
            throw new IllegalStateException("A festa já possui uma lista de presentes.");
        }
        this.giftList = new GiftList(this);
    }

    public void createGuestList() {
        if (this.guestList != null) {
            throw new IllegalStateException("A festa já possui lista de convidados.");
        }
        this.guestList = new GuestList(this);
    }
}

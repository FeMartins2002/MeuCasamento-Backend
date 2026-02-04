package br.com.MeuCasamento.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PartyHall implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Address")
    private String address;

    @Column(name = "Available")
    private String available;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Manager_ID", nullable = false)
    private Manager manager;

    @OneToMany(mappedBy = "partyHall")
    private List<PartyConfig> partyConfig = new ArrayList<>();

    public PartyHall() {

    }

    public PartyHall(String name, String address, String available, Manager manager) {
        this.name = name;
        this.address = address;
        this.available = available;
        this.manager = manager;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public Manager getManager() {
        return manager;
    }

    public List<PartyConfig> getPartyConfig() {
        return partyConfig;
    }
}

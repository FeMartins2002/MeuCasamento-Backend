package br.com.MeuCasamento.entities;

import jakarta.persistence.Column;
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
public class PartyConfig implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "status", nullable = false)
    private String status;

    @OneToOne(optional = false)
    @JoinColumn(name = "party_id", nullable = false, unique = true)
    private Party party;

    @OneToOne(optional = true)
    @JoinColumn(name = "party_hall_id")
    private PartyHall partyHall;

    @OneToMany(mappedBy = "partyConfig")
    private List<ServiceConfig> serviceConfig = new ArrayList<>();

    @OneToMany(mappedBy = "partyConfig")
    private List<Allocation> allocations = new ArrayList<>();

    public PartyConfig() {

    }

    public PartyConfig(String status, Party party) {
        this.status = status;
        this.party = party;
    }

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public PartyHall getPartyHall() {
        return partyHall;
    }

    public void setPartyHall(PartyHall partyHall) {
        this.partyHall = partyHall;
    }

    public List<ServiceConfig> getServiceConfig() {
        return serviceConfig;
    }

    public List<Allocation> getAllocations() {
        return allocations;
    }

    public void addService(ServiceConfig serviceConfig) {
        this.serviceConfig.add(serviceConfig);
        serviceConfig.setPartyConfig(this);
    }

    public void removeService(ServiceConfig serviceConfig) {
        this.serviceConfig.remove(serviceConfig);
        serviceConfig.setPartyConfig(null);
    }
}

package br.com.MeuCasamento.entities;

import br.com.MeuCasamento.enums.Availability;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PartyHall implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(name = "availability")
    private Availability availability;

    @ManyToOne(optional = false)
    @JoinColumn(name = "manager_id", nullable = false)
    private Manager manager;

    @OneToMany(mappedBy = "partyHall")
    private List<PartyConfig> partyConfig = new ArrayList<>();

    public PartyHall() {

    }

    public PartyHall(String name, String address, Availability availability, Manager manager) {
        this.name = name;
        this.address = address;
        this.availability = availability;
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

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public List<PartyConfig> getPartyConfig() {
        return partyConfig;
    }
}

package br.com.MeuCasamento.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Entity
public class ServiceConfig implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "agreed_value")
    private double agreedValue;

    @Column(name = "notes")
    private String notes;

    @ManyToOne(optional = false)
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;

    @ManyToOne(optional = false)
    @JoinColumn(name = "configuration_party_id", nullable = false)
    private PartyConfig partyConfig;

    protected ServiceConfig() {

    }

    public ServiceConfig(int quantity, double agreedValue, String notes, Service service, PartyConfig partyConfig) {
        this.quantity = quantity;
        this.agreedValue = agreedValue;
        this.notes = notes;
        this.service = service;
        this.partyConfig = partyConfig;
    }

    public Long getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAgreedValue() {
        return agreedValue;
    }

    public void setAgreedValue(double agreedValue) {
        this.agreedValue = agreedValue;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public PartyConfig getPartyConfig() {
        return partyConfig;
    }

    public void setPartyConfig(PartyConfig partyConfig) {
        this.partyConfig = partyConfig;
    }
}

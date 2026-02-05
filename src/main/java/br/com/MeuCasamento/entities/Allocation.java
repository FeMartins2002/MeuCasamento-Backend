package br.com.MeuCasamento.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Allocation implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "allocation_date")
    private LocalDate date;

    @Column(name = "allocation_time")
    private LocalDateTime time;

    @Column(name = "allocation_value")
    private double allocationValue;

    @ManyToOne(optional = false)
    @JoinColumn(name = "party_config_id", nullable = false)
    private PartyConfig partyConfig;

    @ManyToOne(optional = false)
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;

    @ManyToOne(optional = false)
    @JoinColumn(name = "professional_id", nullable = false)
    private Professional professional;

    public Allocation() {

    }

    public Allocation(LocalDate date, LocalDateTime time, double allocationValue, PartyConfig partyConfig, Service service, Professional professional) {
        this.date = date;
        this.time = time;
        this.allocationValue = allocationValue;
        this.partyConfig = partyConfig;
        this.service = service;
        this.professional = professional;
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

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public double getAllocationValue() {
        return allocationValue;
    }

    public void setAllocationValue(double allocationValue) {
        this.allocationValue = allocationValue;
    }

    public PartyConfig getPartyConfig() {
        return partyConfig;
    }

    public void setPartyConfig(PartyConfig partyConfig) {
        this.partyConfig = partyConfig;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }
}

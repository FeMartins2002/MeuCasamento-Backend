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
public class Professional implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Speciality")
    private String speciality;

    @Column(name = "Availability")
    private String availability;

    @Column(name = "Hourly_Rate")
    private double hourlyRate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Manager_ID", nullable = false)
    private Manager manager;

    @OneToMany(mappedBy = "professional")
    private List<Allocation> allocations = new ArrayList<>();

    public Professional() {

    }

    public Professional(String name, String phone, String speciality, String availability, double hourlyRate, Manager manager) {
        this.name = name;
        this.phone = phone;
        this.speciality = speciality;
        this.availability = availability;
        this.hourlyRate = hourlyRate;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public Manager getManager() {
        return manager;
    }

    public List<Allocation> getProfessionalAllocations() {
        return allocations;
    }
}

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
public class Service implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "service_type", nullable = false)
    private String type;

    @Column(name = "service_value", nullable = false)
    private double serviceValue;

    @ManyToOne(optional = false)
    @JoinColumn(name = "manager_id", nullable = false)
    private Manager manager;

    @OneToMany(mappedBy = "service")
    private List<Allocation> allocations = new ArrayList<>();

    @OneToMany(mappedBy = "service")
    private List<ServiceConfig> serviceConfig = new ArrayList<>();

    public Service() {

    }

    public Service(String name, String type, double serviceValue, Manager manager) {
        this.name = name;
        this.type = type;
        this.serviceValue = serviceValue;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getServiceValue() {
        return serviceValue;
    }

    public void setServiceValue(double serviceValue) {
        this.serviceValue = serviceValue;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public List<Allocation> getAllocations() {
        return allocations;
    }

    public void setAllocations(List<Allocation> allocations) {
        this.allocations = allocations;
    }

    public List<ServiceConfig> getServiceConfig() {
        return serviceConfig;
    }

    public void setServiceConfig(List<ServiceConfig> serviceConfig) {
        this.serviceConfig = serviceConfig;
    }
}

package br.com.MeuCasamento.entities;

import br.com.MeuCasamento.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Managers")
public class Manager implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phone", nullable = false, unique = true)
    private String phone;

    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "role", nullable = false)
    private Role role;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "manager")
    private List<Party> parties = new ArrayList<>();

    @OneToMany(mappedBy = "manager")
    private List<Professional> professionals = new ArrayList<>();

    @OneToMany(mappedBy = "manager")
    private List<Service> services = new ArrayList<>();

    @OneToMany(mappedBy = "manager")
    private List<PartyHall> partyHalls = new ArrayList<>();

    public Manager() {

    }

    public Manager(String name, String email, String phone, String cpf, String address, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.cpf = cpf;
        this.address = address;
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Role getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Party> getParties() {
        return parties;
    }

    public List<Professional> getProfessionals() {
        return professionals;
    }

    public List<Service> getServices() {
        return services;
    }

    public List<PartyHall> getPartyHalls() {
        return partyHalls;
    }
}

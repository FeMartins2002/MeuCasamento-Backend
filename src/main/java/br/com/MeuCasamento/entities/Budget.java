package br.com.MeuCasamento.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.io.Serializable;
import java.util.Date;

@Entity
public class Budget implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "generation_date", nullable = false)
    private Date generationDate;

    @Column(name = "total_value", nullable = false)
    private double totalValue;

    @OneToOne(optional = false)
    @JoinColumn(name = "party_id", nullable = false, unique = true)
    private Party party;

    @OneToOne(mappedBy = "budget")
    private Payment payment;

    public Budget() {

    }

    public Budget(Date generationDate, double totalValue, Party party, Payment payment) {
        this.generationDate = generationDate;
        this.totalValue = totalValue;
        this.party = party;
        this.payment = payment;
    }

    public Long getId() {
        return id;
    }

    public Date getGenerationDate() {
        return generationDate;
    }

    public void setGenerationDate(Date generationDate) {
        this.generationDate = generationDate;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}

package br.com.MeuCasamento.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Method")
    private String method;

    @Column(name = "Status")
    private String status;

    @Column(name = "Payment_Value")
    private double paymentValue;

    @OneToOne(optional = false)
    @JoinColumn(name = "Budget_ID", nullable = false, unique = true)
    private Budget budget;

    public Payment() {

    }

    public Payment(String method, String status, double paymentValue, Budget budget) {
        this.method = method;
        this.status = status;
        this.paymentValue = paymentValue;
        this.budget = budget;
    }

    public Long getId() {
        return id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getPaymentValue() {
        return paymentValue;
    }

    public void setPaymentValue(double paymentValue) {
        this.paymentValue = paymentValue;
    }

    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }
}

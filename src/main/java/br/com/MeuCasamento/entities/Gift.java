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
public class Gift implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "store", nullable = false)
    private String store;

    @Column(name = "price", nullable = false)
    private double price;

    @ManyToOne(optional = false)
    @JoinColumn(name = "gift_list_id", nullable = false)
    private GiftList giftList;

    public Gift() {

    }

    public Gift(String name, String store, double price, GiftList giftList) {
        this.name = name;
        this.store = store;
        this.price = price;
        this.giftList = giftList;
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

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public GiftList getGiftList() {
        return giftList;
    }

    public void setGiftList(GiftList giftList) {
        this.giftList = giftList;
    }
}

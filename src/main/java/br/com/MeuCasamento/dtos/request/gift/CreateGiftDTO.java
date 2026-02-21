package br.com.MeuCasamento.dtos.request.gift;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public class CreateGiftDTO {

    @NotBlank
    @Size(min = 5, max = 50)
    private String name;

    @NotBlank
    @Size(min = 3, max = 50)
    private String store;

    @PositiveOrZero
    private double price;

    @NotNull
    private UUID externalPartyId;

    public CreateGiftDTO() {

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

    public UUID getExternalPartyId() {
        return externalPartyId;
    }

    public void setExternalPartyId(UUID externalPartyId) {
        this.externalPartyId = externalPartyId;
    }
}

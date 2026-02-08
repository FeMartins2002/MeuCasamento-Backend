package br.com.MeuCasamento.dtos.request.partyhall;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreatePartyHallDTO {

    @NotBlank
    private String name;

    @NotBlank
    @Size(min = 10)
    private String address;

    @NotBlank
    private String available;

    public CreatePartyHallDTO() {

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

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }
}

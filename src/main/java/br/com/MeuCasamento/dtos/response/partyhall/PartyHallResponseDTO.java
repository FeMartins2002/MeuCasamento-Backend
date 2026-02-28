package br.com.MeuCasamento.dtos.response.partyhall;

import br.com.MeuCasamento.enums.Availability;

public class PartyHallResponseDTO {
    private String name;
    private String address;
    private Availability availability;

    public PartyHallResponseDTO() {

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

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }
}

package br.com.MeuCasamento.dtos.request.partyhall;

import br.com.MeuCasamento.enums.Availability;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreatePartyHallDTO {

    @NotBlank
    private String name;

    @NotBlank
    @Size(min = 10)
    private String address;

    @NotBlank
    private Availability availability;

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

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }
}

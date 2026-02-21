package br.com.MeuCasamento.dtos.request.guest;

import jakarta.validation.constraints.*;

import java.util.UUID;

public class CreateGuestDTO {

    @NotBlank
    @Size(min = 1, max = 50)
    private String name;

    @NotBlank
    @Pattern(regexp = "\\d{11}", message = "Telefone deve conter DDD + número")
    private String phone;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 10)
    private String address;

    @NotNull
    private UUID externalPartyId;

    public CreateGuestDTO() {

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UUID getExternalPartyId() {
        return externalPartyId;
    }

    public void setExternalPartyId(UUID externalPartyId) {
        this.externalPartyId = externalPartyId;
    }
}

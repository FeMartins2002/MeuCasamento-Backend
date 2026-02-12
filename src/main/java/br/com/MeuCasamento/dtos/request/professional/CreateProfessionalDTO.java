package br.com.MeuCasamento.dtos.request.professional;

import br.com.MeuCasamento.enums.Availability;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public class CreateProfessionalDTO {

    @NotBlank
    private String name;

    @NotBlank
    @Pattern(regexp = "\\d{11}", message = "CPF deve conter 11 digitos")
    private String cpf;

    @NotBlank
    @Pattern(regexp = "\\d{11}", message = "Telefone deve conter DDD + número")
    private String phone;

    @NotBlank
    private String speciality;

    @NotBlank
    private Availability availability;

    @Positive
    private double hourlyRate;

    public CreateProfessionalDTO() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}

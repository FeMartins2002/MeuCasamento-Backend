package br.com.MeuCasamento.dtos.request.professional;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public class CreateProfessionalDTO {

    @NotBlank
    private String name;

    @NotBlank
    @Pattern(regexp = "\\d{11}", message = "Telefone deve conter DDD + número")
    private String phone;

    @NotBlank
    private String speciality;

    @NotBlank
    private String availability;

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

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}

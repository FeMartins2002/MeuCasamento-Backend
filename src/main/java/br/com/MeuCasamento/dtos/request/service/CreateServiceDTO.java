package br.com.MeuCasamento.dtos.request.service;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class CreateServiceDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String type;

    @Positive
    private double serviceValue;

    public CreateServiceDTO() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getServiceValue() {
        return serviceValue;
    }

    public void setServiceValue(double serviceValue) {
        this.serviceValue = serviceValue;
    }
}

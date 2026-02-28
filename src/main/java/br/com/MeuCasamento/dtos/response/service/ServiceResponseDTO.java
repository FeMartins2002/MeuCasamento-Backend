package br.com.MeuCasamento.dtos.response.service;

public class ServiceResponseDTO {
    private String name;
    private String type;
    private double serviceValue;

    public ServiceResponseDTO() {

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

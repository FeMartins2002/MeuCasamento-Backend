package br.com.MeuCasamento.dtos.request.allocation;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public class CreateAllocationDTO {

    @Future
    private LocalDateTime allocationDateTime;

    @Positive
    private double allocationValue;

    @NotNull
    private Long serviceId;

    @NotNull
    private Long professionalId;

    public CreateAllocationDTO() {

    }

    public LocalDateTime getAllocationDateTime() {
        return allocationDateTime;
    }

    public void setAllocationDateTime(LocalDateTime allocationDateTime) {
        this.allocationDateTime = allocationDateTime;
    }

    public double getAllocationValue() {
        return allocationValue;
    }

    public void setAllocationValue(double allocationValue) {
        this.allocationValue = allocationValue;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Long getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(Long professionalId) {
        this.professionalId = professionalId;
    }
}

package br.com.MeuCasamento.dtos.response.allocation;

import java.time.LocalDateTime;

public class AllocationResponseDTO {
    private Long id;
    private LocalDateTime allocationDateTime;
    private double allocationValue;

    public AllocationResponseDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}

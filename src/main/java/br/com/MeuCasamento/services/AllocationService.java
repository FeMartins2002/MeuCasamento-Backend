package br.com.MeuCasamento.services;

import br.com.MeuCasamento.entities.Allocation;
import br.com.MeuCasamento.enums.Availability;
import br.com.MeuCasamento.repositories.AllocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AllocationService {
    @Autowired
    private AllocationRepository allocationRepository;

    public Allocation save(Allocation allocation) {

        boolean exists  = allocationRepository.existsAllocation(
                allocation.getAllocationDateTime(),
                allocation.getAllocationValue(),
                allocation.getPartyConfig(),
                allocation.getService(),
                allocation.getProfessional()
        );

        if (exists) {
            throw new RuntimeException("Já existe um registro igual no banco");
        }

        if (allocation.getProfessional().getAvailability() == Availability.INDISPONIVEL) {
            throw new RuntimeException("Profissional Indisponível para a alocação");
        }

        return allocationRepository.save(allocation);
    }
}

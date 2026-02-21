package br.com.MeuCasamento.services;

import br.com.MeuCasamento.dtos.request.allocation.CreateAllocationDTO;
import br.com.MeuCasamento.dtos.response.allocation.AllocationResponseDTO;
import br.com.MeuCasamento.repositories.AllocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AllocationService {
    @Autowired
    private AllocationRepository allocationRepository;

    public AllocationResponseDTO save(CreateAllocationDTO allocation) {

        return null;
    }
}

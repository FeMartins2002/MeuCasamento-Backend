package br.com.MeuCasamento.services;

import br.com.MeuCasamento.dtos.request.service.CreateServiceDTO;
import br.com.MeuCasamento.dtos.response.service.ServiceResponseDTO;
import br.com.MeuCasamento.entities.Manager;
import br.com.MeuCasamento.mappers.ServiceMapper;
import br.com.MeuCasamento.repositories.ManagerRepository;
import br.com.MeuCasamento.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeddingService {
    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private ServiceMapper serviceMapper;

    public ServiceResponseDTO save(CreateServiceDTO service) {
        // Id do Manager logado - futura implementação...
        long id = 1;

        if(findManager(id) == null) {
            throw new RuntimeException("Gerente não encontrado");
        }
        Manager manager = findManager(id);

        if(validateService(service)) {
            throw new RuntimeException("Service existente");
        }

        return serviceMapper.toResponseDTO(serviceRepository.save(serviceMapper.toEntity(service, manager)));
    }

    private boolean validateService(CreateServiceDTO service) {
        return serviceRepository.existsService(service.getName(), service.getType(), service.getServiceValue());
    }

    private Manager findManager(Long id) {
        return managerRepository.findById(id).orElse(null);
    }
 }

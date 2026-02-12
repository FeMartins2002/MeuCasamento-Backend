package br.com.MeuCasamento.services;

import br.com.MeuCasamento.entities.Manager;
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

    public br.com.MeuCasamento.entities.Service save(br.com.MeuCasamento.entities.Service service) {
        Manager manager = managerRepository.findById(service.getManager().getId()).orElse(null);

        if(manager == null) {
            throw new RuntimeException("Gerente do serviço não pode ser nulo");
        }

        return serviceRepository.save(service);
    }
 }

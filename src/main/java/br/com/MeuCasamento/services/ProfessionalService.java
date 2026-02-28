package br.com.MeuCasamento.services;

import br.com.MeuCasamento.dtos.request.professional.CreateProfessionalDTO;
import br.com.MeuCasamento.dtos.response.professional.ProfessionalResponseDTO;
import br.com.MeuCasamento.entities.Manager;
import br.com.MeuCasamento.exceptions.CpfAlreadyRegisteredException;
import br.com.MeuCasamento.mappers.ProfessionalMapper;
import br.com.MeuCasamento.repositories.ManagerRepository;
import br.com.MeuCasamento.repositories.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessionalService {
    @Autowired
    private ProfessionalRepository professionalRepository;

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private ProfessionalMapper professionalMapper;

    public ProfessionalResponseDTO save(CreateProfessionalDTO newProfessional) {
        // Id do Manager logado - futura implementação...
        long id = 1;

        if(findManager(id) == null) {
            throw new RuntimeException("Gerente não encontrado");
        }
        Manager manager = findManager(id);

        validateCpf(newProfessional.getCpf());
        validatePhone(newProfessional.getPhone());

        return professionalMapper.toResponse(professionalRepository.save(professionalMapper.toEntity(newProfessional, manager)));
    }

    private void validateCpf(String cpf) {
        if (professionalRepository.findByCpf(cpf) != null) {
            throw new CpfAlreadyRegisteredException(cpf);
        }
    }

    private void validatePhone(String phone) {
        if (professionalRepository.findByPhone(phone)) {
            throw new RuntimeException("Professional já cadastrado");
        }
    }

    private Manager findManager(Long id) {
        return managerRepository.findById(id).orElse(null);
    }
}

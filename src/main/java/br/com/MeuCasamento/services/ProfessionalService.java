package br.com.MeuCasamento.services;

import br.com.MeuCasamento.entities.Professional;
import br.com.MeuCasamento.enums.Availability;
import br.com.MeuCasamento.repositories.ProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessionalService {
    @Autowired
    ProfessionalRepository professionalRepository;

    public Professional save(Professional newProfessional, Availability availability) {
        Professional existingProfessional = professionalRepository.findByCpf(newProfessional.getCpf());

        if(existingProfessional != null) {
            throw new RuntimeException("Professional já cadastrado.");
        }

        if(newProfessional.getManager() == null) {
            throw new RuntimeException("Gerente não pode ser nulo");
        }

        newProfessional.setAvailability(availability);
        return professionalRepository.save(newProfessional);
    }

   public Professional updateAvailability(Long id, Availability availability) {
        Professional professional = professionalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profissional não encontrado"));

        professional.setAvailability(availability);

        return professionalRepository.save(professional);
    }
}

package br.com.MeuCasamento.services;

import br.com.MeuCasamento.dtos.request.manager.CreateManagerDTO;
import br.com.MeuCasamento.dtos.response.manager.ManagerResponseDTO;
import br.com.MeuCasamento.entities.Manager;
import br.com.MeuCasamento.enums.Role;
import br.com.MeuCasamento.mappers.ManagerMapper;
import br.com.MeuCasamento.repositories.ManagerRepository;
import br.com.MeuCasamento.services.utils.PasswordGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {
    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ManagerMapper managerMapper;

    public ManagerResponseDTO save(CreateManagerDTO newManager) {
        validateManager(newManager);
        Manager manager = createManager(newManager);
        manager.setRole(Role.ROLE_MANAGER);

        return managerMapper.toResponse(managerRepository.save(manager));
    }

    public Manager changePassword(Long managerId, String newPassword) {
        Manager manager = findById(managerId);

        if(!validateNewPassword(newPassword)) {
            throw new RuntimeException("Nova senha inválida");
        }

        manager.setPassword(passwordEncoder.encode(newPassword));

        return managerRepository.save(manager);
    }

    private void validateManager(CreateManagerDTO manager) {
        if (managerRepository.findByEmail(manager.getEmail()).isPresent()) {
            throw new RuntimeException("Email já cadastrado");
        }

        if (managerRepository.findByPhone(manager.getPhone()).isPresent()) {
            throw new RuntimeException("Telefone já cadastrado");
        }

        if (managerRepository.findByCpf(manager.getCpf()).isPresent()) {
            throw new RuntimeException("CPF já cadastrado");
        }
    }

    private boolean validateNewPassword(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }
        else {
            return true;
        }
    }

    private Manager findById(Long id) {
        return managerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gerente não encontrado"));
    }

    private boolean findEmail(String email) {
        return managerRepository.findByEmail(email).isPresent();
    }

    private boolean findPhone(String phone) {
        return managerRepository.findByPhone(phone).isPresent();
    }

    private boolean findCpf(String cpf) {
        return managerRepository.findByCpf(cpf).isPresent();
    }

    private Manager createManager(CreateManagerDTO newManager) {
        return managerMapper.toManager(
                newManager,
                passwordEncoder.encode(PasswordGenerator.generateDefaultPassword())
        );
    }
}

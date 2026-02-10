package br.com.MeuCasamento.services;

import br.com.MeuCasamento.entities.Manager;
import br.com.MeuCasamento.repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {
    @Autowired
    private ManagerRepository managerRepository;

    public Manager findById(Long id) {
        return managerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Manager não encontrado"));
    }

    public Manager save(Manager manager) {
        return managerRepository.save(manager);
    }

    // Por enquanto, sem criptografia

    public Manager login(String email, String password) {
        Manager manager = managerRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("E-mail ou senha inválidos"));

        if (!password.equals(manager.getPassword())) {
            throw new RuntimeException("E-mail ou senha inválidos");
        }
        return manager;
    }

    public Manager changePassword(Long managerId, String newPassword) {
        Manager manager = findById(managerId);
        manager.setPassword(newPassword);
        return managerRepository.save(manager);
    }
}

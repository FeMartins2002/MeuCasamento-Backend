package br.com.MeuCasamento.services;

import br.com.MeuCasamento.entities.Manager;
import br.com.MeuCasamento.repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {
    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Manager findById(Long id) {
        return managerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Manager não encontrado"));
    }

    public Manager save(Manager manager) {
        if (manager.getPassword() != null && !manager.getPassword().isEmpty()) {
            String encryptedPassword = passwordEncoder.encode(manager.getPassword());
            manager.setPassword(encryptedPassword);
        }
        return managerRepository.save(manager);
    }

    public Manager login(String email, String password) {
        Manager manager = managerRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("E-mail ou senha inválidos"));

        if (!passwordEncoder.matches(password, manager.getPassword())) {
            throw new RuntimeException("E-mail ou senha inválidos");
        }
        return manager;
    }

    public Manager changePassword(Long managerId, String newPassword) {
        Manager manager = findById(managerId);

        if (newPassword == null || newPassword.isEmpty()) {
            throw new RuntimeException("Nova senha inválida");
        }

        String encryptedPassword = passwordEncoder.encode(newPassword);
        manager.setPassword(encryptedPassword);

        return managerRepository.save(manager);
    }
}

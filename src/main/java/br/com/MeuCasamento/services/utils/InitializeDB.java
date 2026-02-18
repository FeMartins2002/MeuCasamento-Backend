package br.com.MeuCasamento.services.utils;

import br.com.MeuCasamento.entities.Manager;
import br.com.MeuCasamento.entities.Party;
import br.com.MeuCasamento.repositories.ManagerRepository;
import br.com.MeuCasamento.repositories.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class InitializeDB implements CommandLineRunner {
    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private PartyRepository partyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        Manager manager = new Manager(
                "Marcelo",
                "marcelo123@gmail.com",
                "11967762246",
                "80000000008",
                "Rua Diamante da Rocha, 123",
                passwordEncoder.encode("123")
        );

        managerRepository.save(manager);

        Party party1 = new Party(LocalDate.of(2026, 10, 16), manager);
        Party party2 = new Party(LocalDate.of(2026, 11, 27), manager);
        Party party3 = new Party(LocalDate.of(2026, 12, 14), manager);

        List<Party> parties = Arrays.asList(party1, party2, party3);
        partyRepository.saveAll(parties);
    }
}

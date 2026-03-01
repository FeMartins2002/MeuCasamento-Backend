package br.com.MeuCasamento.services.utils;

import br.com.MeuCasamento.entities.Manager;
import br.com.MeuCasamento.entities.Party;
import br.com.MeuCasamento.entities.Spouse;
import br.com.MeuCasamento.enums.Role;
import br.com.MeuCasamento.repositories.ManagerRepository;
import br.com.MeuCasamento.repositories.PartyRepository;
import br.com.MeuCasamento.repositories.SpouseRepository;
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
    private SpouseRepository spouseRepository;

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
        manager.setRole(Role.ROLE_MANAGER);
        managerRepository.save(manager);

        Party party1 = new Party(LocalDate.of(2026, 10, 16), manager);
        System.out.println("Party 1 External ID = " + party1.getExternalId());

        Party party2 = new Party(LocalDate.of(2026, 11, 27), manager);
        System.out.println("Party 2 External ID = " + party2.getExternalId());

        Party party3 = new Party(LocalDate.of(2026, 12, 14), manager);
        System.out.println("Party 3 External ID = " + party3.getExternalId());

        List<Party> parties = Arrays.asList(party1, party2, party3);
        partyRepository.saveAll(parties);

        Spouse spouse1 = new Spouse(
                "10000000001",
                "Maria",
                "maria123@gmail.com",
                "11999999991",
                "Rua Alves, 123",
                passwordEncoder.encode("12345"),
                party1
        );
        spouse1.setRole(Role.ROLE_SPOUSE);
        party1.addSpouse(spouse1);

        Spouse spouse2 = new Spouse(
                "20000000002",
                "Mario",
                "mario123@gmail.com",
                "11988888888",
                "Rua Menta, 123",
                passwordEncoder.encode("54321"),
                party1
        );
        spouse2.setRole(Role.ROLE_SPOUSE);
        party1.addSpouse(spouse2);

        List<Spouse> spouses = Arrays.asList(spouse1, spouse2);
        spouseRepository.saveAll(spouses);
        partyRepository.save(party1);
    }
}

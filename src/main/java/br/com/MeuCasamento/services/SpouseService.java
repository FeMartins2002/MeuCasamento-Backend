package br.com.MeuCasamento.services;

import br.com.MeuCasamento.entities.Party;
import br.com.MeuCasamento.entities.Spouse;
import br.com.MeuCasamento.repositories.PartyRepository;
import br.com.MeuCasamento.repositories.SpouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SpouseService {
    @Autowired
    private SpouseRepository spouseRepository;

    @Autowired
    private PartyRepository partyRepository;

    @Autowired
    private PasswordEncoder  passwordEncoder;

    public Spouse save(Spouse newSpouse, UUID externalPartyId) {
        if (externalPartyId == null) {
            throw new RuntimeException("Código inválido.");
        }

        Spouse existingSpouse = spouseRepository.findByCpf(newSpouse.getCpf());
        if (existingSpouse != null) {
            throw new RuntimeException("Cônjuge já cadastrado.");
        }

        Party party = partyRepository.findByExternalId(externalPartyId)
                .orElseThrow(() -> new RuntimeException("Festa não encontrada."));

        if (party.getSpouses().size() >= 2) {
            throw new RuntimeException("Festa já possui 2 cônjuges.");
        }

        if (newSpouse.getPassword() != null && !newSpouse.getPassword().isEmpty()) {
            String encryptedPassword = passwordEncoder.encode(newSpouse.getPassword());
            newSpouse.setPassword(encryptedPassword);
        }

        newSpouse.setParty(party);
        return spouseRepository.save(newSpouse);
    }

    public Spouse changePassword(Long spouseId, String newPassword) {
        Spouse spouse = spouseRepository.findById(spouseId)
                .orElseThrow(() -> new RuntimeException("Spouse não encontrado"));

        if (newPassword == null || newPassword.isEmpty()) {
            throw new RuntimeException("Nova senha inválida");
        }

        String encryptedPassword = passwordEncoder.encode(newPassword);
        spouse.setPassword(encryptedPassword);

        return spouseRepository.save(spouse);
    }
}

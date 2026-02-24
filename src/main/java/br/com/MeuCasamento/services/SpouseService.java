package br.com.MeuCasamento.services;

import br.com.MeuCasamento.dtos.request.spouse.CreateSpouseDTO;
import br.com.MeuCasamento.dtos.request.spouse.UpdatePasswordSpouseDTO;
import br.com.MeuCasamento.dtos.request.spouse.UpdateSpouseDTO;
import br.com.MeuCasamento.dtos.response.spouse.SpouseResponseDTO;
import br.com.MeuCasamento.entities.Party;
import br.com.MeuCasamento.entities.Spouse;
import br.com.MeuCasamento.exceptions.CpfAlreadyRegisteredException;
import br.com.MeuCasamento.exceptions.InvalidPasswordException;
import br.com.MeuCasamento.exceptions.PartyNotFoundException;
import br.com.MeuCasamento.exceptions.SpouseNotFoundException;
import br.com.MeuCasamento.mappers.SpouseMapper;
import br.com.MeuCasamento.repositories.PartyRepository;
import br.com.MeuCasamento.repositories.SpouseRepository;
import br.com.MeuCasamento.services.utils.PasswordGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class SpouseService {
    @Autowired
    private SpouseRepository spouseRepository;

    @Autowired
    private PartyRepository partyRepository;

    @Autowired
    private SpouseMapper spouseMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public SpouseResponseDTO save(CreateSpouseDTO dto) {
        Party party = findParty(dto.getExternalPartyId());
        validateCpf(dto.getCpf());

        Spouse spouse = createSpouse(dto, party);
        party.addSpouse(spouse);

        return spouseMapper.toResponse(spouseRepository.save(spouse));
    }

    public SpouseResponseDTO update(UpdateSpouseDTO dto) {
        // Id do Usuário logado - futura implementação...
        long id = 1;

        Spouse spouse = findSpouse(id);

        spouse.setEmail(dto.getEmail());
        spouse.setPhone(dto.getPhone());
        spouse.setAddress(dto.getAddress());

        return spouseMapper.toResponse(spouseRepository.save(spouse));
    }

    public void delete(Long spouseId) {
        Spouse spouse = findSpouse(spouseId);
        spouseRepository.delete(spouse);
    }

    public void changePassword(UpdatePasswordSpouseDTO dto) {
        // Id do Usuário logado - futura implementação...
        long id = 1;

        Spouse spouse = findSpouse(id);

        if (!passwordEncoder.matches(dto.getCurrentPassword(), spouse.getPassword())) {
            throw new InvalidPasswordException("Senha atual incorreta");
        }

        if (!dto.getNewPassword().equals(dto.getConfirmPassword())) {
            throw new InvalidPasswordException("Nova senha e confirmação não conferem");
        }

        spouse.setPassword(passwordEncoder.encode(dto.getNewPassword()));
        spouseRepository.save(spouse);
    }

    private void validateCpf(String cpf) {
        if (spouseRepository.findByCpf(cpf) != null) {
            throw new CpfAlreadyRegisteredException(cpf);
        }
    }

    private Spouse findSpouse(Long id) {
        return spouseRepository.findById(id)
                .orElseThrow(() -> new SpouseNotFoundException("Conjugue não encontrado para o id: " + id));
    }

    private Party findParty(UUID externalPartylId) {
        return partyRepository.findByExternalId(externalPartylId)
                .orElseThrow(() -> new PartyNotFoundException("Party not found for code: " + externalPartylId));
    }

    private Spouse createSpouse(CreateSpouseDTO dto, Party party) {
        return spouseMapper.toEntity(
                dto,
                party,
                passwordEncoder.encode(PasswordGenerator.generateDefaultPassword())
        );
    }
}

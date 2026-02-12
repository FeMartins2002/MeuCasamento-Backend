package br.com.MeuCasamento.repositories;

import br.com.MeuCasamento.entities.Party;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PartyRepository extends JpaRepository<Party, Long> {
    Optional<Party> findById(UUID externalPartyId);
}

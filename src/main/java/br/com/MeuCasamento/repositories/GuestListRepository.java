package br.com.MeuCasamento.repositories;

import br.com.MeuCasamento.entities.GuestList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GuestListRepository extends JpaRepository<GuestList, Long> {
    Optional<GuestList> findByPartyId(Long id);
}

package br.com.MeuCasamento.repositories;

import br.com.MeuCasamento.entities.GiftList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GiftListRepository extends JpaRepository<GiftList, Long> {
    Optional<GiftList> findByPartyId(Long id);
}

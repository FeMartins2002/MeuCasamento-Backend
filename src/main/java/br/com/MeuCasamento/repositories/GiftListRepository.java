package br.com.MeuCasamento.repositories;

import br.com.MeuCasamento.entities.GiftList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GiftListRepository extends JpaRepository<GiftList, Long> {
    GiftList findByPartyId(Long id);
}

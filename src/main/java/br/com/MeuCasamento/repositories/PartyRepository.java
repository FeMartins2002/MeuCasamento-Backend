package br.com.MeuCasamento.repositories;

import br.com.MeuCasamento.entities.Party;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyRepository extends JpaRepository<Party, Long> {

}

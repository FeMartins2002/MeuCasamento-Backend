package br.com.MeuCasamento.repositories;

import br.com.MeuCasamento.entities.GuestList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestListRepository extends JpaRepository<GuestList, Long> {

}

package br.com.MeuCasamento.repositories;

import br.com.MeuCasamento.entities.PartyHall;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PartyHallRepository extends JpaRepository<PartyHall, Long> {
    Optional<PartyHall> findByNameAndAddress(String name, String address);
}

package br.com.MeuCasamento.repositories;

import br.com.MeuCasamento.entities.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
    Guest findByEmail(String email);
}

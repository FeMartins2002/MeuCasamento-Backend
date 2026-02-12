package br.com.MeuCasamento.repositories;

import br.com.MeuCasamento.entities.Spouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpouseRepository extends JpaRepository<Spouse,Long> {
    Spouse findByCpf(String cpf);
}

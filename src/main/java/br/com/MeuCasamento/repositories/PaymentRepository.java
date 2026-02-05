package br.com.MeuCasamento.repositories;

import br.com.MeuCasamento.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}

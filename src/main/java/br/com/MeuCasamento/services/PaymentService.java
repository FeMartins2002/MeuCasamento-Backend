package br.com.MeuCasamento.services;

import br.com.MeuCasamento.entities.Payment;
import br.com.MeuCasamento.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public Payment save(Payment payment) {
        Payment existingPayment = paymentRepository.findByBudgetId(payment.getBudget().getId());

        if(existingPayment != null) {
            throw new RuntimeException("Orçamento já possui um pagamento");
        }
        return paymentRepository.save(payment);
    }
}

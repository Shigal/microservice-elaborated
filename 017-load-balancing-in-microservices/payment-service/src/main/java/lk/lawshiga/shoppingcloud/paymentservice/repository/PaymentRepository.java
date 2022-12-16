package lk.lawshiga.shoppingcloud.paymentservice.repository;

import lk.lawshiga.ordercloud.model.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}

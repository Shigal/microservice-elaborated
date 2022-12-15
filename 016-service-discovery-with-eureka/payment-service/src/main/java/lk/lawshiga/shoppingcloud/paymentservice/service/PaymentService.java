package lk.lawshiga.shoppingcloud.paymentservice.service;

import lk.lawshiga.shoppingcloud.paymentservice.model.DetailResponse;
import lk.lawshiga.ordercloud.model.payment.Payment;

import java.util.List;

public interface PaymentService {
    Payment save(Payment payment);

    Payment findById(int id);
    
    List<Payment> findAll();

    DetailResponse findDetailResponse(int id);
}

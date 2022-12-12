package lk.lawshiga.shoppingcloud.paymentservice.service;

import lk.lawshiga.shoppingcloud.paymentservice.model.DetailResponse;
import lk.lawshiga.shoppingcloud.paymentservice.repository.PaymentRepository;
import lk.lawshiga.ordercloud.model.customer.Customer;
import lk.lawshiga.ordercloud.model.order.Order;
import lk.lawshiga.ordercloud.model.payment.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Bean
    RestTemplate getRestTemplate(RestTemplateBuilder builder) {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment findById(int id) {
        Optional<Payment> paymentOptional = paymentRepository.findById(id);
        if(paymentOptional.isPresent()) {
            return paymentOptional.get();
        } else {
            return new Payment();
        }
    }

    @Override
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    @Override
    public DetailResponse findDetailResponse(int id) {
        Payment payment = findById(id);
        Customer customer = getCustomer(payment.getCustomerId());
        Order order = getOrder(payment.getOrderId());

        return new DetailResponse(payment, customer, order);
    }

    private Customer getCustomer(int customerId) {
        Customer customer = restTemplate.getForObject("http://localhost:8080/services/customers/" + customerId, Customer.class);
        return customer;
    }

    private Order getOrder(int orderId) {
        Order order = restTemplate.getForObject("http://localhost:9191/services/orders/" + orderId, Order.class);
        return order;
    }
}

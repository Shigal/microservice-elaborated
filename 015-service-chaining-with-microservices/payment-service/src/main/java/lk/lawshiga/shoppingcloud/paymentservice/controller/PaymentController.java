package lk.lawshiga.shoppingcloud.paymentservice.controller;

import lk.lawshiga.shoppingcloud.paymentservice.model.Response;
import lk.lawshiga.shoppingcloud.paymentservice.model.SimpleResponse;
import lk.lawshiga.shoppingcloud.paymentservice.service.PaymentService;
import lk.lawshiga.ordercloud.model.payment.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/services/payments")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping
    public Payment save(@RequestBody Payment payment) {
        return paymentService.save(payment);
    }

    @GetMapping(value = "/{id}")
    public Response getPayment(@PathVariable int id, @RequestParam(required = false) String type){
        if(type==null) {
            return new SimpleResponse(paymentService.findById(id));
        } else {
            return paymentService.findDetailResponse(id);
        }
    }

    @GetMapping
    public List<Payment> getAllPayments(){
        return paymentService.findAll();
    }
}

package lk.lawshiga.ordercloud.model.payment;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "payment_tb")
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int paymentId;

    private String paymentMethod;
    private int orderId;
    private int customerId;
    private double amount;
}

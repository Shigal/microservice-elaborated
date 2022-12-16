package lk.lawshiga.ordercloud.model.order;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "order_tb")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int quantity;
    private double price;

}

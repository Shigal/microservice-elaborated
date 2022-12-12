package lk.lawshiga.ordercloud.model.customer;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer_tb")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    private String firstName;
    private String lastName;
    private String zipcode;
    private String email;

    @OneToMany(mappedBy = "customer")
    private List<Loyality> loyalities;
}

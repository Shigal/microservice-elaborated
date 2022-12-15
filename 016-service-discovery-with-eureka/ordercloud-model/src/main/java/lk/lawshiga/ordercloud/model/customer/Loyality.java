package lk.lawshiga.ordercloud.model.customer;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "loyalityPoint_tb")
@Data
public class Loyality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int transactionId;

    @ManyToOne
    @JoinColumn
    Customer customer;

    int point;
    LocalDateTime expireDate;
}

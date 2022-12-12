package com.lawshiga.shoppingcloud.customerservice.repository;

import com.lawshiga.shoppingcloud.common.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}

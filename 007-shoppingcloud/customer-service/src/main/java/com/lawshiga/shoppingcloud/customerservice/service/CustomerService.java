package com.lawshiga.shoppingcloud.customerservice.service;

import com.lawshiga.shoppingcloud.common.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer save(Customer customer);

    Customer fetchById(int id);

    List<Customer> fetchAll();
}

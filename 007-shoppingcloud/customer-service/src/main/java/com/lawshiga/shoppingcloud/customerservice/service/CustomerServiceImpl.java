package com.lawshiga.shoppingcloud.customerservice.service;

import com.lawshiga.shoppingcloud.common.model.Customer;
import com.lawshiga.shoppingcloud.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer fetchById(int id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if(customerOptional.isPresent()){
            return customerOptional.get();
        } else{
            return null;
        }
    }

    @Override
    public List<Customer> fetchAll() {
        return customerRepository.findAll();
    }


}

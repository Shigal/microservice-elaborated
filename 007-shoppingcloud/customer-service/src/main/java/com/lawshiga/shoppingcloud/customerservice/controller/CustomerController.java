package com.lawshiga.shoppingcloud.customerservice.controller;

import com.lawshiga.shoppingcloud.common.model.Customer;
import com.lawshiga.shoppingcloud.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/services")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public Customer save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public Customer fetchById(@RequestParam int id) {
        return customerService.fetchById(id);
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public List<Customer> fetchAll() {
        return customerService.fetchAll();
    }
}

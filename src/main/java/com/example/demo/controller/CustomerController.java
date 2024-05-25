package com.example.demo.controller;


import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/save")
    public String saveCustomer(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }

    @GetMapping("/fetch")
    public List<Customer> fetchAllCustomers(){
        return customerService.fetchAllCustomers();
    }


    @GetMapping("/get/{id}")
    public Customer getCustomerById(@PathVariable("id") int id) {
        return customerService.findCustomerById(id);
    }

    @GetMapping("/getbyfirstname/{firstName}")
    public Customer getCustomerByFirstName(@PathVariable String firstName){
        return customerService.findByFirstName(firstName);
    }
    @PutMapping("/update")
    public String updateCustomer(@RequestBody Customer customer) {
        return customerService.updateCustomer(customer);
    }

}

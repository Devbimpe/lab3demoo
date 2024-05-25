package com.example.demo.service;


import com.example.demo.model.Customer;

import java.util.List;


public interface CustomerService {


    String createCustomer(Customer customer);

    List<Customer> fetchAllCustomers();

    Customer findByFirstName(String firstName);

    Customer findByPhoneNumber(String phoneNumber);

    String updateCustomer(Customer customer);

    Customer findCustomerById(int id);

    String deleteCustomerById(int id);
}


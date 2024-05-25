package com.example.demo.service.Implementation;


import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public String createCustomer(Customer customer) {
        if (customer.getPhoneNumber().equals("")){
            return  "Phone number is mandatory";
        }
        customerRepository.save(customer);
        return "Customer Successfully Created";
    }

    @Override
    public List<Customer> fetchAllCustomers() {
       return customerRepository.findAll();
    }


    @Override
    public String updateCustomer(Customer customer) {
        Optional<Customer> optCustomer = customerRepository.findById(customer.getId());
        if (optCustomer.isPresent()) {
            Customer customer1 = optCustomer.get();
            customer1.setFirstName(customer.getFirstName());
            customer1.setLastName(customer.getLastName());
            customer1.setAge(customer.getAge());
            customer1.setPhoneNumber(customer.getPhoneNumber());
            customer1.setMinor(customer.isMinor());
            customerRepository.save(customer1);
            return "Customer information updated successfully!";
        } else {
            return "Customer not found!";
        }
    }


    @Override
    public String deleteCustomerById(int id) {
        customerRepository.deleteById(id);
        return "Customer Information deleted successfully!";
    }


    @Override
    public Customer findByFirstName(String firstName) {
        return customerRepository.findByFirstName(firstName);
    }

    @Override
    public Customer findByPhoneNumber(String phoneNumber) {
        return customerRepository.findByPhoneNumber(phoneNumber);
    }

    @Override
    public Customer findCustomerById(int id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            System.out.println("Successfully fetched customer information: " + customer);
            return customer;
        } else {
            System.out.println("Customer not found with id: " + id);
            throw new RuntimeException("Customer not found with id: " + id);
        }
    }



}


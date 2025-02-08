package com.gym.gym_app.controller;

import com.gym.gym_app.entity.Customer;
import com.gym.gym_app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    private CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        System.out.println(customer.getFirstName());
        return customerService.addCustomer(customer);
    }

    @PostMapping("/init")
    public String initCustomers() {
        Customer customer1 = new Customer();
        customer1.setLastName("Doe");
        customer1.setFirstName("John");
        customer1.setRegistrationDate(LocalDate.of(2024, 1, 1));
        customer1.setPhoneNumber("123456789");
        

        Customer customer2 = new Customer();
        customer2.setLastName("Smith");
        customer2.setFirstName("Anna");
        customer2.setRegistrationDate(LocalDate.of(2023, 5, 12));
        customer2.setPhoneNumber("987654321");
        
        customerService.addCustomer(customer1);
        customerService.addCustomer(customer2);

        return "Données initialisées";
    }
}

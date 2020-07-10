package com.example.codeclan.capybara.controllers;

import com.example.codeclan.capybara.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    com.example.codeclan.capybara.repositories.ICustomerRepository customerRepository;

    @GetMapping
    public ResponseEntity getAllCustomersWithFilters(
            @RequestParam(required = false, name = "firstName") String firstName,
            @RequestParam(required = false, name = "lastName") String lastName,
            @RequestParam(required = false, name = "email") String email,
            @RequestParam(required = false, name = "phone") String phone
    ) {
        // http://localhost:8080/customers?firstName=Abby&&lastName=Anvil
        if(firstName != null && lastName != null){
            return new ResponseEntity(customerRepository.findByFirstNameAndLastName(firstName,lastName), HttpStatus.OK);
        }

        // http://localhost:8080/customers?lastName=Anvil
        if(lastName != null) {
            return new ResponseEntity(customerRepository.findByLastName(lastName), HttpStatus.OK);
        }

        // http://localhost:8080/customers?email=abbyanvil@gmail.com
        if(email != null){
            return new ResponseEntity(customerRepository.findByEmail(email), HttpStatus.OK);
        }

        // http://localhost:8080/customers?phone=111111
        if(phone != null){
            return new ResponseEntity(customerRepository.findByPhone(phone), HttpStatus.OK);
        }

        return new ResponseEntity(customerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getCustomerById(@PathVariable Long id){
        return new ResponseEntity(customerRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer>createCustomer(@RequestBody Customer customer){
        customerRepository.save(customer);
        return new ResponseEntity<>(customer,HttpStatus.CREATED);
    }

}

package com.example.codeclan.capybara.controllers;

import com.example.codeclan.capybara.models.Customer;
import com.example.codeclan.capybara.repositories.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    ICustomerRepository customerRepository;
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity getAllCustomersWithFilters(
            @RequestParam(required = false, name = "firstName") String firstName,
            @RequestParam(required = false, name = "lastName") String lastName,
            @RequestParam(required = false, name = "lastNameStartsWith") String lastNameStartsWith,
            @RequestParam(required = false, name = "lastNameNotContaining") String lastNameNotContaining,
            @RequestParam(required = false, name = "email") String email,
            @RequestParam(required = false, name = "emailStartsWith") String emailStartsWith,
            @RequestParam(required = false, name = "phone") String phone,
            @RequestParam(required = false, name = "phoneContaining") String phoneContaining
    ) {
        // http://localhost:8080/customers?firstName=Abby&&lastName=Anvil
        if(firstName != null && lastName != null){
            return new ResponseEntity(customerRepository.findByFirstNameIgnoreCaseAndLastNameIgnoreCase(firstName,lastName), HttpStatus.OK);
        }

        // http://localhost:8080/customers?lastName=Anvil
        if(lastName != null) {
            return new ResponseEntity(customerRepository.findByLastNameIgnoreCase(lastName), HttpStatus.OK);
        }

        // http://localhost:8080/customers?lastNameNotContaining=Anvil
        if(lastNameNotContaining != null) {
            return new ResponseEntity(customerRepository.findByLastNameIgnoreCaseNotContaining(lastNameNotContaining), HttpStatus.OK);
        }

        // http://localhost:8080/customers?lastNameStartsWith=An
        if(lastNameStartsWith != null) {
            return new ResponseEntity(customerRepository.findByLastNameIgnoreCaseStartingWith(lastNameStartsWith), HttpStatus.OK);
        }

        // http://localhost:8080/customers?email=abbyanvil@gmail.com
        if(email != null){
            return new ResponseEntity(customerRepository.findByEmailIgnoreCase(email), HttpStatus.OK);
        }

        // http://localhost:8080/customers?emailStartsWith=abbyanvil@g
        if(emailStartsWith != null){
            return new ResponseEntity(customerRepository.findByEmailIgnoreCaseStartingWith(emailStartsWith), HttpStatus.OK);
        }

        // http://localhost:8080/customers?phoneContaining=1111
        if(phoneContaining != null){
            return new ResponseEntity(customerRepository.findByPhoneContaining(phoneContaining), HttpStatus.OK);
        }

        // http://localhost:8080/customers?phone=111111
        if(phone != null){
            return new ResponseEntity(customerRepository.findByPhone(phone), HttpStatus.OK);
        }

        // http://localhost:8080/customers
        return new ResponseEntity(customerRepository.findAll(), HttpStatus.OK);
    }

    // http://localhost:8080/customers/1
    @GetMapping(value = "/{id}")
    public ResponseEntity getCustomerById(@PathVariable Long id){
        return new ResponseEntity(customerRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        customerRepository.save(customer);
        return new ResponseEntity<>(customer,HttpStatus.CREATED);
    }

}

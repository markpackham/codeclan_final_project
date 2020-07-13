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
            @RequestParam(required = false, name = "firstNameAsc") String firstNameAsc,
            @RequestParam(required = false, name = "firstNameDesc") String firstNameDesc,
            @RequestParam(required = false, name = "firstNameContaining") String firstNameContaining,
            @RequestParam(required = false, name = "firstNameStartsWith") String firstNameStartsWith,
            @RequestParam(required = false, name = "lastName") String lastName,
            @RequestParam(required = false, name = "lastNameAsc") String lastNameAsc,
            @RequestParam(required = false, name = "lastNameDesc") String lastNameDesc,
            @RequestParam(required = false, name = "lastNameContaining") String lastNameContaining,
            @RequestParam(required = false, name = "lastNameStartsWith") String lastNameStartsWith,
            @RequestParam(required = false, name = "lastNameNotContaining") String lastNameNotContaining,
            @RequestParam(required = false, name = "email") String email,
            @RequestParam(required = false, name = "emailStartsWith") String emailStartsWith,
            @RequestParam(required = false, name = "emailContaining") String emailContaining,
            @RequestParam(required = false, name = "phone") String phone,
            @RequestParam(required = false, name = "phoneContaining") String phoneContaining,
            @RequestParam(required = false, name = "idDesc") String idDesc
    ) {

        /* Customer Names */
        // http://localhost:8080/customers?firstName=Abby&&lastName=Anvil
        if(firstName != null && lastName != null){
            return new ResponseEntity(customerRepository.findByFirstNameIgnoreCaseAndLastNameIgnoreCase(firstName,lastName), HttpStatus.OK);
        }

        // http://localhost:8080/customers?firstName=Abby
        if(firstName != null) {
            return new ResponseEntity(customerRepository.findByFirstNameIgnoreCase(firstName), HttpStatus.OK);
        }

        // http://localhost:8080/customers?firstNameAsc=t
        if(firstNameAsc != null){
            return new ResponseEntity(customerRepository.findAllByOrderByFirstNameAsc(), HttpStatus.OK);
        }

        // http://localhost:8080/customers?firstNameDesc=t
        if(firstNameDesc != null){
            return new ResponseEntity(customerRepository.findAllByOrderByFirstNameDesc(), HttpStatus.OK);
        }

        // http://localhost:8080/customers?firstNameContaining=by
        if(firstNameContaining != null) {
            return new ResponseEntity(customerRepository.findByFirstNameContainingIgnoreCase(firstNameContaining), HttpStatus.OK);
        }

        // http://localhost:8080/customers?firstNameStartsWith=Ab
        if(firstNameStartsWith != null) {
            return new ResponseEntity(customerRepository.findByFirstNameStartsWithIgnoreCase(firstNameStartsWith), HttpStatus.OK);
        }

        // http://localhost:8080/customers?lastName=Anvil
        if(lastName != null) {
            return new ResponseEntity(customerRepository.findByLastNameIgnoreCase(lastName), HttpStatus.OK);
        }

        // http://localhost:8080/customers?lastNameAsc=t
        if(lastNameAsc != null) {
            return new ResponseEntity(customerRepository.findAllByOrderByLastNameAsc(), HttpStatus.OK);
        }

        // http://localhost:8080/customers?lastNameDesc=t
        if(lastNameDesc != null) {
            return new ResponseEntity(customerRepository.findAllByOrderByLastNameDesc(), HttpStatus.OK);
        }

        // http://localhost:8080/customers?lastNameContaining=Anvil
        if(lastNameContaining != null) {
            return new ResponseEntity(customerRepository.findByLastNameIgnoreCaseContaining(lastNameContaining), HttpStatus.OK);
        }

        // http://localhost:8080/customers?lastNameNotContaining=Anvil
        if(lastNameNotContaining != null) {
            return new ResponseEntity(customerRepository.findByLastNameIgnoreCaseNotContaining(lastNameNotContaining), HttpStatus.OK);
        }

        // http://localhost:8080/customers?lastNameStartsWith=An
        if(lastNameStartsWith != null) {
            return new ResponseEntity(customerRepository.findByLastNameIgnoreCaseStartingWith(lastNameStartsWith), HttpStatus.OK);
        }

        /* Email */
        // http://localhost:8080/customers?email=abbyanvil@gmail.com
        if(email != null){
            return new ResponseEntity(customerRepository.findByEmailIgnoreCase(email), HttpStatus.OK);
        }

        // http://localhost:8080/customers?emailContaining=@gmail.com
        if(emailContaining != null){
            return new ResponseEntity(customerRepository.findByEmailIgnoreCaseContaining(emailContaining), HttpStatus.OK);
        }

        // http://localhost:8080/customers?emailStartsWith=abbyanvil@g
        if(emailStartsWith != null){
            return new ResponseEntity(customerRepository.findByEmailIgnoreCaseStartingWith(emailStartsWith), HttpStatus.OK);
        }

        /* Phone */
        // http://localhost:8080/customers?phoneContaining=1111
        if(phoneContaining != null){
            return new ResponseEntity(customerRepository.findByPhoneContaining(phoneContaining), HttpStatus.OK);
        }

        // http://localhost:8080/customers?phone=111111
        if(phone != null){
            return new ResponseEntity(customerRepository.findByPhone(phone), HttpStatus.OK);
        }

        /* All */
        // http://localhost:8080/customers?idDesc=t
        if(idDesc != null){
            return new ResponseEntity(customerRepository.findAllByOrderByIdDesc(), HttpStatus.OK);
        }

        // http://localhost:8080/customers
        return new ResponseEntity(customerRepository.findAll(), HttpStatus.OK);
    }

    // http://localhost:8080/customers/1
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/{id}")
    public ResponseEntity getCustomerById(@PathVariable Long id){
        return new ResponseEntity(customerRepository.findById(id), HttpStatus.OK);
    }

    // http://localhost:8080/customers
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        customerRepository.save(customer);
        return new ResponseEntity<>(customer,HttpStatus.CREATED);
    }

    // http://localhost:8080/customers/1
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Customer> putCustomer(@RequestBody Customer customer, @PathVariable Long id){
        Customer customerToUpdate = customerRepository.findById(id).get();
        customerToUpdate.setFirstName(customer.getFirstName());
        customerToUpdate.setLastName(customer.getLastName());
        customerToUpdate.setEmail(customer.getEmail());
        customerToUpdate.setPhone(customer.getPhone());
        customerToUpdate.setReservations(customer.getReservations());
        customerRepository.save(customerToUpdate);
        return new ResponseEntity<>(customerToUpdate, HttpStatus.OK);
    }

}

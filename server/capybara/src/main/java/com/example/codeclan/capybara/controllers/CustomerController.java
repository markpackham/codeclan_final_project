package com.example.codeclan.capybara.controllers;

import com.example.codeclan.capybara.respositories.ICustomerRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    ICustomerRespository customerRespository;

    @GetMapping
    public ResponseEntity getAllCustomersAndFilters(){
        return new ResponseEntity(customerRespository.findAll(), HttpStatus.OK);
    }

}

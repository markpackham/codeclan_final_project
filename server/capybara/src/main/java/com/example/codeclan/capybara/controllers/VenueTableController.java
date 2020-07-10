package com.example.codeclan.capybara.controllers;

import com.example.codeclan.capybara.respositories.IVenueTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/venue-tables")
public class VenueTableController {

    @Autowired
    IVenueTableRepository venueTableRepository;

    @GetMapping
    public ResponseEntity getAllVenueTablesAndFilters(){
        return new ResponseEntity(venueTableRepository.findAll(), HttpStatus.OK);
    }
}

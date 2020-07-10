package com.example.codeclan.capybara.controllers;

import com.example.codeclan.capybara.respositories.IVenueTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/venue-tables")
public class VenueTableController {

    @Autowired
    IVenueTableRepository venueTableRepository;

    @GetMapping
    public ResponseEntity getAllVenueTablesWithFilters(
            @RequestParam(required = false, name = "covers") Integer covers,
            @RequestParam(required = false, name = "coversOver") Integer coversOver
    ) {
        // http://localhost:8080/venue-tables?covers=4
        if(covers != null) {
            return new ResponseEntity(venueTableRepository.findByCovers(covers), HttpStatus.OK);
        }
        // http://localhost:8080/venue-tables?coversOver=2
        if(coversOver != null) {
            return new ResponseEntity(venueTableRepository.findByCoversGreaterThan(coversOver), HttpStatus.OK);
        }
        return new ResponseEntity(venueTableRepository.findAll(), HttpStatus.OK);
    }
}

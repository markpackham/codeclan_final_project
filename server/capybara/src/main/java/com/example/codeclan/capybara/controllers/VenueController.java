package com.example.codeclan.capybara.controllers;

import com.example.codeclan.capybara.respositories.IVenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/venues")
public class VenueController {

    @Autowired
    IVenueRepository venueRepository;

    @GetMapping
    public ResponseEntity getAllVenuesAndFilters(
            @RequestParam(required = false, name = "name") String name
    ){

        // url path, http://localhost:8080/venues?name=WalkAbout
        if(name != null){
            return new ResponseEntity(venueRepository.findByName(name), HttpStatus.OK);
        }

        return new ResponseEntity(venueRepository.findAll(), HttpStatus.OK);
    }
}

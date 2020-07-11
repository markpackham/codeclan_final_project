package com.example.codeclan.capybara.controllers;

import com.example.codeclan.capybara.models.Venue;
import com.example.codeclan.capybara.repositories.IVenueRepository;
import com.example.codeclan.capybara.repositories.IVenueTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/venues")
public class VenueController {

    @Autowired
    IVenueRepository venueRepository;

    @Autowired
    IVenueTableRepository venueTableRepository;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity getAllVenuesWithFilters(
            @RequestParam(required = false, name = "name") String name,
            @RequestParam(required = false, name = "nameContaining") String nameContaining,
            @RequestParam(required = false, name = "notName") String notName,
            @RequestParam(required = false, name = "nameNotContaining") String nameNotContaining,
            @RequestParam(required = false, name = "noTables") String noTables
    ) {
        // http://localhost:8080/venues?name=WalkAbout
        if(name != null) {
            return new ResponseEntity(venueRepository.findByNameIgnoreCase(name), HttpStatus.OK);
        }

        // http://localhost:8080/venues?notName=WalkAbout
        if(notName != null) {
            return new ResponseEntity(venueRepository.findByNameIgnoreCaseNot(notName), HttpStatus.OK);
        }

        // http://localhost:8080/venues?nameContaining=WalkAb
        if(nameContaining != null) {
            return new ResponseEntity(venueRepository.findByNameIgnoreCaseContaining(nameContaining), HttpStatus.OK);
        }

        // http://localhost:8080/venues?nameNotContaining=WalkAb
        if(nameNotContaining != null) {
            return new ResponseEntity(venueRepository.findByNameIgnoreCaseNotContaining(nameNotContaining), HttpStatus.OK);
        }

        // http://localhost:8080/venues?noTables=t
        if(noTables != null){
            return new ResponseEntity(venueRepository.findByVenueTablesIsNull(), HttpStatus.OK);
        }

        // http://localhost:8080/venues
        return new ResponseEntity(venueRepository.findAll(), HttpStatus.OK);
    }

    // http://localhost:8080/venues/1
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/{id}")
    public ResponseEntity getVenueById(@PathVariable Long id) {
        return new ResponseEntity(venueRepository.findById(id), HttpStatus.OK);
    }

    // http://localhost:8080/venues/1/venue-tables
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/{id}/venue-tables")
    public ResponseEntity getAllVenueTablesByVenue(@PathVariable Long id) {
        return new ResponseEntity(venueTableRepository.findByVenueId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Venue>createVenue(@RequestBody Venue venue){
        venueRepository.save(venue);
        return new ResponseEntity<>(venue, HttpStatus.CREATED);
    }

}

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
            @RequestParam(required = false, name = "nameAsc") String nameAsc,
            @RequestParam(required = false, name = "nameDesc") String nameDesc,
            @RequestParam(required = false, name = "nameContaining") String nameContaining,
            @RequestParam(required = false, name = "notName") String notName,
            @RequestParam(required = false, name = "nameNotContaining") String nameNotContaining,
            @RequestParam(required = false, name = "noTables") String noTables,
            @RequestParam(required = false, name = "idDesc") String idDesc
    ) {

        /* Venue Names */
        // http://localhost:8080/venues?name=WalkAbout
        if(name != null) {
            return new ResponseEntity(venueRepository.findByNameIgnoreCase(name), HttpStatus.OK);
        }

        // http://localhost:8080/venues?nameAsc=t
        if(nameAsc != null) {
            return new ResponseEntity(venueRepository.findByOrderByNameAsc(), HttpStatus.OK);
        }

        // http://localhost:8080/venues?nameDesc=t
        if(nameDesc != null) {
            return new ResponseEntity(venueRepository.findByOrderByNameDesc(), HttpStatus.OK);
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

        /* VenueTables */
        // http://localhost:8080/venues?noTables=t
        if(noTables != null){
            return new ResponseEntity(venueRepository.findByVenueTablesIsNull(), HttpStatus.OK);
        }

        /* All */

        // http://localhost:8080/venues?idDesc=t
        if(idDesc != null){
            return new ResponseEntity(venueRepository.findAllByOrderByIdDesc(), HttpStatus.OK);
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

    // http://localhost:8080/venues
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public ResponseEntity<Venue>createVenue(@RequestBody Venue venue){
        venueRepository.save(venue);
        return new ResponseEntity<>(venue, HttpStatus.CREATED);
    }

    // http://localhost:8080/venues/1
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Venue> putVenue(@RequestBody Venue venue, @PathVariable Long id){
        Venue venueToUpdate = venueRepository.findById(id).get();
        venueToUpdate.setName(venue.getName());
        venueToUpdate.setVenueTables(venue.getVenueTables());
        venueRepository.save(venueToUpdate);
        return new ResponseEntity<>(venueToUpdate, HttpStatus.OK);
    }
}

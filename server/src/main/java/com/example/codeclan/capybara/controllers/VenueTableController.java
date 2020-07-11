package com.example.codeclan.capybara.controllers;

import com.example.codeclan.capybara.models.VenueTable;
import com.example.codeclan.capybara.repositories.IVenueTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/venue-tables")
public class VenueTableController {

    @Autowired
    IVenueTableRepository venueTableRepository;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity getAllVenueTablesWithFilters(
            @RequestParam(required = false, name = "covers") Integer covers,
            @RequestParam(required = false, name = "coversOver") Integer coversOver,
            @RequestParam(required = false, name = "coversUnder") Integer coversUnder
    ) {
        // http://localhost:8080/venue-tables?covers=4
        if(covers != null) {
            return new ResponseEntity(venueTableRepository.findByCovers(covers), HttpStatus.OK);
        }
        // http://localhost:8080/venue-tables?coversOver=2
        if(coversOver != null) {
            return new ResponseEntity(venueTableRepository.findByCoversGreaterThan(coversOver), HttpStatus.OK);
        }
        // http://localhost:8080/venue-tables?coversUnder=7
        if(coversUnder != null) {
            return new ResponseEntity(venueTableRepository.findByCoversLessThan(coversUnder), HttpStatus.OK);
        }
        // http://localhost:8080/venue-tables
        return new ResponseEntity(venueTableRepository.findAll(), HttpStatus.OK);
    }

    // http://localhost:8080/venue-tables/1
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/{id}")
    public ResponseEntity getVenueTableById(@PathVariable Long id){
        return new ResponseEntity(venueTableRepository.findById(id), HttpStatus.OK);
    }

    // http://localhost:8080/venue-tables
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public ResponseEntity<VenueTable>createVenueTable(@RequestBody VenueTable venueTable){
        venueTableRepository.save(venueTable);
        return new ResponseEntity<>(venueTable, HttpStatus.CREATED);
    }

    // http://localhost:8080/venue-tables/1
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(value = "/{id}")
    public ResponseEntity<VenueTable> putVenueTable(@RequestBody VenueTable venueTable, @PathVariable Long id){
        VenueTable venueTableToUpdate = venueTableRepository.findById(id).get();
        venueTableToUpdate.setCovers(venueTable.getCovers());
        venueTableToUpdate.setVenue(venueTable.getVenue());
        venueTableToUpdate.setReservations(venueTable.getReservations());
        venueTableRepository.save(venueTableToUpdate);
        return new ResponseEntity<>(venueTableToUpdate, HttpStatus.OK);
    }
}

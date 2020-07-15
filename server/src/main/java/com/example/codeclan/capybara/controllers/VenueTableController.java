package com.example.codeclan.capybara.controllers;

import com.example.codeclan.capybara.models.VenueTable;
import com.example.codeclan.capybara.repositories.IVenueTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/venue-tables")
public class VenueTableController {

    @Autowired
    IVenueTableRepository venueTableRepository;

    @GetMapping
    public ResponseEntity getAllVenueTablesWithFilters(
            @RequestParam(required = false, name = "covers") Integer covers,
            @RequestParam(required = false, name = "coversOver") Integer coversOver,
            @RequestParam(required = false, name = "coversUnder") Integer coversUnder,
            @RequestParam(required = false, name = "coversAsc") String coversAsc,
            @RequestParam(required = false, name = "coversDesc") String coversDesc,
            @RequestParam(required = false, name = "coversAvg") String coversAvg,
            @RequestParam(required = false, name = "venueAsc") String venueAsc,
            @RequestParam(required = false, name = "venueDesc") String venueDesc,
            @RequestParam(required = false, name = "idDesc") String idDesc
    ) {

        /* Covers */
        // http://localhost:8080/venue-tables?covers=4
        if (covers != null) {
            return new ResponseEntity(venueTableRepository.findByCovers(covers), HttpStatus.OK);
        }

        // http://localhost:8080/venue-tables?coversOver=2&&coversUnder=20
        if (coversOver != null && coversUnder != null) {
            return new ResponseEntity(venueTableRepository.findByCoversGreaterThanAndCoversLessThan(coversOver, coversUnder), HttpStatus.OK);
        }

        // http://localhost:8080/venue-tables?coversOver=2
        if (coversOver != null) {
            return new ResponseEntity(venueTableRepository.findByCoversGreaterThan(coversOver), HttpStatus.OK);
        }

        // http://localhost:8080/venue-tables?coversUnder=7
        if (coversUnder != null) {
            return new ResponseEntity(venueTableRepository.findByCoversLessThan(coversUnder), HttpStatus.OK);
        }

        // http://localhost:8080/venue-tables?coversAsc=t
        if (coversAsc != null) {
            return new ResponseEntity(venueTableRepository.findAllByOrderByCoversAsc(), HttpStatus.OK);
        }

        // http://localhost:8080/venue-tables?coversDesc=t
        if (coversDesc != null) {
            return new ResponseEntity(venueTableRepository.findAllByOrderByCoversDesc(), HttpStatus.OK);
        }

        // http://localhost:8080/venue-tables?coversAvg=t
        // This returns an int and not a Json File
        if (coversAvg != null) {
            List<VenueTable> foundVenueTables = venueTableRepository.findAll();
            int count = 0;
            for (VenueTable cover:foundVenueTables) {
                count += cover.getCovers();
            }
            if(foundVenueTables.size() > 0) {
                int averageCover = count / foundVenueTables.size();
                return  new ResponseEntity(averageCover, HttpStatus.OK);
            }
            return null;
        }

        /* Venues */
        // http://localhost:8080/venue-tables?venueAsc=t
        if(venueAsc != null){
            return new ResponseEntity(venueTableRepository.findAllByOrderByVenue_IdAsc(), HttpStatus.OK);
        }

        // http://localhost:8080/venue-tables?venueDesc=t
        if(venueDesc != null){
            return new ResponseEntity(venueTableRepository.findAllByOrderByVenue_IdDesc(), HttpStatus.OK);
        }


        /* All */

        // http://localhost:8080/venue-tables?idDesc=t
        if(idDesc != null){
            return new ResponseEntity(venueTableRepository.findAllByOrderByIdDesc(), HttpStatus.OK);
        }

        // http://localhost:8080/venue-tables
        return new ResponseEntity(venueTableRepository.findAll(), HttpStatus.OK);
    }

    // http://localhost:8080/venue-tables/1
    @GetMapping(value = "/{id}")
    public ResponseEntity getVenueTableById(@PathVariable Long id) {
        return new ResponseEntity(venueTableRepository.findById(id), HttpStatus.OK);
    }

    // http://localhost:8080/venue-tables
    @PostMapping
    public ResponseEntity<VenueTable> createVenueTable(@RequestBody VenueTable venueTable) {
        venueTableRepository.save(venueTable);
        return new ResponseEntity<>(venueTable, HttpStatus.CREATED);
    }

    // http://localhost:8080/venue-tables/1
    @PutMapping(value = "/{id}")
    public ResponseEntity<VenueTable> putVenueTable(@RequestBody VenueTable venueTable, @PathVariable Long id) {
        VenueTable venueTableToUpdate = venueTableRepository.findById(id).get();
        venueTableToUpdate.setCovers(venueTable.getCovers());
        venueTableToUpdate.setVenue(venueTable.getVenue());
        venueTableToUpdate.setReservations(venueTable.getReservations());
        venueTableRepository.save(venueTableToUpdate);
        return new ResponseEntity<>(venueTableToUpdate, HttpStatus.OK);
    }
}

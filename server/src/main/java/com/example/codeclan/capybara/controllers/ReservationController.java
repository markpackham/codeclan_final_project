package com.example.codeclan.capybara.controllers;

import com.example.codeclan.capybara.models.Reservation;
import com.example.codeclan.capybara.repositories.IReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/reservations")
public class ReservationController {

    @Autowired
    IReservationRepository reservationRepository;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity getAllReservationsWithFilters(
            @RequestParam(required = false, name = "startBefore")LocalDateTime startBefore,
            @RequestParam(required = false, name = "startAfter")LocalDateTime startAfter,
            @RequestParam(required = false, name = "coversAsc") String coversAsc,
            @RequestParam(required = false, name = "coversDesc") String coversDesc,
            @RequestParam(required = false, name = "idDesc") String idDesc
            ) {

        /* LocalDateTime */
        if(startBefore!= null && startAfter != null){
                return new ResponseEntity(reservationRepository.findByStartLessThanAndStartGreaterThan(startBefore, startAfter), HttpStatus.OK);
        }

        if(startBefore != null){
            return new ResponseEntity(reservationRepository.findByStartLessThan(startBefore), HttpStatus.OK);
        }

        if(startAfter != null){
            return new ResponseEntity(reservationRepository.findByStartGreaterThan(startAfter), HttpStatus.OK);
        }

        /* Covers Sort */
        // http://localhost:8080/reservations?coversAsc=t
        if(coversAsc != null){
            return new ResponseEntity(reservationRepository.findAllByOrderByVenueTableCoversAsc(), HttpStatus.OK);
        }
        // http://localhost:8080/reservations?coversDesc=t
        if(coversDesc != null){
            return new ResponseEntity(reservationRepository.findAllByOrderByVenueTableCoversDesc(), HttpStatus.OK);
        }


        /* All */
        // http://localhost:8080/reservations?idDesc=t
        if(idDesc != null){
            return new ResponseEntity(reservationRepository.findAllByOrderByIdDesc(), HttpStatus.OK);
        }

        // http://localhost:8080/reservations
        return new ResponseEntity(reservationRepository.findAll(), HttpStatus.OK);
    }

    // http://localhost:8080/reservations/1
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/{id}")
    public ResponseEntity getReservationById(@PathVariable Long id) {
        return new ResponseEntity(reservationRepository.findById(id), HttpStatus.OK);
    }

    // http://localhost:8080/reservations/
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        reservationRepository.save(reservation);
        return new ResponseEntity<>(reservation, HttpStatus.CREATED);
    }

    // Delete All Reservations
    // http://localhost:8080/reservations/
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping
    public ResponseEntity deleteAllReservations(){
        reservationRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // http://localhost:8080/reservations/1
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Long> deleteReservation(@PathVariable Long id){
        reservationRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    // http://localhost:8080/reservations/1
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Reservation> putReservation(@RequestBody Reservation reservation, @PathVariable Long id){
        Reservation reservationToUpdate = reservationRepository.findById(id).get();
        reservationToUpdate.setCustomer(reservation.getCustomer());
        reservationToUpdate.setVenueTable(reservation.getVenueTable());
        reservationToUpdate.setStart(reservation.getStart());
        reservationToUpdate.setEnd(reservation.getEnd());
        reservationRepository.save(reservationToUpdate);
        return new ResponseEntity<>(reservationToUpdate, HttpStatus.OK);
    }

}

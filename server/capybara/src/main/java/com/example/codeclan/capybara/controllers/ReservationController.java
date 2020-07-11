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

    // http://localhost:8080/reservations
    @GetMapping
    public ResponseEntity getAllReservationsWithFilters(
            @RequestParam(required = false, name = "startBefore")LocalDateTime startBefore,
            @RequestParam(required = false, name = "startAfter")LocalDateTime startAfter
            ) {

        if(startBefore!= null && startAfter != null){
                return new ResponseEntity(reservationRepository.findByStartLessThanAndStartGreaterThan(startBefore, startAfter), HttpStatus.OK);
        }

        if(startBefore != null){
            return new ResponseEntity(reservationRepository.findByStartLessThan(startBefore), HttpStatus.OK);
        }

        if(startAfter != null){
            return new ResponseEntity(reservationRepository.findByStartGreaterThan(startAfter), HttpStatus.OK);
        }

        return new ResponseEntity(reservationRepository.findAll(), HttpStatus.OK);
    }

    // http://localhost:8080/reservations/1
    @GetMapping(value = "/{id}")
    public ResponseEntity getReservationById(@PathVariable Long id) {
        return new ResponseEntity(reservationRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        reservationRepository.save(reservation);
        return new ResponseEntity<>(reservation, HttpStatus.CREATED);
    }

    // Delete All Reservations
    // http://localhost:8080/reservations/
    @DeleteMapping
    public ResponseEntity deleteAllReservations(){
        reservationRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // http://localhost:8080/reservations/1
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Long> deleteReservation(@PathVariable Long id){
        reservationRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}

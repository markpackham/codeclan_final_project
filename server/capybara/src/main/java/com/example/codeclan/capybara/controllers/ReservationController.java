package com.example.codeclan.capybara.controllers;

import com.example.codeclan.capybara.models.Reservation;
import com.example.codeclan.capybara.repositories.IReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/reservations")
public class ReservationController {

    @Autowired
    IReservationRepository reservationRepository;

    @GetMapping
    public ResponseEntity getAllReservationsWithFilters(){
        return new ResponseEntity(reservationRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getReservationById(@PathVariable Long id){
        return new ResponseEntity(reservationRepository.findById(id), HttpStatus.OK);
    }

//    @PostMapping
//    public ResponseEntity<Reservation>createReservation(@RequestBody Reservation reservation){
//        reservationRepository.save(reservation);
//        return new ResponseEntity<>(reservation,HttpStatus.CREATED);
//    }

}

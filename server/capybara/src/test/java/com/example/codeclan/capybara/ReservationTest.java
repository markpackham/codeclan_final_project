package com.example.codeclan.capybara;

import com.example.codeclan.capybara.models.Customer;
import com.example.codeclan.capybara.models.Reservation;
import com.example.codeclan.capybara.models.Venue;
import com.example.codeclan.capybara.models.VenueTable;
import com.example.codeclan.capybara.repositories.ICustomerRepository;
import com.example.codeclan.capybara.repositories.IReservationRepository;
import com.example.codeclan.capybara.repositories.IVenueRepository;
import com.example.codeclan.capybara.repositories.IVenueTableRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ReservationTest {

    @Autowired
    ICustomerRepository customerRepository;
    @Autowired
    IVenueTableRepository venueTableRepository;
    @Autowired
    IVenueRepository venueRepository;
    @Autowired
    IReservationRepository reservationRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void createReservationThenSave(){
        Customer customer1 = new Customer("Abby", "Anvil", "111111", "abbyanvil@gmail.com");
        customerRepository.save(customer1);
        Venue venue1 = new Venue("The Empty Venue");
        venueRepository.save(venue1);
        VenueTable venueTable1 = new VenueTable(4, venue1);
        venueTableRepository.save(venueTable1);

        Reservation reservation1 = new Reservation(customer1, venueTable1,
                LocalDateTime.of(2020, Month.AUGUST, 31, 18, 30),
                LocalDateTime.of(2020, Month.AUGUST, 31, 20, 30));
        reservationRepository.save(reservation1);
    }

    @Test
    public void canDeleteReservation(){
        int preDeleteSize = reservationRepository.findAll().size();
        reservationRepository.deleteById(1L);
        int postDeleteSize = reservationRepository.findAll().size();
        assertTrue(preDeleteSize > postDeleteSize);
    }

    @Test
    public void canSetStartAndEnd(){
        Customer customer1 = new Customer("Abby", "Anvil", "111111", "abbyanvil@gmail.com");
        Venue venue1 = new Venue("The Empty Venue");
        VenueTable venueTable1 = new VenueTable(4, venue1);
        Reservation reservation1 = new Reservation(customer1, venueTable1,
                LocalDateTime.of(2020, Month.AUGUST, 20, 18, 30),
                LocalDateTime.of(2020, Month.AUGUST, 20, 20, 30));
        reservation1.setStart(LocalDateTime.of(2033, Month.SEPTEMBER, 20, 18, 50));
        assertEquals("2033-09-20T18:50",reservation1.getStart().toString());
        reservation1.setEnd(LocalDateTime.of(2043, Month.OCTOBER, 20, 18, 55));
        assertEquals("2043-10-20T18:55",reservation1.getEnd().toString());
    }
}

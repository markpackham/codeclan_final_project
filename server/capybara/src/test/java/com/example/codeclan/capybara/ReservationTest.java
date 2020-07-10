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
import java.util.List;

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
    public void canGetStartBeforeDateTime(){
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

        Customer customer2 = new Customer("Abby2", "Anvil2", "211111", "abbyanvil2@gmail.com");
        customerRepository.save(customer2);
        Venue venue2 = new Venue("The Empty Venue");
        venueRepository.save(venue2);
        VenueTable venueTable2 = new VenueTable(4, venue2);
        venueTableRepository.save(venueTable2);

        Reservation reservation2 = new Reservation(customer2, venueTable2,
                LocalDateTime.of(2021, Month.AUGUST, 31, 18, 30),
                LocalDateTime.of(2021, Month.AUGUST, 31, 20, 30));
        reservationRepository.save(reservation2);

        List<Reservation> foundReservations = reservationRepository.findByStartLessThan(LocalDateTime.of(2090, Month.AUGUST, 31, 18, 30));
        System.out.println(foundReservations);
        assertTrue(foundReservations.size()>1);
    }

    @Test
    public void canGetStartBeforeDateTime__Zero(){
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

        Customer customer2 = new Customer("Abby2", "Anvil2", "211111", "abbyanvil2@gmail.com");
        customerRepository.save(customer2);
        Venue venue2 = new Venue("The Empty Venue");
        venueRepository.save(venue2);
        VenueTable venueTable2 = new VenueTable(4, venue2);
        venueTableRepository.save(venueTable2);

        Reservation reservation2 = new Reservation(customer2, venueTable2,
                LocalDateTime.of(2021, Month.AUGUST, 31, 18, 30),
                LocalDateTime.of(2021, Month.AUGUST, 31, 20, 30));
        reservationRepository.save(reservation2);

        List<Reservation> foundReservations = reservationRepository.findByStartLessThan(LocalDateTime.of(1977, Month.AUGUST, 31, 18, 30));
        System.out.println(foundReservations);
        assertTrue(foundReservations.size() == 0);
    }

    @Test
    public void canGetStartAfterDateTime(){
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

        Customer customer2 = new Customer("Abby2", "Anvil2", "211111", "abbyanvil2@gmail.com");
        customerRepository.save(customer2);
        Venue venue2 = new Venue("The Empty Venue");
        venueRepository.save(venue2);
        VenueTable venueTable2 = new VenueTable(4, venue2);
        venueTableRepository.save(venueTable2);

        Reservation reservation2 = new Reservation(customer2, venueTable2,
                LocalDateTime.of(2021, Month.AUGUST, 31, 18, 30),
                LocalDateTime.of(2021, Month.AUGUST, 31, 20, 30));
        reservationRepository.save(reservation2);

        List<Reservation> foundReservations = reservationRepository.findByStartGreaterThan(LocalDateTime.of(1980, Month.AUGUST, 31, 18, 30));
        System.out.println(foundReservations);
        assertTrue(foundReservations.size()>1);
    }

    @Test
    public void canDeleteReservation(){
        int preDeleteSize = reservationRepository.findAll().size();
        reservationRepository.deleteById(1L);
        int postDeleteSize = reservationRepository.findAll().size();
        assertTrue(preDeleteSize > postDeleteSize);
    }

    @Test
    public void canDeleteAllReservations(){
        int preDeleteSize = reservationRepository.findAll().size();
        assertTrue(preDeleteSize > 0);
        reservationRepository.deleteAll();
        int postDeleteSize = reservationRepository.findAll().size();
        assertTrue(postDeleteSize == 0);
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

package com.example.codeclan.capybara.components;

import com.example.codeclan.capybara.models.Customer;
import com.example.codeclan.capybara.models.Reservation;
import com.example.codeclan.capybara.models.Venue;
import com.example.codeclan.capybara.models.VenueTable;
import com.example.codeclan.capybara.respositories.ICustomerRespository;
import com.example.codeclan.capybara.respositories.IReservationRepository;
import com.example.codeclan.capybara.respositories.IVenueRepository;
import com.example.codeclan.capybara.respositories.IVenueTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.time.Month;

@Controller
public class DataLoader implements ApplicationRunner {

    @Autowired
    ICustomerRespository customerRespository;

    @Autowired
    IReservationRepository reservationRepository;

    @Autowired
    IVenueRepository venueRepository;

    @Autowired
    IVenueTableRepository venueTableRepository;

    public DataLoader() {}

    @Override
    public void run(ApplicationArguments args) {

        Customer customer1 = new Customer("Abby", "Anvil", "111111", "abbyanvil@gmail.com");
        customerRespository.save(customer1);
        Customer customer2 = new Customer("Bob", "Bobson", "222222", "bobbobson@gmail.com");
        customerRespository.save(customer2);
        Customer customer3 = new Customer("Charles", "Charleson", "333333", "charlescharleson@gmail.com");
        customerRespository.save(customer3);
        Customer customer4 = new Customer("Dave", "Davos", "444444", "davedavos@gmail.com");
        customerRespository.save(customer4);

        Venue venue1 = new Venue("The Empty Venue");
        venueRepository.save(venue1);
        Venue venue2 = new Venue("WalkAbout");
        venueRepository.save(venue2);
        Venue venue3 = new Venue("Tom Kitchin");
        venueRepository.save(venue3);
        Venue venue4 = new Venue("Wagamama");
        venueRepository.save(venue4);

        VenueTable venueTable1 = new VenueTable(4, venue1);
        venueTableRepository.save(venueTable1);
        VenueTable venueTable2 = new VenueTable(2, venue1);
        venueTableRepository.save(venueTable2);
        VenueTable venueTable3 = new VenueTable(6, venue2);
        venueTableRepository.save(venueTable3);
        VenueTable venueTable4 = new VenueTable(4, venue3);
        venueTableRepository.save(venueTable4);

        Reservation reservation1 = new Reservation(customer1, venueTable1,
                LocalDateTime.of(2020, Month.AUGUST, 31, 18, 30),
                LocalDateTime.of(2020, Month.AUGUST, 31, 20, 30));
        reservationRepository.save(reservation1);

        Reservation reservation2 = new Reservation(customer2, venueTable2,
                LocalDateTime.of(2020, Month.OCTOBER, 5, 13, 30),
                LocalDateTime.of(2020, Month.OCTOBER, 5, 15, 30));
        reservationRepository.save(reservation2);

    }

}

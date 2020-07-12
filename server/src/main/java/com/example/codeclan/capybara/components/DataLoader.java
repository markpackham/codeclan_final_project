package com.example.codeclan.capybara.components;

import com.example.codeclan.capybara.models.Customer;
import com.example.codeclan.capybara.models.Reservation;
import com.example.codeclan.capybara.models.Venue;
import com.example.codeclan.capybara.models.VenueTable;
import com.example.codeclan.capybara.repositories.ICustomerRepository;
import com.example.codeclan.capybara.repositories.IReservationRepository;
import com.example.codeclan.capybara.repositories.IVenueRepository;
import com.example.codeclan.capybara.repositories.IVenueTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.time.Month;

@Controller
public class DataLoader implements ApplicationRunner {

    @Autowired
    ICustomerRepository customerRespository;

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
        Customer customer2 = new Customer("Bob", "Bobson", "222222", "bobbobson@gmail.com");
        Customer customer3 = new Customer("Charles", "Charleson", "333333", "charlescharleson@gmail.com");
        Customer customer4 = new Customer("Dave", "Davos", "444444", "davedavos@gmail.com");
        Customer customer5 = new Customer("Edgar","Edwinson","555555","edgar@yahoo.com");
        Customer customer6 = new Customer("Fi", "Fifeson", "666666", "fi@hotmail.com");
        Customer customer7 = new Customer("Geoff","Geffson","777777","geoff@aol.com");
        Customer customer8 = new Customer("Harry", "Harryson", "888888","harry@gmail.com");
        Customer customer9 = new Customer("Ingrid","Ileson","999999","ingrid@gmail.com");
        Customer customer10 = new Customer("Jake", "Jakeson", "110000", "jake@hotmail.co.uk");
        Customer customer11 = new Customer("Kev","Kevinson","111000","kev@aol.com");
        Customer customer12 = new Customer("Leo","Liamson","112000","leo@protonmail.com");
        Customer customer13 = new Customer("Mike","Mikeson","113000","mike@bt.com");
        Customer customer14 = new Customer("Neil","Neilson","114000","neil@gmail.com");
        Customer customer15 = new Customer("Oscar","Ollieson","115000","oscar@aol.com");
        Customer customer16 = new Customer("Paul","Paulson","116000","paul@askjeeves.com");
        Customer customer17 = new Customer("Quist", "Quellson", "117000","quell@gmail.com");
        Customer customer18 = new Customer("Romeo","Romeson","118000","roman@aol.com");
        Customer customer19 = new Customer("Steve", "Steveson","119000","steve@steve.net");
        Customer customer20 = new Customer("Terry","Terryson","120000","terry@telnet.co.uk");

        customerRespository.save(customer1);
        customerRespository.save(customer2);
        customerRespository.save(customer3);
        customerRespository.save(customer4);
        customerRespository.save(customer5);
        customerRespository.save(customer6);
        customerRespository.save(customer7);
        customerRespository.save(customer8);
        customerRespository.save(customer9);
        customerRespository.save(customer10);
        customerRespository.save(customer11);
        customerRespository.save(customer12);
        customerRespository.save(customer13);
        customerRespository.save(customer14);
        customerRespository.save(customer15);
        customerRespository.save(customer16);
        customerRespository.save(customer17);
        customerRespository.save(customer18);
        customerRespository.save(customer19);
        customerRespository.save(customer20);

        Venue venue1 = new Venue("venue1");
        Venue venue2 = new Venue("venue2");
        Venue venue3 = new Venue("venue3");
        Venue venue4 = new Venue("venue4");
        Venue venue5 = new Venue("venue5");
        Venue venue6 = new Venue("venue6");
        Venue venue7 = new Venue("venue7");
        Venue venue8 = new Venue("venue8");
        Venue venue9 = new Venue("venue9");
        Venue venue10 = new Venue("venue10");
        Venue venue11 = new Venue("venue11");
        Venue venue12 = new Venue("venue12");
        Venue venue13 = new Venue("venue13");
        Venue venue14 = new Venue("venue14");
        Venue venue15 = new Venue("venue15");
        Venue venue16 = new Venue("venue16");
        Venue venue17 = new Venue("venue17");
        Venue venue18 = new Venue("venue18");
        Venue venue19 = new Venue("venue19");
        Venue venue20 = new Venue("venue20");
        venueRepository.save(venue1);
        venueRepository.save(venue2);
        venueRepository.save(venue3);
        venueRepository.save(venue4);
        venueRepository.save(venue5);
        venueRepository.save(venue6);
        venueRepository.save(venue7);
        venueRepository.save(venue8);
        venueRepository.save(venue9);
        venueRepository.save(venue10);
        venueRepository.save(venue11);
        venueRepository.save(venue12);
        venueRepository.save(venue13);
        venueRepository.save(venue14);
        venueRepository.save(venue15);
        venueRepository.save(venue16);
        venueRepository.save(venue17);
        venueRepository.save(venue18);
        venueRepository.save(venue19);
        venueRepository.save(venue20);

        VenueTable venueTable1 = new VenueTable(4, venue1);
        VenueTable venueTable2 = new VenueTable(2, venue1);
        VenueTable venueTable3 = new VenueTable(6, venue2);
        VenueTable venueTable4 = new VenueTable(4, venue3);
        VenueTable venueTable5 = new VenueTable(1, venue5);
        VenueTable venueTable6 = new VenueTable(1, venue6);
        VenueTable venueTable7 = new VenueTable(1, venue7);
        VenueTable venueTable8 = new VenueTable(1, venue8);
        VenueTable venueTable9 = new VenueTable(1, venue9);
        VenueTable venueTable10 = new VenueTable(1, venue10);
        VenueTable venueTable11 = new VenueTable(1, venue11);
        VenueTable venueTable12 = new VenueTable(1, venue12);
        VenueTable venueTable13 = new VenueTable(1, venue13);
        VenueTable venueTable14 = new VenueTable(1, venue14);
        VenueTable venueTable15 = new VenueTable(1, venue15);
        VenueTable venueTable16 = new VenueTable(1, venue16);
        VenueTable venueTable17 = new VenueTable(1, venue17);
        VenueTable venueTable18 = new VenueTable(1, venue18);
        VenueTable venueTable19 = new VenueTable(1, venue19);
        VenueTable venueTable20 = new VenueTable(1, venue20);
        venueTableRepository.save(venueTable1);
        venueTableRepository.save(venueTable2);
        venueTableRepository.save(venueTable3);
        venueTableRepository.save(venueTable4);
        venueTableRepository.save(venueTable5);
        venueTableRepository.save(venueTable6);
        venueTableRepository.save(venueTable7);
        venueTableRepository.save(venueTable8);
        venueTableRepository.save(venueTable9);
        venueTableRepository.save(venueTable10);
        venueTableRepository.save(venueTable11);
        venueTableRepository.save(venueTable12);
        venueTableRepository.save(venueTable13);
        venueTableRepository.save(venueTable14);
        venueTableRepository.save(venueTable15);
        venueTableRepository.save(venueTable16);
        venueTableRepository.save(venueTable17);
        venueTableRepository.save(venueTable18);
        venueTableRepository.save(venueTable19);
        venueTableRepository.save(venueTable20);

        Reservation reservation1 = new Reservation(customer1, venueTable1,
                LocalDateTime.of(2020, Month.AUGUST, 31, 18, 30),
                LocalDateTime.of(2020, Month.AUGUST, 31, 20, 30));

        Reservation reservation2 = new Reservation(customer2, venueTable2,
                LocalDateTime.of(2020, Month.OCTOBER, 5, 13, 30),
                LocalDateTime.of(2020, Month.OCTOBER, 5, 15, 30));

        Reservation reservation3 = new Reservation(customer3, venueTable3,
                LocalDateTime.of(2020, Month.OCTOBER, 1, 13, 30),
                LocalDateTime.of(2020, Month.OCTOBER, 1, 15, 30));

        Reservation reservation4 = new Reservation(customer4, venueTable4,
                LocalDateTime.of(2020, Month.OCTOBER, 2, 13, 30),
                LocalDateTime.of(2020, Month.OCTOBER, 2, 15, 30));

        Reservation reservation5 = new Reservation(customer5, venueTable5,
                LocalDateTime.of(2020, Month.OCTOBER, 3, 13, 30),
                LocalDateTime.of(2020, Month.OCTOBER, 3, 15, 30));

        Reservation reservation6 = new Reservation(customer6, venueTable6,
                LocalDateTime.of(2020, Month.OCTOBER, 4, 13, 30),
                LocalDateTime.of(2020, Month.OCTOBER, 4, 15, 30));

        Reservation reservation7 = new Reservation(customer7, venueTable7,
                LocalDateTime.of(2020, Month.OCTOBER, 5, 13, 30),
                LocalDateTime.of(2020, Month.OCTOBER, 5, 15, 30));

        Reservation reservation8 = new Reservation(customer8, venueTable8,
                LocalDateTime.of(2020, Month.OCTOBER, 6, 13, 30),
                LocalDateTime.of(2020, Month.OCTOBER, 6, 15, 30));

        Reservation reservation9 = new Reservation(customer9, venueTable9,
                LocalDateTime.of(2020, Month.OCTOBER, 7, 13, 30),
                LocalDateTime.of(2020, Month.OCTOBER, 7, 15, 30));

        Reservation reservation10 = new Reservation(customer10, venueTable10,
                LocalDateTime.of(2020, Month.OCTOBER, 8, 13, 30),
                LocalDateTime.of(2020, Month.OCTOBER, 8, 15, 30));

        Reservation reservation11 = new Reservation(customer11, venueTable11,
                LocalDateTime.of(2020, Month.OCTOBER, 9, 13, 30),
                LocalDateTime.of(2020, Month.OCTOBER, 9, 15, 30));

        Reservation reservation12 = new Reservation(customer12, venueTable12,
                LocalDateTime.of(2020, Month.OCTOBER, 10, 13, 30),
                LocalDateTime.of(2020, Month.OCTOBER, 10, 15, 30));

        Reservation reservation13 = new Reservation(customer13, venueTable13,
                LocalDateTime.of(2020, Month.OCTOBER, 11, 13, 30),
                LocalDateTime.of(2020, Month.OCTOBER, 11, 15, 30));

        Reservation reservation14 = new Reservation(customer14, venueTable14,
                LocalDateTime.of(2020, Month.OCTOBER, 12, 13, 30),
                LocalDateTime.of(2020, Month.OCTOBER, 12, 15, 30));

        Reservation reservation15 = new Reservation(customer15, venueTable15,
                LocalDateTime.of(2020, Month.OCTOBER, 13, 13, 30),
                LocalDateTime.of(2020, Month.OCTOBER, 13, 15, 30));

        Reservation reservation16 = new Reservation(customer16, venueTable16,
                LocalDateTime.of(2020, Month.OCTOBER, 14, 13, 30),
                LocalDateTime.of(2020, Month.OCTOBER, 14, 15, 30));

        Reservation reservation17 = new Reservation(customer17, venueTable17,
                LocalDateTime.of(2020, Month.OCTOBER, 17, 13, 30),
                LocalDateTime.of(2020, Month.OCTOBER, 17, 15, 30));

        Reservation reservation18 = new Reservation(customer18, venueTable18,
                LocalDateTime.of(2020, Month.OCTOBER, 18, 13, 30),
                LocalDateTime.of(2020, Month.OCTOBER, 18, 15, 30));

        Reservation reservation19 = new Reservation(customer19, venueTable19,
                LocalDateTime.of(2020, Month.OCTOBER, 19, 13, 30),
                LocalDateTime.of(2020, Month.OCTOBER, 19, 15, 30));

        Reservation reservation20 = new Reservation(customer20, venueTable20,
                LocalDateTime.of(2020, Month.OCTOBER, 20, 13, 30),
                LocalDateTime.of(2020, Month.OCTOBER, 20, 15, 30));

        reservationRepository.save(reservation1);
        reservationRepository.save(reservation2);
        reservationRepository.save(reservation3);
        reservationRepository.save(reservation4);
        reservationRepository.save(reservation5);
        reservationRepository.save(reservation6);
        reservationRepository.save(reservation7);
        reservationRepository.save(reservation8);
        reservationRepository.save(reservation9);
        reservationRepository.save(reservation10);
        reservationRepository.save(reservation11);
        reservationRepository.save(reservation12);
        reservationRepository.save(reservation13);
        reservationRepository.save(reservation14);
        reservationRepository.save(reservation15);
        reservationRepository.save(reservation16);
        reservationRepository.save(reservation17);
        reservationRepository.save(reservation18);
        reservationRepository.save(reservation19);
        reservationRepository.save(reservation20);

    }

}

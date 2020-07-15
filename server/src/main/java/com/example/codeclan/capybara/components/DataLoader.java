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
        Customer customer21 = new Customer("Ulrick","Ullson","121000","urlick@protonmail.com");
        Customer customer22 = new Customer("Violet","Violetta","122000","velito@gmail.com");
        Customer customer23 = new Customer("Wes","Wilfredson","123000","wes@wesorama.com");
        Customer customer24 = new Customer("Xavier","Xereson","124000","xavier@lycos.com");
        Customer customer25 = new Customer("Yevs","Yaleson","125000","yeves@lycos.co.uk");
        Customer customer26 = new Customer("Zeus","Zellson","126000","zeus@hotmail.com");
        Customer customer27 = new Customer("Adam", "Alpha", "127000", "adam@microsoft.com");
        Customer customer28 = new Customer("Bryan", "Bravo", "128000","bryan@amazon.com");
        Customer customer29 = new Customer("Carlos", "Charlies", "129000", "charlie@gov.co.uk");
        Customer customer30 = new Customer("Domnic", "Delta", "130000", "dom@domail.com");

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
        customerRespository.save(customer21);
        customerRespository.save(customer22);
        customerRespository.save(customer23);
        customerRespository.save(customer24);
        customerRespository.save(customer25);
        customerRespository.save(customer26);
        customerRespository.save(customer27);
        customerRespository.save(customer28);
        customerRespository.save(customer29);
        customerRespository.save(customer30);

        Venue venue1 = new Venue("The Capybara Cafe");
        Venue venue2 = new Venue("Venue B2");
        Venue venue3 = new Venue("Venue C3");
        Venue venue4 = new Venue("Venue D4");
        Venue venue5 = new Venue("Venue E5");
        Venue venue6 = new Venue("Venue F6");
        Venue venue7 = new Venue("Venue G7");
        Venue venue8 = new Venue("Venue H8");
        Venue venue9 = new Venue("Venue I9");
        Venue venue10 = new Venue("Venue J10");
        Venue venue11 = new Venue("Venue K11");
        Venue venue12 = new Venue("Venue L12");
        Venue venue13 = new Venue("Venue M13");
        Venue venue14 = new Venue("Venue N14");
        Venue venue15 = new Venue("Venue O15");
        Venue venue16 = new Venue("Venue P16");
        Venue venue17 = new Venue("Venue Q17");
        Venue venue18 = new Venue("Venue R18");
        Venue venue19 = new Venue("Venue S19");
        Venue venue20 = new Venue("Venue T20");
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
        VenueTable venueTable3 = new VenueTable(6, venue1);
        VenueTable venueTable4 = new VenueTable(4, venue1);
        VenueTable venueTable5 = new VenueTable(1, venue1);
        VenueTable venueTable6 = new VenueTable(2, venue1);
        VenueTable venueTable7 = new VenueTable(3, venue1);
        VenueTable venueTable8 = new VenueTable(4, venue1);
        VenueTable venueTable9 = new VenueTable(5, venue1);
        VenueTable venueTable10 = new VenueTable(6, venue1);
        VenueTable venueTable11 = new VenueTable(7, venue1);
        VenueTable venueTable12 = new VenueTable(1, venue1);
        VenueTable venueTable13 = new VenueTable(1, venue1);
        VenueTable venueTable14 = new VenueTable(1, venue1);
        VenueTable venueTable15 = new VenueTable(1, venue1);
        VenueTable venueTable16 = new VenueTable(1, venue1);
        VenueTable venueTable17 = new VenueTable(1, venue1);
        VenueTable venueTable18 = new VenueTable(1, venue1);
        VenueTable venueTable19 = new VenueTable(1, venue1);
        VenueTable venueTable20 = new VenueTable(1, venue1);

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

        Reservation reservation1 = new Reservation(customer1, venueTable1,
                LocalDateTime.of(2020, Month.AUGUST, 31, 10, 10),
                LocalDateTime.of(2020, Month.AUGUST, 31, 11, 10),1, "birthday party");

        Reservation reservation2 = new Reservation(customer2, venueTable2,
                LocalDateTime.of(2020, Month.OCTOBER, 5, 12, 20),
                LocalDateTime.of(2020, Month.OCTOBER, 5, 13, 20),2, "wedding");

        Reservation reservation3 = new Reservation(customer3, venueTable3,
                LocalDateTime.of(2020, Month.OCTOBER, 1, 14, 30),
                LocalDateTime.of(2020, Month.OCTOBER, 1, 15, 30),3, "allergic to nuts");

        Reservation reservation4 = new Reservation(customer4, venueTable4,
                LocalDateTime.of(2020, Month.OCTOBER, 2, 16, 40),
                LocalDateTime.of(2020, Month.OCTOBER, 2, 17, 40),4, "no alcohol");

        Reservation reservation5 = new Reservation(customer5, venueTable5,
                LocalDateTime.of(2020, Month.OCTOBER, 3, 18, 50),
                LocalDateTime.of(2020, Month.OCTOBER, 3, 19, 50),5, "allergic to fish");

        Reservation reservation6 = new Reservation(customer6, venueTable6,
                LocalDateTime.of(2020, Month.OCTOBER, 4, 10, 10),
                LocalDateTime.of(2020, Month.OCTOBER, 4, 11, 10),6 , "wedding");

        Reservation reservation7 = new Reservation(customer7, venueTable7,
                LocalDateTime.of(2020, Month.OCTOBER, 5, 12, 20),
                LocalDateTime.of(2020, Month.OCTOBER, 5, 13, 20),7, "vegan food only");

        Reservation reservation8 = new Reservation(customer8, venueTable8,
                LocalDateTime.of(2020, Month.OCTOBER, 6, 14, 30),
                LocalDateTime.of(2020, Month.OCTOBER, 6, 15, 30),8, "smoking room");

        Reservation reservation9 = new Reservation(customer9, venueTable9,
                LocalDateTime.of(2020, Month.OCTOBER, 7, 16, 40),
                LocalDateTime.of(2020, Month.OCTOBER, 7, 17, 40),9, "singers table");

        Reservation reservation10 = new Reservation(customer10, venueTable10,
                LocalDateTime.of(2020, Month.OCTOBER, 8, 13, 50),
                LocalDateTime.of(2020, Month.OCTOBER, 8, 15, 50),8, "children's party");

        Reservation reservation11 = new Reservation(customer11, venueTable11,
                LocalDateTime.of(2020, Month.OCTOBER, 9, 13, 30),
                LocalDateTime.of(2020, Month.OCTOBER, 9, 15, 30),7, "allergic to dairy");

        Reservation reservation12 = new Reservation(customer12, venueTable12,
                LocalDateTime.of(2020, Month.OCTOBER, 10, 13, 30),
                LocalDateTime.of(2020, Month.OCTOBER, 10, 15, 30),6, "gluten free");

        Reservation reservation13 = new Reservation(customer13, venueTable13,
                LocalDateTime.of(2020, Month.OCTOBER, 11, 13, 30),
                LocalDateTime.of(2020, Month.OCTOBER, 11, 15, 30),5, "funeral");

        Reservation reservation14 = new Reservation(customer14, venueTable14,
                LocalDateTime.of(2020, Month.OCTOBER, 12, 13, 30),
                LocalDateTime.of(2020, Month.OCTOBER, 12, 15, 30),4, "baptism");

        Reservation reservation15 = new Reservation(customer15, venueTable15,
                LocalDateTime.of(2020, Month.OCTOBER, 13, 13, 30),
                LocalDateTime.of(2020, Month.OCTOBER, 13, 15, 30),3, "confirmation");

        Reservation reservation16 = new Reservation(customer16, venueTable16,
                LocalDateTime.of(2020, Month.OCTOBER, 14, 13, 30),
                LocalDateTime.of(2020, Month.OCTOBER, 14, 15, 30),2, "stag party");

        Reservation reservation17 = new Reservation(customer17, venueTable17,
                LocalDateTime.of(2020, Month.OCTOBER, 17, 13, 30),
                LocalDateTime.of(2020, Month.OCTOBER, 17, 15, 30),1, "hen party");

        Reservation reservation18 = new Reservation(customer18, venueTable18,
                LocalDateTime.of(2020, Month.OCTOBER, 18, 13, 30),
                LocalDateTime.of(2020, Month.OCTOBER, 18, 15, 30),2, "private gathering");

        Reservation reservation19 = new Reservation(customer19, venueTable19,
                LocalDateTime.of(2020, Month.OCTOBER, 19, 13, 30),
                LocalDateTime.of(2020, Month.OCTOBER, 19, 15, 30),3, "staff party");

        Reservation reservation20 = new Reservation(customer20, venueTable20,
                LocalDateTime.of(2020, Month.OCTOBER, 20, 13, 30),
                LocalDateTime.of(2020, Month.OCTOBER, 20, 15, 30),4, "ordination");

        Reservation reservation21 = new Reservation(customer21, venueTable1,
                LocalDateTime.of(2020, Month.OCTOBER, 21, 13, 30),
                LocalDateTime.of(2020, Month.OCTOBER, 21, 15, 30),5, "non smoking");

        Reservation reservation22 = new Reservation(customer22, venueTable2,
                LocalDateTime.of(2020, Month.OCTOBER, 22, 13, 30),
                LocalDateTime.of(2020, Month.OCTOBER, 22, 15, 30),6, "wheelchair access");

        Reservation reservation23 = new Reservation(customer23, venueTable3,
                LocalDateTime.of(2020, Month.OCTOBER, 23, 13, 30),
                LocalDateTime.of(2020, Month.OCTOBER, 23, 15, 30),7,"comedy night");

        Reservation reservation24 = new Reservation(customer24, venueTable4,
                LocalDateTime.of(2020, Month.OCTOBER, 24, 13, 30),
                LocalDateTime.of(2020, Month.OCTOBER, 24, 15, 30),8, "folk night");

        Reservation reservation25 = new Reservation(customer25, venueTable5,
                LocalDateTime.of(2020, Month.OCTOBER, 25, 13, 30),
                LocalDateTime.of(2020, Month.OCTOBER, 25, 15, 30),9, "allergic to red meat");

        Reservation reservation26 = new Reservation(customer26, venueTable6,
                LocalDateTime.of(2020, Month.OCTOBER, 26, 13, 30),
                LocalDateTime.of(2020, Month.OCTOBER, 26, 15, 30),8, "fancy dress party");

        Reservation reservation27 = new Reservation(customer27, venueTable7,
                LocalDateTime.of(2020, Month.OCTOBER, 27, 13, 30),
                LocalDateTime.of(2020, Month.OCTOBER, 27, 15, 30),7, "sit outdoors");

        Reservation reservation28 = new Reservation(customer28, venueTable8,
                LocalDateTime.of(2020, Month.OCTOBER, 28, 13, 30),
                LocalDateTime.of(2020, Month.OCTOBER, 28, 15, 30),6, "smoking");

        Reservation reservation29 = new Reservation(customer29, venueTable9,
                LocalDateTime.of(2020, Month.OCTOBER, 29, 13, 30),
                LocalDateTime.of(2020, Month.OCTOBER, 29, 15, 30),5, "an additional 3 may join");

        Reservation reservation30 = new Reservation(customer30, venueTable10,
                LocalDateTime.of(2020, Month.OCTOBER, 30, 13, 30),
                LocalDateTime.of(2020, Month.OCTOBER, 30, 15, 30),4, "2 people might not show");

        Reservation reservation31 = new Reservation(customer1, venueTable1,
                LocalDateTime.of(2020, Month.NOVEMBER, 1, 13, 30),
                LocalDateTime.of(2020, Month.NOVEMBER, 1, 15, 30),1, "allergic to nuts");

        Reservation reservation32 = new Reservation(customer1, venueTable1,
                LocalDateTime.of(2020, Month.NOVEMBER, 2, 13, 30),
                LocalDateTime.of(2020, Month.NOVEMBER, 2, 15, 30),1, "allergic to dairy");

        Reservation reservation33 = new Reservation(customer1, venueTable1,
                LocalDateTime.of(2020, Month.NOVEMBER, 3, 13, 30),
                LocalDateTime.of(2020, Month.NOVEMBER, 3, 15, 30),1, "allergic to fish");

        Reservation reservation34 = new Reservation(customer2, venueTable2,
                LocalDateTime.of(2020, Month.NOVEMBER, 4, 10, 30),
                LocalDateTime.of(2020, Month.NOVEMBER, 4, 11, 30),2, "vegan party");

        Reservation reservation35 = new Reservation(customer2, venueTable2,
                LocalDateTime.of(2020, Month.NOVEMBER, 4, 12, 30),
                LocalDateTime.of(2020, Month.NOVEMBER, 4, 13, 30),2, "vegiterian party");

        Reservation reservation36 = new Reservation(customer3, venueTable3,
                LocalDateTime.of(2020, Month.NOVEMBER, 5, 14, 30),
                LocalDateTime.of(2020, Month.NOVEMBER, 5, 15, 30),2, "no alcohol");

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
        reservationRepository.save(reservation21);
        reservationRepository.save(reservation22);
        reservationRepository.save(reservation23);
        reservationRepository.save(reservation24);
        reservationRepository.save(reservation25);
        reservationRepository.save(reservation26);
        reservationRepository.save(reservation27);
        reservationRepository.save(reservation28);
        reservationRepository.save(reservation29);
        reservationRepository.save(reservation30);
        reservationRepository.save(reservation31);
        reservationRepository.save(reservation32);
        reservationRepository.save(reservation33);
        reservationRepository.save(reservation34);
        reservationRepository.save(reservation35);
        reservationRepository.save(reservation36);
    }

}

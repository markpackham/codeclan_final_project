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
    public void canCreateReservationThenSave(){
        Customer customer1013 = new Customer("customer1013FN", "customer1013LN", "1013", "customer1013@gmail.com");
        customerRepository.save(customer1013);
        Venue venue1000 = new Venue("venue1000");
        venueRepository.save(venue1000);
        VenueTable venueTable1000 = new VenueTable(4, venue1000);
        venueTableRepository.save(venueTable1000);

        Reservation reservation1000 = new Reservation(customer1013, venueTable1000,
                LocalDateTime.of(2020, Month.AUGUST, 31, 18, 30),
                LocalDateTime.of(2020, Month.AUGUST, 31, 20, 30));
        reservationRepository.save(reservation1000);
        assertTrue(reservationRepository.findAll().size()>0);
    }

    @Test
    public void canGetStartBeforeDateTime(){
        Customer customer1014 = new Customer("customer1014FN", "customer1014FN", "1014", "customer1014@gmail.com");
        customerRepository.save(customer1014);
        Venue venue1001 = new Venue("venue1001");
        venueRepository.save(venue1001);
        VenueTable venueTable1001 = new VenueTable(4, venue1001);
        venueTableRepository.save(venueTable1001);

        Reservation reservation1001 = new Reservation(customer1014, venueTable1001,
                LocalDateTime.of(2020, Month.AUGUST, 31, 18, 30),
                LocalDateTime.of(2020, Month.AUGUST, 31, 20, 30));
        reservationRepository.save(reservation1001);

        Customer customer1015 = new Customer("customer1015FN", "customer1015LN", "1015", "customer1015@gmail.com");
        customerRepository.save(customer1015);
        Venue venue1003 = new Venue("venue1003");
        venueRepository.save(venue1003);
        VenueTable venueTable1003 = new VenueTable(4, venue1003);
        venueTableRepository.save(venueTable1003);

        Reservation reservation1003 = new Reservation(customer1015, venueTable1003,
                LocalDateTime.of(2021, Month.AUGUST, 31, 18, 30),
                LocalDateTime.of(2021, Month.AUGUST, 31, 20, 30));
        reservationRepository.save(reservation1003);

        List<Reservation> foundReservations = reservationRepository.findByStartLessThan(LocalDateTime.of(2090, Month.AUGUST, 31, 18, 30));
        System.out.println(foundReservations);
        assertTrue(foundReservations.size()>1);
    }

    @Test
    public void canGetStartBeforeDateTime__ZeroResults(){
        Customer customer1016 = new Customer("customer1016FN", "customer1016LN", "1016", "customer1016@gmail.com");
        customerRepository.save(customer1016);
        Venue venue1016 = new Venue("venue1016");
        venueRepository.save(venue1016);
        VenueTable venueTable1016 = new VenueTable(4, venue1016);
        venueTableRepository.save(venueTable1016);

        Reservation reservation1016 = new Reservation(customer1016, venueTable1016,
                LocalDateTime.of(2020, Month.AUGUST, 31, 18, 30),
                LocalDateTime.of(2020, Month.AUGUST, 31, 20, 30));
        reservationRepository.save(reservation1016);

        Customer customer1017 = new Customer("customer1017FN", "customer1017LN", "1017", "customer1017@gmail.com");
        customerRepository.save(customer1017);
        Venue venue1017 = new Venue("venue1017");
        venueRepository.save(venue1017);
        VenueTable venueTable1017 = new VenueTable(4, venue1017);
        venueTableRepository.save(venueTable1017);

        Reservation reservation1017 = new Reservation(customer1017, venueTable1017,
                LocalDateTime.of(2021, Month.AUGUST, 31, 18, 30),
                LocalDateTime.of(2021, Month.AUGUST, 31, 20, 30));
        reservationRepository.save(reservation1017);

        List<Reservation> foundReservations = reservationRepository.findByStartLessThan(LocalDateTime.of(1977, Month.AUGUST, 31, 18, 30));
        System.out.println(foundReservations);
        assertTrue(foundReservations.size() == 0);
    }

    @Test
    public void canGetStartAfterDateTime(){
        Customer customer1018 = new Customer("customer1018FN", "customer1018LN", "1018", "customer1018@gmail.com");
        customerRepository.save(customer1018);
        Venue venue1 = new Venue("The Empty Venue");
        venueRepository.save(venue1);
        VenueTable venueTable1 = new VenueTable(4, venue1);
        venueTableRepository.save(venueTable1);

        Reservation reservation1 = new Reservation(customer1018, venueTable1,
                LocalDateTime.of(2020, Month.AUGUST, 31, 18, 30),
                LocalDateTime.of(2020, Month.AUGUST, 31, 20, 30));
        reservationRepository.save(reservation1);

        Customer customer1019 = new Customer("customer1019FN", "customer1019LN", "1019", "customer1019@gmail.com");
        customerRepository.save(customer1019);
        Venue venue1019 = new Venue("venue1019");
        venueRepository.save(venue1019);
        VenueTable venueTable1019 = new VenueTable(4, venue1019);
        venueTableRepository.save(venueTable1019);

        Reservation reservation1020 = new Reservation(customer1019, venueTable1019,
                LocalDateTime.of(2021, Month.AUGUST, 31, 18, 30),
                LocalDateTime.of(2021, Month.AUGUST, 31, 20, 30));
        reservationRepository.save(reservation1020);

        List<Reservation> foundReservations = reservationRepository.findByStartGreaterThan(LocalDateTime.of(1980, Month.AUGUST, 31, 18, 30));
        System.out.println(foundReservations);
        assertTrue(foundReservations.size()>1);
    }

    @Test
    public void canGetStartAfterDateTime__ZeroResults(){
        Customer customer1020 = new Customer("customer1020FN", "customer1020LN", "1020", "customer1020@gmail.com");
        customerRepository.save(customer1020);
        Venue venue1020 = new Venue("venue1020");
        venueRepository.save(venue1020);
        VenueTable venueTable1020 = new VenueTable(4, venue1020);
        venueTableRepository.save(venueTable1020);

        Reservation reservation1020 = new Reservation(customer1020, venueTable1020,
                LocalDateTime.of(2020, Month.AUGUST, 31, 18, 30),
                LocalDateTime.of(2020, Month.AUGUST, 31, 20, 30));
        reservationRepository.save(reservation1020);

        Customer customer1021 = new Customer("customer1021FN", "customer1021LN", "1021", "customer1021@gmail.com");
        customerRepository.save(customer1021);
        Venue venue1021 = new Venue("venue1021");
        venueRepository.save(venue1021);
        VenueTable venueTable1021 = new VenueTable(4, venue1021);
        venueTableRepository.save(venueTable1021);

        Reservation reservation1021 = new Reservation(customer1021, venueTable1021,
                LocalDateTime.of(2021, Month.AUGUST, 31, 18, 30),
                LocalDateTime.of(2021, Month.AUGUST, 31, 20, 30));
        reservationRepository.save(reservation1021);

        List<Reservation> foundReservations = reservationRepository.findByStartGreaterThan(LocalDateTime.of(4040, Month.AUGUST, 31, 18, 30));
        System.out.println(foundReservations);
        assertTrue(foundReservations.size()==0);
    }

    @Test
    public void canGetBeforeDateTimeAndAfterDateTime(){
        Customer customer1022 = new Customer("customer1022FN", "customer1022LN", "1022", "customer1022@gmail.com");
        customerRepository.save(customer1022);
        Venue venue1022 = new Venue("venue1022");
        venueRepository.save(venue1022);
        VenueTable venueTable1022 = new VenueTable(4, venue1022);
        venueTableRepository.save(venueTable1022);

        Reservation reservation1022 = new Reservation(customer1022, venueTable1022,
                LocalDateTime.of(2020, Month.AUGUST, 31, 18, 30),
                LocalDateTime.of(2020, Month.AUGUST, 31, 20, 30));
        reservationRepository.save(reservation1022);

        Customer customer1023 = new Customer("customer1023FN", "customer1023LN", "1023", "customer1023@gmail.com");
        customerRepository.save(customer1023);
        Venue venue1023 = new Venue("reservation1022");
        venueRepository.save(venue1023);
        VenueTable venueTable1023 = new VenueTable(4, venue1023);
        venueTableRepository.save(venueTable1023);

        Reservation reservation1023 = new Reservation(customer1023, venueTable1023,
                LocalDateTime.of(2021, Month.AUGUST, 31, 18, 30),
                LocalDateTime.of(2021, Month.AUGUST, 31, 20, 30));
        reservationRepository.save(reservation1023);

        List<Reservation> foundReservations = reservationRepository.findByStartLessThanAndStartGreaterThan(LocalDateTime.of(2090, Month.AUGUST, 31, 18, 30),LocalDateTime.of(1980, Month.AUGUST, 31, 18, 30));
        System.out.println(foundReservations);
        assertTrue(foundReservations.size()>1);
    }

    @Test
    public void canGetBeforeDateTimeAndAfterDateTime__ZeroResults(){
        Customer customer1024 = new Customer("customer1024FN", "customer1024LN", "1024", "customer1024@gmail.com");
        customerRepository.save(customer1024);
        Venue venue1024 = new Venue("venue1024");
        venueRepository.save(venue1024);
        VenueTable venueTable1024 = new VenueTable(4, venue1024);
        venueTableRepository.save(venueTable1024);

        Reservation reservation1024 = new Reservation(customer1024, venueTable1024,
                LocalDateTime.of(2020, Month.AUGUST, 31, 18, 30),
                LocalDateTime.of(2020, Month.AUGUST, 31, 20, 30));
        reservationRepository.save(reservation1024);

        Customer customer1025 = new Customer("customer1025FN", "customer1025LN", "1025", "customer1025@gmail.com");
        customerRepository.save(customer1025);
        Venue venue1025 = new Venue("venue1025");
        venueRepository.save(venue1025);
        VenueTable venueTable1025 = new VenueTable(4, venue1025);
        venueTableRepository.save(venueTable1025);

        Reservation reservation1025 = new Reservation(customer1025, venueTable1025,
                LocalDateTime.of(2021, Month.AUGUST, 31, 18, 30),
                LocalDateTime.of(2021, Month.AUGUST, 31, 20, 30));
        reservationRepository.save(reservation1025);

        List<Reservation> foundReservations = reservationRepository.findByStartLessThanAndStartGreaterThan(LocalDateTime.of(1977, Month.AUGUST, 31, 18, 30),LocalDateTime.of(4040, Month.AUGUST, 31, 18, 30));
        System.out.println(foundReservations);
        assertTrue(foundReservations.size()==0);
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
        Customer customer1026 = new Customer("customer1026FN", "customer1026LN", "1026", "customer1026@gmail.com");
        Venue venue1026 = new Venue("venue1026");
        VenueTable venueTable1026 = new VenueTable(4, venue1026);
        Reservation reservation1026 = new Reservation(customer1026, venueTable1026,
                LocalDateTime.of(2020, Month.AUGUST, 20, 18, 30),
                LocalDateTime.of(2020, Month.AUGUST, 20, 20, 30));
        reservation1026.setStart(LocalDateTime.of(2033, Month.SEPTEMBER, 20, 18, 50));
        assertEquals("2033-09-20T18:50",reservation1026.getStart().toString());
        reservation1026.setEnd(LocalDateTime.of(2043, Month.OCTOBER, 20, 18, 55));
        assertEquals("2043-10-20T18:55",reservation1026.getEnd().toString());
    }
}

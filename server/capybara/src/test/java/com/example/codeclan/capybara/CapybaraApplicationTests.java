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

@SpringBootTest
class CapybaraApplicationTests {

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
	public void createCustomerThenSave(){
		Customer customer1 = new Customer("Abby", "Anvil", "111111", "abbyanvil@gmail.com");
		customerRepository.save(customer1);
	}

	@Test
	public void createVenueThenSave(){
		Venue venue1 = new Venue("The Empty Venue");
		venueRepository.save(venue1);
	}

	@Test
	public void createVenueTableThenSave(){
		Venue venue1 = new Venue("The Empty Venue");
		venueRepository.save(venue1);
		VenueTable venueTable1 = new VenueTable(4, venue1);
		venueTableRepository.save(venueTable1);
	}

//	@Test
//	public void createReservationThenSave(){
//		Customer customer1 = new Customer("Abby", "Anvil", "111111", "abbyanvil@gmail.com");
//		Venue venue1 = new Venue("The Empty Venue");
//		VenueTable venueTable1 = new VenueTable(4, venue1);
//
//		Reservation reservation1 = new Reservation(customer1, venueTable1,
//				LocalDateTime.of(2020, Month.AUGUST, 31, 18, 30),
//				LocalDateTime.of(2020, Month.AUGUST, 31, 20, 30));
//		reservationRepository.save(reservation1);
//	}

}

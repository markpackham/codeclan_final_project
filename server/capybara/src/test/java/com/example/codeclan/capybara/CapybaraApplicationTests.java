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

import static org.junit.jupiter.api.Assertions.*;

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
	public void canGetCustomersVenuesVenueTablesAndReservations(){
		int foundCustomers = customerRepository.findAll().size();
		int foundVenues = venueRepository.findAll().size();
		int foundVenueTables = venueTableRepository.findAll().size();
		int foundReservations = reservationRepository.findAll().size();
		assertTrue(foundCustomers > 0);
		assertTrue( foundVenues > 0);
		assertTrue(foundVenueTables > 0);
		assertTrue(foundReservations > 0);
	}

	@Test
	public void canGetSpecificCustomersVenuesVenueTablesAndReservations(){
		assertNotNull(customerRepository.findById(1L));
		assertNotNull(venueRepository.findById(1L));
		assertNotNull(venueTableRepository.findById(1L));
		assertNotNull(reservationRepository.findById(1L));
	}

}

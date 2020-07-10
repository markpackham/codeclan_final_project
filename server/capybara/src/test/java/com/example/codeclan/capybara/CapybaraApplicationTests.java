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
	public void createVenueTableThenSave(){
		Venue venue1 = new Venue("The Empty Venue");
		venueRepository.save(venue1);
		VenueTable venueTable1 = new VenueTable(4, venue1);
		venueTableRepository.save(venueTable1);
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

	@Test
	public void canFindCovers(){
		List<VenueTable> foundVenueTable = venueTableRepository.findByCovers(4);
		assertNotNull(foundVenueTable);
	}

	@Test
	public void canFindCovers__ZeroFound(){
		List<VenueTable> foundVenueTable = venueTableRepository.findByCovers(400000000);
		assertEquals(0,foundVenueTable.size());
	}

	@Test
	public void canFindCoversGreaterThan(){
		List<VenueTable> foundVenueTable = venueTableRepository.findByCoversGreaterThan(1);
		assertNotNull(foundVenueTable);
	}

	@Test
	public void canFindCoversGreaterThan__ZeroFound(){
		List<VenueTable> foundVenueTable = venueTableRepository.findByCoversGreaterThan(10000000);
		assertEquals(0,foundVenueTable.size());
	}

	@Test
	public void canFindCoversLessThan(){
		List<VenueTable> foundVenueTable = venueTableRepository.findByCoversLessThan(10000000);
		assertNotNull(foundVenueTable);
	}

	@Test
	public void canFindCoversLessThan__ZeroFound(){
		List<VenueTable> foundVenueTable = venueTableRepository.findByCoversLessThan(1);
		assertEquals(0,foundVenueTable.size());
	}

	@Test
	public void canDeleteReservation(){
		int preDeleteSize = reservationRepository.findAll().size();
		reservationRepository.deleteById(1L);
		int postDeleteSize = reservationRepository.findAll().size();
		assertTrue(preDeleteSize > postDeleteSize);
	}

}

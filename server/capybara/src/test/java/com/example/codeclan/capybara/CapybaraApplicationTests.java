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
	public void canFindCustomerFirstAndLastName(){
		Customer customer999 = new Customer("RareFirstName", "RareLastName", "111111", "abbyanvil@gmail.com");
		customerRepository.save(customer999);
		List<Customer> foundCustomer = customerRepository.findByFirstNameAndLastName("RareFirstName", "RareLastName");
		assertEquals(1,foundCustomer.size());
	}

	@Test
	public void canFindCustomerLastName(){
		Customer customer999 = new Customer("Abby", "UniqueLastName", "111111", "abbyanvil@gmail.com");
		customerRepository.save(customer999);
		List<Customer> foundCustomer = customerRepository.findByLastName("UniqueLastName");
		assertEquals(1,foundCustomer.size());
	}

	@Test
	public void canFindCustomerEmail(){
		Customer customer12 = new Customer("FirstName12", "LastName12", "333333", "customer12@gmail.com");
		customerRepository.save(customer12);
		Customer foundCustomer = customerRepository.findByEmail("customer12@gmail.com");
		assertNotNull(foundCustomer);
	}

	@Test
	public void canFindCustomerPhone(){
		Customer customer13 = new Customer("FirstName13", "LastName13", "131313131313", "customer13@gmail.com");
		customerRepository.save(customer13);
		Customer foundCustomer = customerRepository.findByPhone("131313131313");
		assertNotNull(foundCustomer);
	}

	@Test
	public void canFindVenueName(){
		Venue venue100 = new Venue("The Super Unique Venue");
		venueRepository.save(venue100);
		Venue foundVenue = venueRepository.findByName("The Super Unique Venue");
		assertNotNull(foundVenue);
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

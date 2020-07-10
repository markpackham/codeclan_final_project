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
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
		List<Customer> foundCustomer = customerRepository.findByFirstNameAndLastName("Abby", "Anvil");
		assertEquals(1,foundCustomer.size());
	}

	@Test
	public void canFindCustomerLastName(){
		List<Customer> foundCustomer = customerRepository.findByLastName("Anvil");
		assertEquals(1,foundCustomer.size());
	}

	@Test
	public void canFindCustomerEmail(){
		Customer foundCustomer = customerRepository.findByEmail("abbyanvil@gmail.com");
		assertNotNull(foundCustomer);
	}

	@Test
	public void canFindCustomerPhone(){
		Customer foundCustomer = customerRepository.findByPhone("111111");
		assertNotNull(foundCustomer);
	}



}

package com.example.codeclan.capybara;

import com.example.codeclan.capybara.respositories.ICustomerRespository;
import com.example.codeclan.capybara.respositories.IReservationRepository;
import com.example.codeclan.capybara.respositories.IVenueRepository;
import com.example.codeclan.capybara.respositories.IVenueTableRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CapybaraApplicationTests {

	@Autowired
	ICustomerRespository customerRepository;
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
	public void placeholderTest(){
	assertEquals(1,1);
	}

}

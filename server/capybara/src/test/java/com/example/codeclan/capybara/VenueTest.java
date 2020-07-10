package com.example.codeclan.capybara;

import com.example.codeclan.capybara.models.Venue;
import com.example.codeclan.capybara.repositories.IVenueRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class VenueTest {
    @Autowired
    IVenueRepository venueRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void createVenueThenSave(){
        Venue venue1 = new Venue("The Empty Venue");
        venueRepository.save(venue1);
    }

    @Test
    public void canFindVenueName(){
        Venue venue100 = new Venue("The Super Unique Venue");
        venueRepository.save(venue100);
        Venue foundVenue = venueRepository.findByName("The Super Unique Venue");
        assertNotNull(foundVenue);
    }

    @Test
    public void canSetName(){
        Venue venue1 = new Venue("This Venue Has No Name");
        venue1.setName("Mega Venue");
        assertEquals("Mega Venue",venue1.getName());
    }
}

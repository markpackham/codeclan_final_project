package com.example.codeclan.capybara;

import com.example.codeclan.capybara.models.Venue;
import com.example.codeclan.capybara.repositories.IVenueRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
        Venue foundVenue = venueRepository.findByNameIgnoreCase("The Super Unique Venue");
        assertNotNull(foundVenue);
        Venue foundVenue2 = venueRepository.findByNameIgnoreCase("The super unique venuE");
        assertNotNull(foundVenue2);
    }

    @Test
    public void canFindVenueNotName(){
        Venue venue101 = new Venue("The Venue That Must Not Be");
        venueRepository.save(venue101);
        List<Venue> foundVenues = venueRepository.findAll();
        List<Venue> foundVenuesNoteApplied = venueRepository.findByNameIgnoreCaseNot("The Venue That Must Not Be");
        assertTrue(foundVenues.size() > foundVenuesNoteApplied.size());
    }

    @Test
    public void canFindVenueNameContaining(){
        Venue venue001 = new Venue("Venue 001");
        venueRepository.save(venue001);
        List<Venue> foundVenue = venueRepository.findByNameIgnoreCaseContaining("001");
        assertTrue(foundVenue.size()>0);
    }

    @Test
    public void canFindVenueNameNotContaining(){
        Venue venue0001 = new Venue("Venue 0001");
        venueRepository.save(venue0001);
        List<Venue> foundVenue = venueRepository.findByNameIgnoreCaseNotContaining("0001");
        assertTrue(foundVenue.size()>0);
    }

    @Test
    public void canSetName(){
        Venue venue1 = new Venue("This Venue Has No Name");
        venue1.setName("Mega Venue");
        assertEquals("Mega Venue",venue1.getName());
    }

    @Test
    public void checkVenueTableStartsOffEmpty(){
        Venue venue1 = new Venue("This Venue Has No Name");
        assertEquals(0, venue1.getVenueTables().size());
    }
}

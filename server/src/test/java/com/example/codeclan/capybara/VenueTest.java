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
    public void canCreateVenueThenSave(){
        Venue venue1029 = new Venue("venue1029");
        venueRepository.save(venue1029);
        assertTrue(venueRepository.findAll().size()>0);
    }

    @Test
    public void canFindVenueName(){
        Venue venue1030 = new Venue("The Super Unique Venue");
        venueRepository.save(venue1030);
        Venue foundVenue = venueRepository.findByNameIgnoreCase("The Super Unique Venue");
        assertNotNull(foundVenue);
        Venue foundVenue2 = venueRepository.findByNameIgnoreCase("The super unique venuE");
        assertNotNull(foundVenue2);
    }

    @Test
    public void canFindVenueNotName(){
        Venue venue1031 = new Venue("The Venue That Must Not Be");
        venueRepository.save(venue1031);
        List<Venue> foundVenues = venueRepository.findAll();
        List<Venue> foundVenuesNoteApplied = venueRepository.findByNameIgnoreCaseNot("The Venue That Must Not Be");
        assertTrue(foundVenues.size() > foundVenuesNoteApplied.size());
    }

    @Test
    public void canFindVenueNameContaining(){
        Venue venue1032 = new Venue("Venue 1032");
        venueRepository.save(venue1032);
        List<Venue> foundVenue = venueRepository.findByNameIgnoreCaseContaining("1032");
        assertTrue(foundVenue.size()>0);
    }

    @Test
    public void canFindVenueNameNotContaining(){
        Venue venue1033 = new Venue("Venue 1033");
        venueRepository.save(venue1033);
        List<Venue> foundVenues = venueRepository.findByNameIgnoreCaseNotContaining("1033");
        assertTrue(foundVenues.size()>0);
    }

    @Test
    public void canSetName(){
        Venue venue1034 = new Venue("This Venue Has No Name");
        venue1034.setName("Mega Venue");
        assertEquals("Mega Venue",venue1034.getName());
    }

    @Test
    public void checkVenueTableStartsOffEmpty(){
        Venue venue1035 = new Venue("venue1035");
        assertEquals(0, venue1035.getVenueTables().size());
    }

    @Test
    public void canGetVenuesWithNoTables(){
        Venue venue1036 = new Venue("venue1036 Has No Tables");
        venueRepository.save(venue1036);
        List<Venue> foundVenues = venueRepository.findByVenueTablesIsNull();
        assertTrue(foundVenues.size() > 0);
    }

    @Test
    public void canGetVenuesFromDatabase(){
        int foundVenues = venueRepository.findAll().size();
        assertTrue( foundVenues > 0);
    }
}

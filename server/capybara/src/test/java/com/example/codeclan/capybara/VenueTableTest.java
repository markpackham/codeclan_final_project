package com.example.codeclan.capybara;

import com.example.codeclan.capybara.models.Venue;
import com.example.codeclan.capybara.models.VenueTable;
import com.example.codeclan.capybara.repositories.IVenueRepository;
import com.example.codeclan.capybara.repositories.IVenueTableRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VenueTableTest {

    @Autowired
    IVenueTableRepository venueTableRepository;
    @Autowired
    IVenueRepository venueRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void createVenueTableThenSave(){
        Venue venue1 = new Venue("The Empty Venue");
        venueRepository.save(venue1);
        VenueTable venueTable1 = new VenueTable(4, venue1);
        venueTableRepository.save(venueTable1);
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
    public void canSetAndVenueCovers(){
        VenueTable venueTable1 = new VenueTable(10,null);
        venueTable1.setCovers(22);
        assertEquals(22,venueTable1.getCovers());
        assertNull(venueTable1.getVenue());
        Venue venue1 = new Venue("The Empty Venue");
        venueTable1.setVenue(venue1);
        assertEquals(venue1,venueTable1.getVenue());
    }
}

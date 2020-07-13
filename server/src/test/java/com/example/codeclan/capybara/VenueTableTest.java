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
    public void canCreateVenueTableThenSave(){
        Venue venue1027 = new Venue("venue1027");
        venueRepository.save(venue1027);
        VenueTable venueTable1027 = new VenueTable(4, venue1027);
        venueTableRepository.save(venueTable1027);
        assertTrue(venueTableRepository.findAll().size()>0);
    }

    @Test
    public void canFindCovers(){
        List<VenueTable> foundVenueTables = venueTableRepository.findByCovers(4);
        assertNotNull(foundVenueTables);
    }

    @Test
    public void canFindCovers__ZeroFound(){
        List<VenueTable> foundVenueTables = venueTableRepository.findByCovers(90000);
        assertEquals(0,foundVenueTables.size());
    }

    @Test
    public void canFindCoversGreaterThan(){
        List<VenueTable> foundVenueTables = venueTableRepository.findByCoversGreaterThan(1);
        assertNotNull(foundVenueTables);
    }

    @Test
    public void canFindCoversGreaterThan__ZeroFound(){
        List<VenueTable> foundVenueTables = venueTableRepository.findByCoversGreaterThan(90000);
        assertEquals(0,foundVenueTables.size());
    }

    @Test
    public void canFindCoversLessThan(){
        List<VenueTable> foundVenueTables = venueTableRepository.findByCoversLessThan(90000);
        assertNotNull(foundVenueTables);
    }

    @Test
    public void canFindCoversLessThan__ZeroFound(){
        List<VenueTable> foundVenueTables = venueTableRepository.findByCoversLessThan(1);
        assertEquals(0,foundVenueTables.size());
    }

    @Test
    public void canSetAndVenueCovers(){
        VenueTable venueTable1028 = new VenueTable(10,null);
        venueTable1028.setCovers(22);
        assertEquals(22,venueTable1028.getCovers());
        assertNull(venueTable1028.getVenue());
        Venue venue1028 = new Venue("venue1028");
        venueTable1028.setVenue(venue1028);
        assertEquals(venue1028,venueTable1028.getVenue());
    }

    @Test
    public void canGetVenueTablesFromDatabase(){
        int foundVenueTables = venueTableRepository.findAll().size();
        assertTrue(foundVenueTables > 0);
    }

    @Test
    public void canGetSpecificVenueTableFromDatabase(){
        assertNotNull(venueTableRepository.findById(1L));
    }
}

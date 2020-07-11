package com.example.codeclan.capybara.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "venue_tables")
public class VenueTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cover")
    private int covers;

    @JsonIgnoreProperties({"venueTables"})
    @ManyToOne
    @JoinColumn(name = "venue_id", nullable = false)
    private Venue venue;

    @JsonIgnoreProperties({"venueTable"})
    @OneToMany(mappedBy = "venueTable", fetch = FetchType.LAZY)
    private List<Reservation> reservations;

    public VenueTable(int covers, Venue venue) {
        this.covers = covers;
        this.venue = venue;
    }

    public VenueTable() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCovers() {
        return covers;
    }

    public void setCovers(int covers) {
        this.covers = covers;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

}

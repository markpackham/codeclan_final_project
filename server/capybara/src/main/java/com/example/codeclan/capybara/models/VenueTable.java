package com.example.codeclan.capybara.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "venue_tables")
public class VenueTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="cover")
    private int cover;

    @JsonIgnoreProperties({"venue_table"})
    @ManyToOne
    @JoinColumn(name = "venue_id", nullable = false)
    private Venue venue;

    public VenueTable(int cover) {
        this.cover = cover;
    }

    public VenueTable(Venue venue) {
        this.venue = venue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCover() {
        return cover;
    }

    public void setCover(int cover) {
        this.cover = cover;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }
}

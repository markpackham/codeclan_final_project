package com.example.codeclan.capybara.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnoreProperties
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @JsonIgnoreProperties
    @ManyToOne
    @JoinColumn(name = "venue_table_id", nullable = false)
    private VenueTable venueTable;

    @Column(name = "start")
    private LocalDateTime start;

    @Column(name = "end")
    private LocalDateTime end;

    public Reservation(Customer customer, VenueTable venueTable, LocalDateTime start, LocalDateTime end) {
        this.customer = customer;
        this.venueTable = venueTable;
        this.start = start;
        this.end = end;
    }

    public Reservation() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public VenueTable getVenueTable() {
        return venueTable;
    }

    public void setVenueTable(VenueTable venueTable) {
        this.venueTable = venueTable;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

}

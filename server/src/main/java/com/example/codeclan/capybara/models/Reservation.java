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

    @JsonIgnoreProperties({"reservations"})
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @JsonIgnoreProperties({"reservations"})
    @ManyToOne
    @JoinColumn(name = "venue_table_id", nullable = false)
    private VenueTable venueTable;

    @Column(name = "start")
    private LocalDateTime start;

    @Column(name = "end")
    private LocalDateTime end;

    @Column(name = "partySize")
    private int partySize;

    @Column(name = "reservationNotes")
    private String reservationNotes;

    public Reservation(Customer customer, VenueTable venueTable, LocalDateTime start, LocalDateTime end, int partySize, String reservationNotes) {
        this.customer = customer;
        this.venueTable = venueTable;
        this.start = start;
        this.end = end;
        this.partySize = partySize;
        this.reservationNotes = reservationNotes;
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

    public int getPartySize() {
        return partySize;
    }

    public void setPartySize(int partySize) {
        this.partySize = partySize;
    }

    public String getReservationNotes() {
        return reservationNotes;
    }

    public void setReservationNotes(String reservationNotes) {
        this.reservationNotes = reservationNotes;
    }
}

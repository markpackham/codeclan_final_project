package com.example.codeclan.capybara.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="venues")
public class Venue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @JsonIgnoreProperties({"venue"})
    @OneToMany(mappedBy = "venue", fetch = FetchType.LAZY)
    private List<VenueTable> venueTables;

    public Venue(String name) {
        this.name = name;
        this.venueTables = new ArrayList<>();
    }

    public Venue() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<VenueTable> getVenueTables() {
        return venueTables;
    }

    public void setVenueTables(List<VenueTable> venueTables) {
        this.venueTables = venueTables;
    }

}

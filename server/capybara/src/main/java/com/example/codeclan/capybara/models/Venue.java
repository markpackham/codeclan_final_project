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
    @Column(name="name")
    private String name;

    @JsonIgnoreProperties({"venue"})
    @OneToMany(mappedBy = "venue")
    private List venueTables;


    public Venue(String name, List venueTables) {
        this.name = name;
        this.venueTables = venueTables;
    }

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

    public ArrayList getVenueTables() {
        return venueTables;
    }

    public void setVenueTables(ArrayList venueTables) {
        this.venueTables = venueTables;
    }
}

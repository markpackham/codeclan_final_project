package com.example.codeclan.capybara.models;

import javax.persistence.Entity;
import java.util.ArrayList;

@Entity
public class Venue {
    private Long id;
    private String name;
    private ArrayList venueTables;

    public Venue(String name, ArrayList venueTables) {
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

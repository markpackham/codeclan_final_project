package com.example.codeclan.capybara.models;

import javax.persistence.Entity;

@Entity
public class VenueTable {
    private Long id;
    private int cover;

    public VenueTable(int cover) {
        this.cover = cover;
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
}

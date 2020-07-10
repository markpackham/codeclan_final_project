package com.example.codeclan.capybara.repositories;

import com.example.codeclan.capybara.models.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVenueRepository extends JpaRepository<Venue, Long> {
    Venue findByName(String name);
}
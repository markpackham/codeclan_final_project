package com.example.codeclan.capybara.respositories;

import com.example.codeclan.capybara.models.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVenueRepository extends JpaRepository<Venue, Long> {
}
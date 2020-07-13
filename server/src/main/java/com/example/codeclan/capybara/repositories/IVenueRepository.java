package com.example.codeclan.capybara.repositories;

import com.example.codeclan.capybara.models.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVenueRepository extends JpaRepository<Venue, Long> {
    Venue findByNameIgnoreCase(String name);

    List<Venue> findByNameIgnoreCaseContaining(String nameContaining);

    List<Venue> findByNameIgnoreCaseNot(String notName);

    List<Venue> findByNameIgnoreCaseNotContaining(String nameNotContaining);

    List<Venue> findByVenueTablesIsNull();

    List<Venue> findAllByOrderByIdDesc();

    List<Venue> findByOrderByNameAsc();

    List<Venue> findByOrderByNameDesc();
}
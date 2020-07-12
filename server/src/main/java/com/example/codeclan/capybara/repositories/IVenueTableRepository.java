package com.example.codeclan.capybara.repositories;

import com.example.codeclan.capybara.models.VenueTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVenueTableRepository extends JpaRepository<VenueTable, Long> {
    List<VenueTable> findByCovers(Integer covers);

    List<VenueTable> findByCoversGreaterThan(Integer covers);

    List<VenueTable> findByCoversLessThan(Integer covers);

    List<VenueTable> findByVenueId(Long id);

    List<VenueTable> findAllByOrderByCoversAsc();

    List<VenueTable> findAllByOrderByCoversDesc();
}

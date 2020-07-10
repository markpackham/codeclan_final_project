package com.example.codeclan.capybara.respositories;

import com.example.codeclan.capybara.models.VenueTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVenueTableRepository extends JpaRepository<VenueTable, Long> {
}

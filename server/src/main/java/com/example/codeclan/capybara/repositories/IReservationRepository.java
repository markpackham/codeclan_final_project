package com.example.codeclan.capybara.repositories;

import com.example.codeclan.capybara.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IReservationRepository extends JpaRepository<Reservation, Long>{
    List<Reservation> findByStartLessThan(LocalDateTime startBefore);

    List<Reservation> findByStartGreaterThan(LocalDateTime startAfter);

    List<Reservation> findByStartLessThanAndStartGreaterThan(LocalDateTime startBefore, LocalDateTime startAfter);

    List<Reservation> findAllByOrderByVenueTableCoversAsc();

    List<Reservation> findAllByOrderByVenueTableCoversDesc();
}

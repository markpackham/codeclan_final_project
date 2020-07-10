package com.example.codeclan.capybara.repositories;

import com.example.codeclan.capybara.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReservationRepository extends JpaRepository<Reservation, Long>{
}

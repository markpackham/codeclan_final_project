package com.example.codeclan.capybara.repositories;

import com.example.codeclan.capybara.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByEmail(String email);

    Customer findByPhone(String phone);

    Customer findByFirstNameAndLastName(String firstName, String lastName);

    List<Customer> findByLastName(String lastName);
}

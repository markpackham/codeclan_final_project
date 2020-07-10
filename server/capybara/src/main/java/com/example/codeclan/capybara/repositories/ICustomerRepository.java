package com.example.codeclan.capybara.repositories;

import com.example.codeclan.capybara.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByEmail(String email);

    Customer findByPhone(String phone);

    Customer findByFirstNameAndLastName(String firstName, String lastName);

    Customer findByLastName(String lastName);
}

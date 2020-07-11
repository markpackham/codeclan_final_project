package com.example.codeclan.capybara.repositories;

import com.example.codeclan.capybara.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByEmailIgnoreCase(String email);

    Customer findByPhone(String phone);

    List<Customer> findByFirstNameIgnoreCaseAndLastNameIgnoreCase(String firstName, String lastName);

    List<Customer> findByLastNameIgnoreCase(String lastName);

    List<Customer> findByLastNameIgnoreCaseStartingWith(String lastNameStartsWith);

    List<Customer> findByEmailIgnoreCaseStartingWith(String emailStartsWith);

    List<Customer> findByPhoneContaining(String phoneContaining);

    List<Customer> findByLastNameIgnoreCaseNotContaining(String lastNameNotContaining);
}

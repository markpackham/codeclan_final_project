package com.example.codeclan.capybara.respositories;

import com.example.codeclan.capybara.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRespository extends JpaRepository<Customer, Long> {
    Customer findByEmail(String email);

    Customer findByPhone(String phone);
}

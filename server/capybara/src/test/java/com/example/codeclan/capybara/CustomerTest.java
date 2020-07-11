package com.example.codeclan.capybara;

import com.example.codeclan.capybara.models.Customer;
import com.example.codeclan.capybara.repositories.ICustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CustomerTest {
    @Autowired
    ICustomerRepository customerRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void createCustomerThenSave(){
        Customer customer1 = new Customer("Abby", "Anvil", "111111", "abbyanvil@gmail.com");
        customerRepository.save(customer1);
    }

    @Test
    public void canFindCustomerFirstAndLastName(){
        Customer customer999 = new Customer("RareFirstName", "RareLastName", "111111", "abbyanvil@gmail.com");
        customerRepository.save(customer999);
        List<Customer> foundCustomer = customerRepository.findByFirstNameIgnoreCaseAndLastNameIgnoreCase("RareFirstName", "RareLastName");
        assertEquals(1,foundCustomer.size());
        List<Customer> foundCustomer2 = customerRepository.findByFirstNameIgnoreCaseAndLastNameIgnoreCase("rareFirstName", "Rarelastname");
        assertEquals(1,foundCustomer2.size());
    }

    @Test
    public void canFindCustomerLastName(){
        Customer customer999 = new Customer("Abby", "UniqueLastName", "111111", "abbyanvil@gmail.com");
        customerRepository.save(customer999);
        List<Customer> foundCustomer = customerRepository.findByLastNameIgnoreCase("UniqueLastName");
        assertEquals(1,foundCustomer.size());
        List<Customer> foundCustomer2 = customerRepository.findByLastNameIgnoreCase("uniqueLastName");
        assertEquals(1,foundCustomer2.size());
    }

    @Test
    public void canFindCustomerEmail(){
        Customer customer12 = new Customer("FirstName12", "LastName12", "333333", "customer12@gmail.com");
        customerRepository.save(customer12);
        Customer foundCustomer = customerRepository.findByEmailIgnoreCase("customer12@gmail.com");
        assertNotNull(foundCustomer);
        Customer foundCustomer2 = customerRepository.findByEmailIgnoreCase("cusTOMER12@gmail.COM");
        assertNotNull(foundCustomer2);
    }

    @Test
    public void canFindCustomerPhone(){
        Customer customer13 = new Customer("FirstName13", "LastName13", "131313131313", "customer13@gmail.com");
        customerRepository.save(customer13);
        Customer foundCustomer = customerRepository.findByPhone("131313131313");
        assertNotNull(foundCustomer);
    }

    @Test
    public void canSetFirstNameLastNamePhoneEmail(){
        Customer customer1 = new Customer("ChangeFirstName", "ChangeLastName", "999999999","changeme@gmail.com");
        customer1.setFirstName("Albert");
        assertEquals("Albert", customer1.getFirstName());
        customer1.setLastName("Billington");
        assertEquals("Billington",customer1.getLastName());
        customer1.setPhone("000000000");
        assertEquals("000000000",customer1.getPhone());
        customer1.setEmail("yahoo@yahoo.com");
        assertEquals("yahoo@yahoo.com",customer1.getEmail());
    }

    @Test
    public void checkReservationsStartEmpty(){
        Customer customer1 = new Customer("ChangeFirstName", "ChangeLastName", "999999999","changeme@gmail.com");
        assertEquals(0,customer1.getReservations().size());
    }
}

package com.example.codeclan.capybara;
import com.example.codeclan.capybara.models.Customer;
import com.example.codeclan.capybara.repositories.ICustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerTest {
    @Autowired
    ICustomerRepository customerRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void canFindCustomerFirstNameContaining(){
        Customer customer998 = new Customer("customer998FN", "customer998LN", "998", "customer998@gmail.com");
        customerRepository.save(customer998);
        List<Customer> foundCustomers = customerRepository.findByFirstNameContainingIgnoreCase("998FN");
        assertEquals(1,foundCustomers.size());
    }

    @Test
    public void canFindCustomerFirstName(){
        Customer customer999 = new Customer("customer999FN", "customer999LN", "999", "customer999@gmail.com");
        customerRepository.save(customer999);
        List<Customer> foundCustomers = customerRepository.findByFirstNameIgnoreCase("customer999FN");
        assertEquals(1,foundCustomers.size());
    }

    @Test
    public void createCustomerThenSave(){
        Customer customer1000 = new Customer("customer1000FN", "customer1000LN", "1000", "customer1000@gmail.com");
        customerRepository.save(customer1000);
    }

    @Test
    public void canFindCustomerFirstAndLastName(){
        Customer customer1001 = new Customer("RareFirstName", "RareLastName", "1001", "customer1001@gmail.com");
        customerRepository.save(customer1001);
        List<Customer> foundCustomers = customerRepository.findByFirstNameIgnoreCaseAndLastNameIgnoreCase("RareFirstName", "RareLastName");
        assertEquals(1,foundCustomers.size());
        List<Customer> foundCustomers2 = customerRepository.findByFirstNameIgnoreCaseAndLastNameIgnoreCase("rareFirstName", "Rarelastname");
        assertEquals(1,foundCustomers2.size());
    }

    @Test
    public void canFindCustomerLastName(){
        Customer customer1002 = new Customer("customer1002FN", "UniqueLastName", "1002", "customer1002@gmail.com");
        customerRepository.save(customer1002);
        List<Customer> foundCustomers = customerRepository.findByLastNameIgnoreCase("UniqueLastName");
        assertEquals(1,foundCustomers.size());
        List<Customer> foundCustomers2 = customerRepository.findByLastNameIgnoreCase("uniqueLastName");
        assertEquals(1,foundCustomers2.size());
    }

    @Test
    public void canFindCustomersContainingLastName(){
        Customer customer1003 = new Customer("customer1003FN", "ZZZZZ", "1003", "customer1003@gmail.com");
        customerRepository.save(customer1003);
        List<Customer> foundCustomers = customerRepository.findByLastNameIgnoreCaseNotContaining("ZZZ");
        assertTrue(foundCustomers.size() > 1);
    }

    @Test
    public void canFindCustomersNotContainingLastName(){
        Customer customer1004 = new Customer("customer1004FN", "XXXXX", "1004", "customer1004@gmail.com");
        customerRepository.save(customer1004);
        List<Customer> foundCustomers = customerRepository.findByLastNameIgnoreCaseNotContaining("XXXXX");
        assertTrue(customerRepository.findAll().size()> foundCustomers.size());
    }

    @Test
    public void canFindCustomerLastNameStartingWith(){
        Customer customer1005 = new Customer("customer1005FN", "ZZUniqueLastName", "1005", "customer1005@gmail.com");
        customerRepository.save(customer1005);
        List<Customer> foundCustomers = customerRepository.findByLastNameIgnoreCaseStartingWith("ZZUn");
        assertEquals(1,foundCustomers.size());
    }

    @Test
    public void canFindCustomerEmail(){
        Customer customer1006 = new Customer("customer1006FN", "customer1006LN", "1006", "customer1006@gmail.com");
        customerRepository.save(customer1006);
        Customer foundCustomer = customerRepository.findByEmailIgnoreCase("customer1006@gmail.com");
        assertNotNull(foundCustomer);
        Customer foundCustomer2 = customerRepository.findByEmailIgnoreCase("cUSTOMER1006@gmail.COM");
        assertNotNull(foundCustomer2);
    }

    @Test
    public void canFindCustomerEmailStartsWith(){
        Customer customer1007 = new Customer("customer1007FN", "customer1007LN", "1007", "customer1007@gmail.com");
        customerRepository.save(customer1007);
        List<Customer> foundCustomers = customerRepository.findByEmailIgnoreCaseStartingWith("customer1007@gm");
        assertTrue(foundCustomers.size()>0);
    }

    @Test
    public void canFindCustomerEmailContaining(){
        Customer customer1008 = new Customer("customer1008FN", "customer1008LN", "1008", "customer1008@gmail.com");
        customerRepository.save(customer1008);
        List<Customer> foundCustomers = customerRepository.findByEmailIgnoreCaseContaining("@gmail");
        assertTrue(foundCustomers.size()>0);
    }

    @Test
    public void canFindCustomerPhone(){
        Customer customer1009 = new Customer("customer1009FN", "customer1009LN", "131313131313", "customer1009@gmail.com");
        customerRepository.save(customer1009);
        Customer foundCustomer = customerRepository.findByPhone("131313131313");
        assertNotNull(foundCustomer);
    }

    @Test
    public void canFindCustomerPhoneContaining(){
        Customer customer1010 = new Customer("customer1010FN", "customer1010LN", "1131313131313", "customer1010@gmail.com");
        customerRepository.save(customer1010);
        List<Customer> foundCustomers = customerRepository.findByPhoneContaining("3131");
        assertTrue(foundCustomers.size() > 0);
    }

    @Test
    public void canSetFirstNameLastNamePhoneEmail(){
        Customer customer1011 = new Customer("ChangeFirstName", "ChangeLastName", "999999999","changeme@gmail.com");
        customer1011.setFirstName("customer1011FN");
        assertEquals("customer1011FN", customer1011.getFirstName());
        customer1011.setLastName("customer1011LN");
        assertEquals("customer1011LN",customer1011.getLastName());
        customer1011.setPhone("1011");
        assertEquals("1011",customer1011.getPhone());
        customer1011.setEmail("1011@yahoo.com");
        assertEquals("1011@yahoo.com",customer1011.getEmail());
    }

    @Test
    public void checkReservationsStartEmpty(){
        Customer customer1012 = new Customer("customer1012FN", "customer1012LN", "1012","customer1012@gmail.com");
        assertEquals(0,customer1012.getReservations().size());
    }
}

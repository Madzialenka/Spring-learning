package com.example.demo.customers;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    Customer createCustomer(CustomerDTO customerDTO);

    Customer updateCustomer(Long id, CustomerDTO customerDTO);

    void deleteCustomer(Long id);

    void updateAddress(Long id, Address address);
}

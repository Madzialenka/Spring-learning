package com.example.demo.customers;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private List<Customer> customers = new ArrayList<>();

    @Override
    public List<Customer> getCustomers() {
        return customers;
    }

    @Override
    public Customer createCustomer(CustomerDTO customerDTO) {
        Long id = customers.stream()
                .map(Customer::getId)
                .max(Long::compareTo)
                .orElse(0L) + 1;
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(customerDTO.getName());
        customer.setSurname(customerDTO.getSurname());
        customer.setAddress(customerDTO.getAddress());
        customer.setAge(customerDTO.getAge());
        customer.setGender(customerDTO.getGender());
        customers.add(customer);
        return customer;
    }

    @Override
    public Customer updateCustomer(Long id, CustomerDTO customerDTO) {
        Customer customer = getCustomer(id);
        if (customer != null) {
            customer.setName(customerDTO.getName());
            customer.setSurname(customerDTO.getSurname());
            customer.setAddress(customerDTO.getAddress());
            customer.setAge(customerDTO.getAge());
            customer.setGender(customerDTO.getGender());
        }
        return customer;
    }

    @Override
    public void deleteCustomer(Long id) {
        customers.removeIf(customer -> customer.getId().equals(id));
    }

    @Override
    public void updateAddress(Long id, Address address) {
        Customer customer = getCustomer(id);
        if (customer != null) {
            customer.setAddress(address);
        }
    }

    private Customer getCustomer(Long id) {
        return customers.stream()
                .filter(existingCustomer -> existingCustomer.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}

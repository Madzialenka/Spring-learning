package com.example.demo.customers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("customers")
@RestController
public class CustomerController {

    private CustomerService customerService;
    private String myProperty;

    public CustomerController(CustomerService customerService, @Value("${app.my-property}") String myProperty) {
        this.customerService = customerService;
        this.myProperty = myProperty;
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @PostMapping
    public Customer createCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.createCustomer(customerDTO);
    }

    @PutMapping("{id}")
    public Customer updateCustomer(@PathVariable("id") Long id, @RequestBody CustomerDTO customerDTO) {
        return customerService.updateCustomer(id, customerDTO);
    }

    @DeleteMapping("{id}")
    public void deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteCustomer(id);
    }

    @PutMapping("{id}/address")
    public void updateAddress(@PathVariable("id") Long id, @RequestBody Address address) {
        customerService.updateAddress(id, address);
    }

    @RequestMapping(method = RequestMethod.GET, value = "property")       // zamiast GetMapping - w GetMapping jest
                                                                          // adnotacja RequestMapping z metodą
    public String getMyProperty(@RequestParam(value = "param", required = false, defaultValue = "") List<String> params) {
        return myProperty + " - " + params;
    }

    @GetMapping("params")
    public MyRequestParams getRequestParams(MyRequestParams myRequestParams) {
        return myRequestParams;
    }
}

package com.maveric.thinknxt.customermgt.service;

import com.maveric.thinknxt.customermgt.entity.Customer;
import com.maveric.thinknxt.customermgt.exception.ResourceNotFoundException;
import com.maveric.thinknxt.customermgt.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomer(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(()-> new ResourceNotFoundException("Customer not exists"));
    }

    public Customer updateCustomer(Long customerId, Customer customer) {
        Customer editCustomer = customerRepository.findById(customerId)
                .orElseThrow(()-> new ResourceNotFoundException("Customer not exists"));
        editCustomer.setEmail(customer.getEmail());
        editCustomer.setPhone(customer.getPhone());
        editCustomer.setName(customer.getName());
        return customerRepository.save(editCustomer);
    }

    public void removeCustomer(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(()-> new ResourceNotFoundException("Customer not exists"));
        customerRepository.delete(customer);
    }
}

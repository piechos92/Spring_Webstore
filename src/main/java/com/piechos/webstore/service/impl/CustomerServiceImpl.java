package com.piechos.webstore.service.impl;

import com.piechos.webstore.domain.Customer;
import com.piechos.webstore.domain.repository.CustomerRepository;
import com.piechos.webstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.saveCustomer(customer);
    }

    @Override
    public Customer getCustomer(String customerId) {
        return customerRepository.getCustomer(customerId);
    }

    @Override
    public Boolean isCustomerExist(String customerId) {
        return customerRepository.isCustomerExist(customerId);
    }

}

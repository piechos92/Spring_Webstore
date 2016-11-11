package com.piechos.webstore.domain.repository.impl;

import com.piechos.webstore.domain.Customer;
import com.piechos.webstore.domain.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

    private List<Customer> listOfCustomers = new ArrayList<>();

    public InMemoryCustomerRepository() {
        Customer customer1 = new Customer("1", "Mateusz Piechowiak");
        listOfCustomers.add(customer1);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return listOfCustomers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        listOfCustomers.add(customer);
    }

    @Override
    public Customer getCustomer(String customerId) {
        for(Customer customer : listOfCustomers) {
            if(customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public Boolean isCustomerExist(String customerId) {
        return this.getCustomer(customerId) != null;
    }

}

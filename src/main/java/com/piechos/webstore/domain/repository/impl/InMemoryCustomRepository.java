package com.piechos.webstore.domain.repository.impl;

import com.piechos.webstore.domain.Customer;
import com.piechos.webstore.domain.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryCustomRepository implements CustomerRepository {

    private List<Customer> listOfCustomers = new ArrayList<>();

    public InMemoryCustomRepository() {
        Customer customer1 = new Customer("1", "Mateusz Piechowiak");
        listOfCustomers.add(customer1);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return listOfCustomers;
    }
}

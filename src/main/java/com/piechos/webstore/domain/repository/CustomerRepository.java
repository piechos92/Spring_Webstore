package com.piechos.webstore.domain.repository;

import com.piechos.webstore.domain.Customer;

import java.util.List;

public interface CustomerRepository {

    List<Customer> getAllCustomers();
}

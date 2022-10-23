package com.saurabh.project.service;

import com.saurabh.project.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    Customer findById(Integer id);

    void save(Customer customer);

    void delete(Integer id);

}

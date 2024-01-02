package com.codegym.service;

import com.codegym.model.Customer;
import com.codegym.repository.CustomerRepository;
import com.codegym.repository.ICustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService{

    private ICustomerRepository customerRepository = new CustomerRepository();

    @Override
    public boolean saveWithStoreProcedure(Customer customer) {
        return customerRepository.saveWithStoreProcedure(customer);
    }
}

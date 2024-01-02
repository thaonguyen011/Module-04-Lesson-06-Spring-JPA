package com.codegym.service;

import com.codegym.model.Customer;

public interface ICustomerService {
    boolean saveWithStoreProcedure(Customer customer);

}

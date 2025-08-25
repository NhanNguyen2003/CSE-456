package vn.edu.eiu.repo;

import vn.edu.eiu.entity.Customer;

public interface CustomerRepo {
    void saveCustomer(Customer customer);
    Customer findCustomerById(int id);
}


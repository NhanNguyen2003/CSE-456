package vn.edu.eiu.service;

import vn.edu.eiu.entity.Customer;
import vn.edu.eiu.repo.CustomerRepo;

public class CustomerService {
    private CustomerRepo customerRepository;

    public void saveCustomer(Customer customer) {
        customerRepository.saveCustomer(customer);
    }

    public Customer getCustomer(int id) {
        return customerRepository.findCustomerById(id);
    }
}


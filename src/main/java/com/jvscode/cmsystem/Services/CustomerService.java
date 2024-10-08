package com.jvscode.cmsystem.Services;

import com.jvscode.cmsystem.Entities.Customer;
import com.jvscode.cmsystem.Exceptions.CustumerNotFoundException;
import com.jvscode.cmsystem.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("customerService")
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
       return customerRepository.findAll();

    }

    public Customer getCustomer(Long theId) {
       return customerRepository.findById(theId)
                .orElseThrow(() ->
                        new CustumerNotFoundException("The required customer not found"));

    }



    public void deleteCustomer(Long theId) {
        if (customerRepository.existsById(theId)) {
            customerRepository.deleteById(theId);
        } else {
            throw new CustumerNotFoundException("The required customer not found");
        }
    }

    public Customer addCustomer(Customer customer) {
        Optional<Customer> existingCustomer = customerRepository.findById(customer.getId());

        if (existingCustomer.isPresent()) {
            return customerRepository.save(customer);
        } else {
            throw new CustumerNotFoundException("Customer with ID " + customer.getId() + " not found");
        }
    }


}

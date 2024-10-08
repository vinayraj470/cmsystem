package com.jvscode.cmsystem.Controllers;


import com.jvscode.cmsystem.Entities.Customer;
import com.jvscode.cmsystem.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;


    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers(){
        List<Customer> allCustomers = customerService.getAllCustomers();
        return new ResponseEntity<>(allCustomers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long theId) {
        Customer theCustomer = customerService.getCustomer(theId);
        return new ResponseEntity<>(theCustomer, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        Customer theCustomer = customerService.addCustomer(customer);
        return new ResponseEntity<>(theCustomer, HttpStatus.OK);
    }


    @DeleteMapping("/(/id)")
    public void deleteCustomer(@PathVariable("id") Long theId){
        customerService.deleteCustomer(theId);
    }




}

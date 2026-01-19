package com.example.ElectricityBillSystem.Controller;

import com.example.ElectricityBillSystem.Model.Customer;
import com.example.ElectricityBillSystem.Repository.CustomerRepository;
import com.example.ElectricityBillSystem.Exception.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;


    @PostMapping
    public Customer addCustomer(@Valid @RequestBody Customer customer){
        return customerRepository.save(customer);
    }

    @GetMapping
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id){
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id, @Valid @RequestBody Customer customerDetails){
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));

        customer.setName(customerDetails.getName());
        customer.setEmail(customerDetails.getEmail());
        customer.setPhone(customerDetails.getPhone());

        return customerRepository.save(customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id){
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));

        customerRepository.delete(customer);
        return ResponseEntity.ok("Customer deleted successfully");
    }
}

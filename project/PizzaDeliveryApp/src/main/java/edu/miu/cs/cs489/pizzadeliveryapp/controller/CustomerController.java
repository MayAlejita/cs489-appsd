package edu.miu.cs.cs489.pizzadeliveryapp.controller;

import edu.miu.cs.cs489.pizzadeliveryapp.dto.request.CustomerRequest;
import edu.miu.cs.cs489.pizzadeliveryapp.dto.response.CustomerResponse;
import edu.miu.cs.cs489.pizzadeliveryapp.exception.CustomerNotFoundException;
import edu.miu.cs.cs489.pizzadeliveryapp.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizzamgm/api/v1/customers")
public class CustomerController {

    private CustomerService customerService;
    public CustomerController(CustomerService customerService) {this.customerService = customerService;}

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> listCustomers(){
        return ResponseEntity.ok(customerService.getAllCustomer());
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable("customerId") Integer customerId) throws CustomerNotFoundException {
        return ResponseEntity.ok(customerService.getCustomerById(customerId));
    }

    @PostMapping("/new")
    public ResponseEntity<CustomerResponse> addNewCustomer(@RequestBody @Valid CustomerRequest customerRequest){
        return new ResponseEntity<>(customerService.addCustomer(customerRequest), HttpStatus.CREATED);
    }

    @PutMapping("/update/{customerId}")
    public ResponseEntity<CustomerResponse> updateCustomerById(@PathVariable Integer customerId, @RequestBody @Valid CustomerRequest customerRequest) throws CustomerNotFoundException {
        return new ResponseEntity<>(customerService.updateCustomerById(customerId, customerRequest), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{customerId}")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable Integer customerId){
        customerService.deleteCustomerById(customerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

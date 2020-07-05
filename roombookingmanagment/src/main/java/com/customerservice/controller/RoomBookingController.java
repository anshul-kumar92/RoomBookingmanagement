package com.customerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.customerservice.customerentity.Customer;
import com.customerservice.customexceptions.CustomException;
import com.customerservice.service.CustomerService;

import javax.validation.Valid;


/**
 * This is holding all the Rest end points of service
 * @author anshul
 *
 */


@RestController
@RequestMapping("/customer/details")
public class RoomBookingController {

	@Autowired
	CustomerService customerService;

	@PostMapping("/save")
	public ResponseEntity<Customer> saveCustomerDetails( @Valid @RequestBody Customer newCustomer) {

		Customer customer=customerService.saveCustomerDetails(newCustomer);

		ResponseEntity responseEntity=new ResponseEntity(customer, HttpStatus.CREATED);
		return responseEntity;

	}

	@GetMapping("/{id}")
	public Customer getCustomerDetails(@PathVariable long id) throws CustomException {

		Customer customerDetails=customerService.getCustomerDetails(id);

		return customerDetails;

	}

	@PutMapping("/update")
	public Customer updateCustomerDetails(@RequestBody Customer newCustomer) throws CustomException {


		return customerService.updateCustomerDetails(newCustomer);

	}

	@DeleteMapping("/delete/{id}")
	public String deleteCustomerDetails(@PathVariable long id) throws CustomException {


		return customerService.deleteCustomerDetails(id);

	}
	

	
}

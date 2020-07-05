package com.customerservice.serviceimplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.customerservice.customerentity.Customer;
import com.customerservice.customexceptions.CustomException;
import com.customerservice.jparepository.CustomerJpaRepository;
import com.customerservice.service.CustomerService;

@Component
public class CustomerServiceImplementation implements CustomerService {

	@Autowired
	CustomerJpaRepository customerJpaRepository;

	@Override
	public Customer saveCustomerDetails(Customer customerDetails) {

		Customer newcustomerDetails=(Customer)customerJpaRepository.save(customerDetails);

		new ResponseEntity(newcustomerDetails, HttpStatus.CREATED);

		return newcustomerDetails;
	}

	@Override
	public Customer getCustomerDetails(long id) throws CustomException {


		Customer oldCustomerDetails = customerJpaRepository.findById(id);

		if (oldCustomerDetails != null) {
			customerJpaRepository.findById(id);
		} else {
			throw new CustomException("User Doesn't Exist.");
		}

		return customerJpaRepository.findById(id);
	}

	@Override
	public Customer updateCustomerDetails(Customer customerDetails) throws CustomException {

		long customerId = customerDetails.getId();
		Customer oldCustomerDetails = customerJpaRepository.findById(customerId);

		if (oldCustomerDetails != null) {
			return customerJpaRepository.save(customerDetails);
		} else {
			throw new CustomException("User Doesn't Exist.");
		}


	}

	@Override
	public String deleteCustomerDetails(long id) throws CustomException {


		Customer oldCustomerDetails = customerJpaRepository.findById(id);

		if (oldCustomerDetails != null) {
			customerJpaRepository.deleteById(id);
		} else {
			throw new CustomException("User Doesn't Exist.");
		}

		return "Customer details succesfully deleted";
	}

}

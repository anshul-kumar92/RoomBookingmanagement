package com.customerservice.service;

import com.customerservice.customerentity.Customer;
import com.customerservice.customexceptions.CustomException;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
	public Customer saveCustomerDetails(Customer customerDetails) ;
	public Customer getCustomerDetails(long id) throws CustomException;
	public String deleteCustomerDetails(long id) throws CustomException;
	public Customer updateCustomerDetails(Customer customerDetail) throws CustomException;
	
}

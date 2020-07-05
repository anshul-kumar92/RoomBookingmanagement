package com.customerservice.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customerservice.customerentity.Customer;

@Repository
public interface CustomerJpaRepository extends JpaRepository<Customer, Long>{

	Customer findById(long id);

}

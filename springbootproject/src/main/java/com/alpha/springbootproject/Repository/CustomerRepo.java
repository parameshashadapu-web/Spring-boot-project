package com.alpha.springbootproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.springbootproject.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer>{

	Customer findByMobilno(long mobilno);

	Customer deleteByMobilno(long mobileno);

}

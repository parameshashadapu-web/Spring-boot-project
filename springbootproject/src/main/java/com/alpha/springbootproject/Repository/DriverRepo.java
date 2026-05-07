package com.alpha.springbootproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.springbootproject.entity.Driver;

public interface DriverRepo  extends JpaRepository<Driver, Integer>{

	 

	  Driver findByContact(long contact);

}

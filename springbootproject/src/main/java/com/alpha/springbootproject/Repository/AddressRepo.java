package com.alpha.springbootproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.springbootproject.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {

	Address findByPincode(int pincode);

}

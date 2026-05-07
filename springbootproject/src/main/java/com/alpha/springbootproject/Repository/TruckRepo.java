package com.alpha.springbootproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.springbootproject.entity.Truck;

@Repository
public interface TruckRepo extends JpaRepository<Truck, Integer>{

	Truck findByTnumber(int tnumber);

}

package com.alpha.springbootproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.alpha.springbootproject.entity.Carrier;

@Repository
public interface CarrierRepo extends JpaRepository<Carrier, Integer>{

	Carrier findByContact(long contact);

}

package com.alpha.springbootproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.springbootproject.entity.Orders;

@Repository
public interface OrderRepo  extends JpaRepository<Orders, Integer> {

}

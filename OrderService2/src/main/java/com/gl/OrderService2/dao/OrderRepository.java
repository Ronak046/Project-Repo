package com.gl.OrderService2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gl.OrderService2.bean.OrderApp;

@Repository
public interface OrderRepository extends JpaRepository<OrderApp,Long> {
	@Query("select max(orderId) from OrderApp")
	public Long findMaxOrderId();
}

package com.gl.OrderService2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gl.OrderService2.bean.Item;


@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
	@Query("select max(itemNo) from Item")
	public Long findMaxItemNo();
	@Query("from Item where restaurantId like ?1% and payStatus='Paid'")
	public List<Item> findItemByRestaurantId(String restaurantId);
}

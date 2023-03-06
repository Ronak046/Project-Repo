package com.gl.RestaurantService.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.RestaurantService.bean.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {

}

package com.gl.UserInterfaceClient.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.UserInterfaceClient.bean.MyUser;

@Repository
public interface MyUserRepository extends JpaRepository<MyUser, String > {
	Optional<MyUser> findUserByusername(String username);
}

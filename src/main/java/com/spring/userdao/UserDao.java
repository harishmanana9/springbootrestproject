package com.spring.userdao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
//public interface UserDao extends CrudRepository<User, Integer> {
	
}

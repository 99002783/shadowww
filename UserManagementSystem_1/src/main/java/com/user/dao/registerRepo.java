package com.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.user.model.User;
@Repository
public interface registerRepo extends JpaRepository<User,String>{
//  public void save();
	
}

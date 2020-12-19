package com.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.user.model.User;
import com.user.model.Valid;

public interface ValidRepo extends JpaRepository<Valid,String>{
//	@Autowired
//	registerRepo registerrepo;
//	public void save(Valid valid) {
//		registerrepo.save(valid);
//		
//	}
}

package com.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.user.model.Add;
import com.user.model.User;

public interface AddRepo extends JpaRepository<Add,String>{
//	@Autowired
//	registerRepo registerrepo;
//	public void save(Add add) {
//		registerrepo.save(add);
//	}
}

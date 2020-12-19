package com.user.dao;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;

import com.user.model.Add;
import com.user.model.User;
import com.user.model.Valid;


public class RegisterDAO{
	@Autowired
	registerRepo registerrepo;
//	@Transactional
//   public void saveData(User user) {
//   	System.out.println("reached");
//   	registerDAO.saveData(user);
//   }
	public void save(User user) {
		registerrepo.save(user);
	}
	
	
	
//	public void deleteById(User user) {
//		registerrepo.deleteAll();
//	}
}

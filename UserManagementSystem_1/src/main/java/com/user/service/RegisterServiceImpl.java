package com.user.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.dao.AddRepo;
import com.user.dao.ValidRepo;
import com.user.dao.registerRepo;
import com.user.model.Add;
import com.user.model.User;
import com.user.model.Valid;

@Service
public class RegisterServiceImpl implements RegisterService{
//	 @Autowired(required=true)
//	  RegisterDAO registerDAO;
	  @Autowired(required=true)
	  registerRepo registerrepo;
	 
	  @Autowired(required=true)
	  AddRepo addrepo;
	  
	  @Autowired(required=true)
	  ValidRepo validrepo;
	  
	  
	@Transactional
    public void saveData(User user,Add add,Valid valid) {
    	System.out.println("reached");
    	registerrepo.save(user);
    	addrepo.save(add);
    	validrepo.save(valid);
    }
	
	public void deleteData(Valid valid) {
		addrepo.deleteById(valid.getEmailid());
		validrepo.deleteById(valid.getEmailid());
		registerrepo.deleteById(valid.getEmailid());
	}
	
	public Optional<User> search(String emailid) {
		return registerrepo.findById(emailid);
		
	}
	

	public boolean loginauthenticate(Valid valid) {
		
	    String id=valid.getEmailid();
        Valid obj=validrepo.findById(id).orElseThrow();
        System.out.println(obj.getPassword().equals(valid.getPassword()));
        return obj.getPassword().equals(valid.getPassword());
	}

	public boolean authenticate(String Email) {
		 System.out.println(Email);
	      return validrepo.findById(Email).orElse(null) != null;
	}
	
	 @Transactional
	    public void saveUpdate(User user) {
	        System.out.println(user);
	        registerrepo.save(user);   
	 }	
}

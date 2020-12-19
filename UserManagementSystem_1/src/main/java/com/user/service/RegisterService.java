package com.user.service;

import java.util.Optional;

import com.user.model.Add;
import com.user.model.User;
import com.user.model.Valid;

public interface RegisterService {
	public void saveData(User user,Add add,Valid valid);
	public boolean authenticate(String Email);
	public boolean loginauthenticate(Valid valid);
	 public void saveUpdate(User user);
	public void deleteData(Valid valid);
	public Optional<User> search(String emailid);
}

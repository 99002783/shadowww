package com.user.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Authentication")
public class Valid {
	@Id
    String emailid;
	String password ;
    String confirm;
	public Valid() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Valid(String emailid, String password, String confirm) {
		super();
		this.emailid = emailid;
		this.password = password;
		this.confirm = confirm;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirm() {
		return confirm;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	@Override
	public String toString() {
		return "valid [emailid=" + emailid + ", password=" + password + ", confirm=" + confirm + "]";
	}
    
}

package com.user.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	   String firstname ;
       String lastname;
       String middlename;
       @Id
       String emailid;
       String mobilenumber;
       String gender;      
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String firstname, String lastname, String middlename, String emailid, String mobilenumber,
			String gender) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.middlename = middlename;
		this.emailid = emailid;
		this.mobilenumber = mobilenumber;
		this.gender = gender;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getMiddlename() {
		return middlename;
	}
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "User [firstname=" + firstname + ", lastname=" + lastname + ", middlename=" + middlename + ", emailid="
				+ emailid + ", mobilenumber=" + mobilenumber + ", gender=" + gender + "]";
	}
	
	
	}
	
       


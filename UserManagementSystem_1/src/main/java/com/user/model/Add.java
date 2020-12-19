package com.user.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Address")
public class Add {
	@Id
    String emailid;
	 String state;
     String city;
     String pincode ;
     String country;
	public Add() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Add(String emailid, String state, String city, String pincode, String country) {
		super();
		this.emailid = emailid;
		this.state = state;
		this.city = city;
		this.pincode = pincode;
		this.country = country;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Add [emailid=" + emailid + ", state=" + state + ", city=" + city + ", pincode=" + pincode + ", country="
				+ country + "]";
	}

     
}

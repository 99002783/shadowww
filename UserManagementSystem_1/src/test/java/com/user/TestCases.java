package com.user;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.user.frontend.UserManagement;

class TestCases {

		@Test
		void firstname() {
			
			UserManagement f=new UserManagement();
	        int output=f.name("charitha");
	        assertEquals(1,output);
	        int output1=f.name("");
			assertEquals(0,output1);
		}
		@Test
		void phonenumber()
		{
			UserManagement f=new UserManagement();
	        int output=f.phone("8897896999");
	        assertEquals(1,output);
	        //int o=f.name("cha1");
	        //assertEquals(0,o);
	        int output1=f.phone("");
	        assertEquals(0,output1);
		}
		@Test
		void emailTest()
		{
			UserManagement f=new UserManagement();
	        int output=f.email("c@gmail.com");
	        assertEquals(1,output);
	        int o=f.email("");
	        assertEquals(0,o);
	        int output1=f.email("charitha");
	        assertEquals(0,output1);
		}
		
		
		@Test
		void passwordTest()
		{
			UserManagement f=new UserManagement();
	        int output=f.password("12345678");
	        assertEquals(1,output);
	        int o=f.password("");
	        assertEquals(0,o);
	       
		}
		
		@Test
	void lasttname() {
			
			UserManagement f=new UserManagement();
	        int output=f.lastname("gudala");
	        assertEquals(1,output);
	        int output1=f.lastname("");
	        assertEquals(0,output1);
		}
		
		@Test	
	void pincode() {
		UserManagement f=new UserManagement();
	    int output=f.pin("123456");
	    assertEquals(1,output);
	    int o=f.pin("");
	    assertEquals(0,o);
			
		}
		
	}

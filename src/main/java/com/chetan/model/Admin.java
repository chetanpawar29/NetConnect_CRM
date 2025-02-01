package com.chetan.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Admin {
	
	@Id
	private String aemail;
	private String apassword;
	
	public String getAemail() {
		return aemail;
	}
	public void setAemail(String aemail) {
		this.aemail = aemail;
	}
	public String getApassword() {
		return apassword;
	}
	public void setApassword(String apassword) {
		this.apassword = apassword;
	}
	
	public Admin(String aemail, String apassword) {
		super();
		this.aemail = aemail;
		this.apassword = apassword;
	}
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Admin [aemail=" + aemail + ", apassword=" + apassword + "]";
	}
	
	

}

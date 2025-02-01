package com.chetan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class ServiceMan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long sId;
	private String sname;
	private String sdesignation;
	private String sdepartment;
	private int spincode;
	private long scontact;
	private String semail;
	private String spassword;
	
	
	public long getsId() {
		return sId;
	}
	public void setsId(long sId) {
		this.sId = sId;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSdesignation() {
		return sdesignation;
	}
	public void setSdesignation(String sdesignation) {
		this.sdesignation = sdesignation;
	}
	public String getSdepartment() {
		return sdepartment;
	}
	public void setSdepartment(String sdepartment) {
		this.sdepartment = sdepartment;
	}
	public int getSpincode() {
		return spincode;
	}
	public void setSpincode(int spincode) {
		this.spincode = spincode;
	}
	public long getScontact() {
		return scontact;
	}
	public void setScontact(long scontact) {
		this.scontact = scontact;
	}
	public String getSemail() {
		return semail;
	}
	public void setSemail(String semail) {
		this.semail = semail;
	}
	public String getSpassword() {
		return spassword;
	}
	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}
	
	public ServiceMan(long sId, String sname, String sdesignation, String sdepartment, int spincode, long scontact,
			String semail, String spassword) {
		super();
		this.sId = sId;
		this.sname = sname;
		this.sdesignation = sdesignation;
		this.sdepartment = sdepartment;
		this.spincode = spincode;
		this.scontact = scontact;
		this.semail = semail;
		this.spassword = spassword;
	}
	
	public ServiceMan() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "ServiceMan [sId=" + sId + ", sname=" + sname + ", sdesignation=" + sdesignation + ", sdepartment="
				+ sdepartment + ", spincode=" + spincode + ", scontact=" + scontact + ", semail=" + semail
				+ ", spassword=" + spassword + "]";
	}
	
	

}

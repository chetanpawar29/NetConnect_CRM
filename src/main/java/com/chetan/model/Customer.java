package com.chetan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Customer {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long cId;
	private String cname;
	private long ccontact;
	private String caddress;
	private int cpincode;
	private String cemail;
	private String cpassword;
	public long getcId() {
		return cId;
	}
	public void setcId(long cId) {
		this.cId = cId;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public long getCcontact() {
		return ccontact;
	}
	public void setCcontact(long ccontact) {
		this.ccontact = ccontact;
	}
	public String getCaddress() {
		return caddress;
	}
	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}
	public int getCpincode() {
		return cpincode;
	}
	public void setCpincode(int cpincode) {
		this.cpincode = cpincode;
	}
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	/**
	 * @param cId
	 * @param cname
	 * @param ccontact
	 * @param caddress
	 * @param cpincode
	 * @param cemail
	 * @param cpassword
	 */
	public Customer(long cId, String cname, long ccontact, String caddress, int cpincode, String cemail,
			String cpassword) {
		super();
		this.cId = cId;
		this.cname = cname;
		this.ccontact = ccontact;
		this.caddress = caddress;
		this.cpincode = cpincode;
		this.cemail = cemail;
		this.cpassword = cpassword;
	}
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Customer [cId=" + cId + ", cname=" + cname + ", ccontact=" + ccontact + ", caddress=" + caddress
				+ ", cpincode=" + cpincode + ", cemail=" + cemail + ", cpassword=" + cpassword + "]";
	}
	
	
	
	
	
}

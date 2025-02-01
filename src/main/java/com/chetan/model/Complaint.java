package com.chetan.model;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Complaint {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long comId;
	private long cId;
	private long sId;
	private String title;
	private String details;
	private long Contact;
	private String address;
	private String date;
	private String time;
	private long serviceCode;
	private String status;
	public long getComId() {
		return comId;
	}
	public void setComId(long comId) {
		this.comId = comId;
	}
	public long getcId() {
		return cId;
	}
	public void setcId(long cId) {
		this.cId = cId;
	}
	public long getsId() {
		return sId;
	}
	public void setsId(long sId) {
		this.sId = sId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public long getContact() {
		return Contact;
	}
	public void setContact(long contact) {
		Contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public long getServiceCode() {
		return serviceCode;
	}
	public void setServiceCode(long serviceCode) {
		this.serviceCode = serviceCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @param comId
	 * @param cId
	 * @param sId
	 * @param title
	 * @param details
	 * @param contact
	 * @param address
	 * @param date
	 * @param time
	 * @param serviceCode
	 * @param status
	 */
	public Complaint(long comId, long cId, long sId, String title, String details, long contact, String address,
			String date, String time, long serviceCode, String status) {
		super();
		this.comId = comId;
		this.cId = cId;
		this.sId = sId;
		this.title = title;
		this.details = details;
		Contact = contact;
		this.address = address;
		this.date = date;
		this.time = time;
		this.serviceCode = serviceCode;
		this.status = status;
	}
	/**
	 * 
	 */
	public Complaint() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Complaint [comId=" + comId + ", cId=" + cId + ", sId=" + sId + ", title=" + title + ", details="
				+ details + ", Contact=" + Contact + ", address=" + address + ", date=" + date + ", time=" + time
				+ ", serviceCode=" + serviceCode + ", status=" + status + "]";
	}
	
	
	
	
}

package com.chetan.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.chetan.controller.CustomerController;
import com.chetan.model.Customer;
import com.chetan.model.ServiceMan;



@Component
public class CustomerDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}


	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	public int insert(Customer customer) {
		long i = (Long) this.hibernateTemplate.save(customer);
		return (int)i;
	}


	public List<Customer> viewAll(Customer customer) {
		List<Customer> list =  this.hibernateTemplate.loadAll(Customer.class);
		return list;
	}

	@Transactional
	public void delete(long cId) {
		
		Customer customer = this.hibernateTemplate.get(Customer.class,cId);
		this.hibernateTemplate.delete(customer);
		
	}


	public Customer get(long cId) {
		Customer customer = this.hibernateTemplate.get(Customer.class, cId);
		return customer;
	}

	@Transactional
	public void update(Customer customer) {
		
		this.hibernateTemplate.update(customer);
		
	}


	

}

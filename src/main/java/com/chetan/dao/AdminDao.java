package com.chetan.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.chetan.model.Admin;

@Component
public class AdminDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public Admin get(String email) {
		Admin admin = (Admin) this.hibernateTemplate.get(Admin.class, email);
		return admin;
	}

}

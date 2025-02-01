package com.chetan.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.chetan.model.ServiceMan;

@Component
public class ServiceManDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}


	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}


	@Transactional
	public int insert(ServiceMan serviceMan) {
		long i =(Long) this.hibernateTemplate.save(serviceMan);
		return (int) i;
	}


	public List<ServiceMan> viewAll(ServiceMan serviceMan) {
		List<ServiceMan> list =  this.hibernateTemplate.loadAll(ServiceMan.class);
		return list;
	}

	@Transactional
	public void delete(long sId) {
		ServiceMan sm = this.hibernateTemplate.get(ServiceMan.class, sId);
		this.hibernateTemplate.delete(sm);
		
	}


	public ServiceMan get(long sId) {
		ServiceMan serviceMan = this.hibernateTemplate.get(ServiceMan.class, sId);
		return serviceMan;
	}


	@Transactional
	public void update(ServiceMan serviceMan) {
		this.hibernateTemplate.update(serviceMan);
		
	}

}

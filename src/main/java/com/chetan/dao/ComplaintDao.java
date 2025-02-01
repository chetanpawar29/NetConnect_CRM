package com.chetan.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.chetan.model.Complaint;

@Component
public class ComplaintDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}



	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}


	@Transactional
	public long insert(Complaint complaint) {
		long i = (Long) this.hibernateTemplate.save(complaint);
		return i;
	}
	
	public List<Complaint> viewAll(Complaint complaint) {
		
		List<Complaint> list = this.hibernateTemplate.loadAll(Complaint.class);
		return list;
	}


	@Transactional
	public void delete(long comId) {
		
		Complaint cmp = this.hibernateTemplate.get(Complaint.class, comId);
		
		this.hibernateTemplate.delete(cmp);
	}


	@Transactional
	public void update(Complaint complaint) {
		this.hibernateTemplate.update(complaint);
		
	}



	public Complaint get(long comId) {
		Complaint com = this.hibernateTemplate.get(Complaint.class, comId);
		return com;
	}

}

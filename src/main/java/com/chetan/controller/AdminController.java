package com.chetan.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.chetan.dao.AdminDao;
import com.chetan.dao.ComplaintDao;
import com.chetan.dao.CustomerDao;
import com.chetan.model.ServiceMan;
import com.chetan.dao.ServiceManDao;
import com.chetan.model.Admin;
import com.chetan.model.Complaint;
import com.chetan.model.Customer;

@Controller
public class AdminController {
	
	@Autowired
	Admin admin;
	
	@Autowired
	AdminDao adminDao;
	
	@Autowired
	ServiceMan serviceMan;
	
	@Autowired
	ServiceManDao serviceManDao;
	
	@Autowired
	Customer customer;
	
	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	Complaint complaint;
	
	@Autowired
	ComplaintDao complaintDao;
	

	@RequestMapping("/")
	public String openIndexPage()
	{
		return "index";
	}
	
	@RequestMapping("/openAdminLogin")
	public String openAdminLogin()
	{
		return "A_1_AdminLogin";
	}
	
	@RequestMapping(path="/adminLogin", method=RequestMethod.POST)
	public String login(@RequestParam("aemail") String email, @RequestParam("apassword") String password)
	{
		admin = adminDao.get(email);
		
		try{
			if(email.equals(admin.getAemail()) && password.equals(admin.getApassword()))
			{
				return "A_2_AdminHomePage"; 
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	
		return "A_1_AdminLogin"; 
	}
	
//	Add Service mans
	@RequestMapping("/openAddServiceMan")
	public String openAddServiceMan()
	{
		return "A_3_AddServiceMan";
	}
	
	@RequestMapping(path="/addServiceMan", method=RequestMethod.POST)
	public String addServiceMan(@ModelAttribute ServiceMan serviceMan)
	{
		long i = serviceManDao.insert(serviceMan);
		
		if(i!=0)
		{
			return "A_2_AdminHomePage";
		}else{
			return "A_3_AddServiceMan";
		}
	}
	
//	Add Customer
	@RequestMapping("/openAddCustomer")
	public String openAddCustomer()
	{
		return "A_4_AddCustomer"; 
	}
	
	@RequestMapping(path="/addCustomer", method=RequestMethod.POST)
	public String addCustomer(@ModelAttribute Customer customer)
	{
		long i = customerDao.insert(customer);
		
		if(i!=0)
		{
			return "A_2_AdminHomePage";
		}else{
			return "A_4_AddCustomer";
		}
	}
	
	//	View Service mans
	@RequestMapping("/viewServiceMans")
	public String viewServiceMans(Model model)
	{
		List<ServiceMan> serviceManList = serviceManDao.viewAll(serviceMan);
		
		model.addAttribute("serviceManList",serviceManList);
		
		return "A_5_ViewServiceMans";
	}
	
	//	Delete Service Man
	@RequestMapping(path="/deleteServiceMan", method=RequestMethod.GET)
	public String deleteServiceMan(@RequestParam("sId") long sId)
	{
		
		serviceManDao.delete(sId);
		
		return "redirect:/viewServiceMans";
	}
	
//	View Customer
	@RequestMapping("/viewCustomers")
	public String viewCustomers(Model model)
	{
		List<Customer> customerList = customerDao.viewAll(customer);
		
		model.addAttribute("customerList",customerList);
		
		return "A_6_ViewCustomers";
	}
	
	//	Delete Customer
	@RequestMapping(path="/deleteCustomer", method=RequestMethod.GET)
	public String deleteCustomer(@RequestParam("cId") long cId)
	{
		customerDao.delete(cId);
		
		return "redirect:/viewCustomers";
	}
	
//	view Unsolved complaints
	@RequestMapping("/openViewUnsolvedComplaints")
	public String openViewUnsolvedComplaints(Model model)
	{
		List<Complaint> complaintList = complaintDao.viewAll(complaint);
		
		model.addAttribute("complaintList",complaintList);
		
		return "A_7_ViewUnsolvedComplaints";
	}
	
//	view solved complaints
	@RequestMapping("/OpenViewSolvedComplaints")
	public String OpenViewSolvedComplaints(Model model)
	{
		List<Complaint> complaintList = complaintDao.viewAll(complaint);
		
		model.addAttribute("complaintList",complaintList);
		
		return "A_8_ViewSolvedComplaints";
	}
	
	@RequestMapping("/openassignComplaint")
	public String openassignComplaint(@RequestParam("comId") long comId, Model model)
	{
		complaint = complaintDao.get(comId);
		model.addAttribute("comId", comId);
		
		//generate service code
		Random random = new Random();
		long serviceCode = 1000+ random.nextInt(9999);
		
		complaint.setServiceCode(serviceCode);
		complaintDao.update(complaint);
		
		List<ServiceMan> serviceManList = serviceManDao.viewAll(serviceMan);
		
		model.addAttribute("serviceManList",serviceManList);
		
		return "A_9_AssignComplaint";
	}
	
	@RequestMapping(path="assignComplaint", method=RequestMethod.POST)
	public String assignComplaint(@RequestParam("comId") long comId, @RequestParam("sId") long sId)
	{
		complaint = complaintDao.get(comId);
		
		 if (complaint != null) {
			 complaint.setsId(sId);
			 complaintDao.update(complaint);
		 }
		
		return "redirect:/openViewUnsolvedComplaints";
	}
	
	//logout for admin, service man, customer
	@RequestMapping("/logout")
	public String logout()
	{
		return "redirect:/";
	}
	
}

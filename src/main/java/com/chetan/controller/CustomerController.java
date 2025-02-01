package com.chetan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.chetan.dao.ComplaintDao;
import com.chetan.dao.CustomerDao;
import com.chetan.model.Complaint;
import com.chetan.model.Customer;

@Controller
public class CustomerController {
	
	@Autowired
	Customer customer;
	
	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	Complaint complaint;
	
	@Autowired
	ComplaintDao complaintDao;
	
	
	@RequestMapping("/openCustomerLogin")
	public String openCustomerLogin()
	{
		return "C_1_CustomerLogin";
	}
	
	@RequestMapping(path="/customerLogin", method=RequestMethod.POST)
	public String customerLogin(@RequestParam("cId") long cId,@RequestParam("cemail") String email, @RequestParam("cpassword") String password)
	{
		
		customer = customerDao.get(cId);
		
		try{
			if(email.equals(customer.getCemail()) && password.equals(customer.getCpassword()))
			{
				return "C_2_CustomerHomePage";
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return "C_1_CustomerLogin";
	}
	
//	Add Complaints
	@RequestMapping("/openAddComplaints")
	public String openAddComplaints(Model model)
	{
		long cId = customer.getcId();
		
		model.addAttribute("cId", cId);
		
		return "C_3_AddComplaints";
		
	}
	
	@RequestMapping("/addComplaints")
	public String addComplaints(@ModelAttribute Complaint complaint)
	{
		long comId = complaintDao.insert(complaint);
		
		
		if(comId != 0)
		{
			return "C_2_CustomerHomePage";
		}else{
			return "C_3_AddComplaints";
		}
		
	}
	
//	view Unsolved complaints
	@RequestMapping("/viewUnsolvedComplaints")
	public String viewUnsolvedComplaints(Model model)
	{
		List<Complaint> complaintList = complaintDao.viewAll(complaint);
		
		model.addAttribute("complaintList",complaintList);
		
		return "C_4_ViewUnsolvedComplaints";
	}
	

	
//	delete complaints
	@RequestMapping(path="/deleteComplaint", method=RequestMethod.GET)
	public String deleteComplaint(@RequestParam("comId") long comId)
	{
		complaintDao.delete(comId);
		
		return "redirect:/viewUnsolvedComplaints";
	}
	
//	view solved complaints
	@RequestMapping("/viewSolvedComplaints")
	public String viewSolvedComplaints(Model model)
	{
		List<Complaint> complaintList = complaintDao.viewAll(complaint);
		
		model.addAttribute("complaintList",complaintList);
		
		return "C_5_ViewSolvedComplaints";
	}
	
	
//	delete complaints
	@RequestMapping(path="/deleteSolvedComplaint", method=RequestMethod.GET)
	public String deleteSolvedComplaint(@RequestParam("comId") long comId)
	{
		complaintDao.delete(comId);
		
		return "redirect:/viewUnsolvedComplaints";
	}
	
// Change password
	@RequestMapping("/openChangePassword_C")
	public String openChangePassword_C()
	{
		return "C_6_ChangePassword";
	}
	
	
	@RequestMapping(path="changePassword_C", method=RequestMethod.POST)
	public String changePassword_C(@RequestParam("id") long cId, @RequestParam("password") String password)
	{
		customer = customerDao.get(cId);
		
		try{
			if(cId == customer.getcId())
			{
				customer.setCpassword(password);
				customerDao.update(customer);
				return "C_2_CustomerHomePage";
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return "ChangePassword";
	}
	
}



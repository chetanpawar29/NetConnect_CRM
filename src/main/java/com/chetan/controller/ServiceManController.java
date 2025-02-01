package com.chetan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.chetan.dao.ComplaintDao;
import com.chetan.dao.ServiceManDao;
import com.chetan.model.Complaint;
import com.chetan.model.ServiceMan;

@Controller
public class ServiceManController {
	
	@Autowired
	ServiceMan serviceMan;
	
	@Autowired
	ServiceManDao serviceManDao;
	
	@Autowired
	Complaint complaint;
	
	@Autowired
	ComplaintDao complaintDao;
	

	@RequestMapping("/openServiceManLogin")
	public String openServiceManLogin()
	{
		return "S_1_ServiceManLogin";
	}
	
	@RequestMapping(path="/serviceManLogin", method=RequestMethod.POST)
	public String serviceManLogin(@RequestParam("sId") long sId, @RequestParam("semail") String email, @RequestParam("spassword") String password)
	{
		serviceMan = serviceManDao.get(sId);
		
		try{
			if(serviceMan.getSemail().equals(email) && serviceMan.getSpassword().equals(password))
			{
				return "S_2_ServiceManHomePage";
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return "S_1_ServiceManLogin";
	}
	
//	view Unsolved complaints
	@RequestMapping("/ownAssignedUnsolvedComplaints")
	public String ownAssignedUnsolvedComplaints(Model model)
	{
		List<Complaint> complaintList = complaintDao.viewAll(complaint);
		
		long sId = serviceMan.getsId();
		
		model.addAttribute("sId", sId);
		model.addAttribute("complaintList",complaintList);
		
		return "S_3_ViewOwnAssignedUnsolvedComplaints";
	}
	
//	view solved complaints
	@RequestMapping("/ownSolvedComplaints")
	public String ownSolvedComplaints(Model model)
	{
		List<Complaint> complaintList = complaintDao.viewAll(complaint);
		long sId = serviceMan.getsId();
		
		model.addAttribute("sId", sId);
		model.addAttribute("complaintList",complaintList);
		
		return "S_4_ViewOwnSolvedComplaints";
	}
	
	// Change password
		@RequestMapping("/openChangeSMPassword_S")
		public String openChangeSMPassword_S()
		{
			return "S_5_ChangePassword";
		}
		
		@RequestMapping(path="changePassword_S", method=RequestMethod.POST)
		public String changePassword_S(@RequestParam("id") long sId, @RequestParam("password") String password)
		{
			serviceMan = serviceManDao.get(sId);
			
			try{
				if(sId == serviceMan.getsId())
				{
					serviceMan.setSpassword(password);
					serviceManDao.update(serviceMan);
					return "S_2_ServiceManHomePage";
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
			return "S_5_ChangePassword";
		}
		
		// complaint solved
		
		@RequestMapping("/openComSolvedPage")
		public String openComSolvedPage(@RequestParam("comId") long comId, Model model)
		{
			model.addAttribute("comId",comId);
			return "S_6_ComplaintSolved";
		}
		
		@RequestMapping(path="/complaintSolved", method=RequestMethod.POST)
		public String complaintSolved(@RequestParam("comId") long comId, @RequestParam("serviceCode") long serviceCode, Model model,RedirectAttributes redirectAttributes)
		{
			Complaint complaint = complaintDao.get(comId);
		    String message;
		    String redirectUrl;

		    if (complaint.getServiceCode() == serviceCode) {
		        complaint.setStatus("Solved");
		        complaintDao.update(complaint);
		        message = "Complaint successfully resolved!";
		        redirectUrl = "ownAssignedUnsolvedComplaints";
		    } else {
		        message = "Invalid Service Code! Please confirm with the customer.";
		        redirectUrl = "openComSolvedPage?comId="+comId;
		    }

		    // Send attributes to JSP
		    model.addAttribute("message", message);
		    model.addAttribute("redirectUrl", redirectUrl);
		    
			    return "S_7_ShowPopup"; 
		    }

		
}

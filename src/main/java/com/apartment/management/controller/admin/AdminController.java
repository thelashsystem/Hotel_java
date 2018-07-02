package com.apartment.management.controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apartment.management.model.account.Account;
import com.apartment.management.model.account.EmployeeAccount;
import com.apartment.management.service.interfaces.account.EmployeeAccountService;

@Controller
public class AdminController
{
	@Autowired
	private EmployeeAccountService employeeAccountService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String doIndexAdmin(HttpSession session)
	{
//		if ( session.getAttribute("userManager") != null )
//		{
//			Account account = (Account) session.getAttribute("user");
//			if ( account instanceof EmployeeAccount )
//			{
//				return "redirect:index.html";
//			}
//
//		}
//		return "login";
		
		return "redirect:index.html";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String doLoginAdminView()
	{
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLoginAdmin(EmployeeAccount employeeAccount,
			BindingResult rs, Model m, HttpSession session)
	{
		Account account = employeeAccountService.getAccount(employeeAccount);
		if ( account != null && account instanceof EmployeeAccount )
		{
			session.setAttribute("userManager", account);
			return "redirect:index.html";
		} else
		{
			return "login";
		}

	}

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String doViewAdminHomepage(HttpSession session)
	{
//		if ( session.getAttribute("userManager") == null )
//		{
//			return "login";
//		}
		return "index";
	}

	@RequestMapping(value = "*", method = RequestMethod.GET)
	public String doError404()
	{
		return "404";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String doUpdateAccountView()
	{
		return "profile";
	}

	@RequestMapping(value = "/updateProfile", method = RequestMethod.POST)
	public String doUpdateAccount()
	{
		return "index";
	}
}

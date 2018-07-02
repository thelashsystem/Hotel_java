package com.apartment.management.controller.view;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apartment.management.model.account.CustomerAccount;
import com.apartment.management.service.interfaces.account.CustomerAccountService;

@Controller
@RequestMapping("account")
public class AccountController
{
	@Autowired
	private CustomerAccountService customerAccountService;

	@RequestMapping(value = "account-info", method = RequestMethod.GET)
	public String doView(Model m, HttpSession session)
	{
		if ( session.getAttribute("user") != null )
		{
			CustomerAccount customerAccount = (CustomerAccount) session
					.getAttribute("user");
			m.addAttribute("customerAccount", customerAccount);
		}
		return "index";
	}

	@RequestMapping(value = "account-info", params = "id", method = RequestMethod.GET)
	public String doView(Model m, @RequestParam(value = "id") String id,
			HttpSession session)
	{
		if ( session.getAttribute("user") != null )
		{
			CustomerAccount customerAccount = (CustomerAccount) session
					.getAttribute("user");
			if ( customerAccount.getId() == Integer.parseInt(id) )
			{
				m.addAttribute("customerAccount", customerAccount);
			}
			return "account-info";
		}
		return "index";
	}

	@RequestMapping(value = "update-account", method = RequestMethod.POST)
	public String doView(
			@ModelAttribute(value = "customerAccount") CustomerAccount customerAccount,
			BindingResult rs, Model m)
	{
		if ( !rs.hasErrors() )
		{
			customerAccountService.update(customerAccount);
		} else
		{
			return "account-info";
		}
		return "account-info";
	}
}

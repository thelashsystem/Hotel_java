package com.apartment.management.controller.view;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apartment.management.model.account.Account;
import com.apartment.management.model.account.CustomerAccount;
import com.apartment.management.service.interfaces.account.AccountService;
import com.apartment.management.service.interfaces.account.CustomerAccountService;

@Controller
public class LoginController
{
	@Autowired
	private CustomerAccountService customerAccountService;

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String doViewLogin(Model m)
	{
		return "login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String doLogin(CustomerAccount customerAccount, Model m,
			HttpSession session)
	{
		Account account = customerAccountService.getAccount(customerAccount);
		if ( account == null )
		{
			m.addAttribute("error",
					"Email or password is wrong. Please try again");
			m.addAttribute("email", customerAccount.getEmail());
			return "login";
		} else
		{
			session.setAttribute("user", account);
		}
		return "index";
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String doLogout(Model m, HttpSession session)
	{
		session.removeAttribute("user");
		return "index";
	}
}

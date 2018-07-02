package com.apartment.management.controller.view;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apartment.management.model.account.CustomerAccount;
import com.apartment.management.model.person.Customer;
import com.apartment.management.model.person.PersonalProfile;
import com.apartment.management.service.interfaces.account.CustomerAccountService;


@Controller
public class RegisterController
{
	@Autowired
	private CustomerAccountService customerAccountService;

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String doViewRegistry(Model m)
	{

		return "register";
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String doActionRegistry(CustomerAccount account,
			PersonalProfile profile, BindingResult rs, Model m)
	{
		if ( !rs.hasErrors() )
		{
			Customer customer = new Customer();
			customer.setProfile(profile);
			account.setCustomer(customer);
			String activeCode = new BigInteger(KeyGenerators.secureRandom(10).generateKey()).toString(32);
			account.setActiveCode(activeCode);
			customerAccountService.add(account);
			m.addAttribute("msg", "Registered Account successfully!, We sent an email to <a href='#'>" + account.getEmail() + "</a>. "
					+ "Please enter an active code in this email to activate your account.");
			m.addAttribute("email", account.getEmail());
		} else
		{
			return "register";
		}
		return "active-account";
	}
	
	@RequestMapping(value = "active-account", method = RequestMethod.GET)
	public String doActiveAccountView(Model m)
	{
		
		return "active-account";
	}
	
	@RequestMapping(value = "account-{accountId}/active-account", params="activeCode", method = RequestMethod.GET)
	public String doActiveAccountView1(@PathVariable(value="accountId")String accountId, @RequestParam(value="activeCode")String activeCode, Model m)
	{
		CustomerAccount customerAccount  = customerAccountService.getById(Integer.parseInt(accountId));
		if (customerAccount.getActiveCode().equals(activeCode)) {
			customerAccount.setActive(true);
			customerAccountService.update(customerAccount);
			m.addAttribute("msg", "activate account successfully!");
		} else {
			m.addAttribute("msg", "Active code is not correct");
		}
		return "active-account";
	}
	
	@RequestMapping(value = "active-account", params={"activeCode", "email"}, method = RequestMethod.GET)
	public String doActiveAccountView2(@RequestParam(value="email")String email, @RequestParam(value="activeCode")String activeCode, Model m)
	{
		CustomerAccount customerAccount = customerAccountService.getAccountByEmail(email);
		if (customerAccount.getActiveCode().equals(activeCode)) {
			customerAccount.setActive(true);
			customerAccountService.update(customerAccount);
		} else {
			m.addAttribute("msg", "Active code is not correct");
		}
		return "active-account";
	}
}

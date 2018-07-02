package com.apartment.management.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "criteria")
public class CriteriaController
{
	@RequestMapping(value = "criteria-list", method = RequestMethod.GET)
	public String doView()
	{
		return "criteria-list";
	}
}

package com.apartment.management.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "icon")
public class IconController
{
	@RequestMapping(value = "icon-list", method = RequestMethod.GET)
	public String doView()
	{
		return "icon-list";
	}
}

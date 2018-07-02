package com.apartment.management.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("advertising")
public class AdvertisingController
{
	@RequestMapping(value = "advertising-list", method = RequestMethod.GET)
	public String doView()
	{
		return "advertising-list";
	}
}

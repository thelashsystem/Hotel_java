package com.apartment.management.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "invoice")
public class InvoiceController
{
	@RequestMapping(value = "/invoice-list", method = RequestMethod.GET)
	public String doView(Model m)
	{
		return "invoice-list";
	}

	@RequestMapping(value = "/invoice-detail", method = RequestMethod.GET)
	public String doDetailView(Model m)
	{
		return "invoice-detail";
	}
}

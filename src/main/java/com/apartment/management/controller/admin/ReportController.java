package com.apartment.management.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "report-statistics")
public class ReportController
{
	@RequestMapping(value = "report-list", method = RequestMethod.GET)
	public String doView(Model m)
	{
		return "report-list";
	}

	@RequestMapping(value = "report-detail", method = RequestMethod.GET)
	public String doDetailView(Model m)
	{
		return "report-detail";
	}
}

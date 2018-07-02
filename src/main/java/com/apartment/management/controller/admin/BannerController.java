package com.apartment.management.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "website/banner")
public class BannerController
{
	@RequestMapping(value = "banner-list", method = RequestMethod.GET)
	public String doBannerListView()
	{
		return "banner-list";
	}

	@RequestMapping(value = "banner-position", method = RequestMethod.GET)
	public String doBannerPositionView()
	{
		return "banner-position";
	}
}

package com.apartment.management.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apartment.management.model.setting.Setting;
import com.apartment.management.service.interfaces.setting.SettingService;

@Controller
public class SettingController
{
	@Autowired
	private SettingService settingService;
	
	@RequestMapping(value="setting", method=RequestMethod.GET)
	private String doView(Model m)
	{
		Short id = 1;
		Setting setting = settingService.getById(id);
		if (setting == null) {
			setting = new Setting();
			settingService.add(setting);
			m.addAttribute("setting", setting);
		} else {
			m.addAttribute("setting", setting);
		}
		return "setting";
	}
	
	@RequestMapping(value="setting", method=RequestMethod.POST)
	private String doView(@ModelAttribute(value="setting")Setting setting, BindingResult rs, Model m)
	{
		if (!rs.hasErrors()) {
			settingService.update(setting); 
			m.addAttribute("msg", "Updated successfully!");
		} else {
			return "setting";
		}
		return "setting";
	}
}

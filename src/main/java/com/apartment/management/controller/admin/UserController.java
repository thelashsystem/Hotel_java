package com.apartment.management.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.apartment.management.model.account.Account;
import com.apartment.management.response.DatatableResponse;
import com.apartment.management.response.StatusResponse;
import com.apartment.management.response.dto.UserDto;
import com.apartment.management.service.interfaces.account.AccountService;

@Controller
@RequestMapping("user")
public class UserController
{
	@Autowired
	private AccountService<Account> accountService;

	@RequestMapping(value = "user-list", method = RequestMethod.GET)
	private String doView(Model m)
	{
		return "user-list";
	}

	@RequestMapping(value = "user-detail", method = RequestMethod.GET)
	private String doDetailView()
	{
		return "redirect:user-list.html";
	}
	
	@RequestMapping(value = "user-detail", params="id", method = RequestMethod.GET)
	private String doDetailView(@RequestParam(value="id")String id, Model m)
	{
		
		return "user-detail";
	}
	
	@RequestMapping(value = "user-detail", method = RequestMethod.POST)
	private String doUpdateDetailView(@ModelAttribute(value="")Account account, BindingResult rs, Model m)
	{
		if (!rs.hasErrors()) {
			
		} else {
			
		}
		return "user-detail-";
	}

	@RequestMapping(value = "getAllUser", method = RequestMethod.GET)
	@ResponseBody
	private DatatableResponse<UserDto> getAllUser()
	{
		DatatableResponse<UserDto> response = new DatatableResponse<>();
//		List<Account> accounts = accountService.getAll();
//		List<UserDto> UserDtos = UserDto.map(accounts);
//		response.setAaData(UserDtos);
		return response;
	}

	@RequestMapping(value = "addUser", method = RequestMethod.POST)
	@ResponseBody
	private StatusResponse<Account> doAdd()
	{
		return new StatusResponse<Account>();
	}

	@RequestMapping(value = "updateUser", method = RequestMethod.POST)
	@ResponseBody
	private StatusResponse<Account> doUpdate()
	{
		return new StatusResponse<Account>();
	}

	@RequestMapping(value = "deleteUser", method = RequestMethod.POST)
	@ResponseBody
	private StatusResponse<Account> doDelete()
	{
		return new StatusResponse<Account>();
	}
}

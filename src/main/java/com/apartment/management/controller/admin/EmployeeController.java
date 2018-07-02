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

import com.apartment.management.model.person.Employee;
import com.apartment.management.response.DatatableResponse;
import com.apartment.management.response.StatusResponse;
import com.apartment.management.response.dto.EmployeeDto;
import com.apartment.management.service.interfaces.person.EmployeeService;

@Controller
@RequestMapping(value = "employee")
public class EmployeeController
{
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "employee-list", method = RequestMethod.GET)
	private String doView()
	{
		return "employee-list";
	}

	@RequestMapping(value = "employee-detail", params = "id", method = RequestMethod.GET)
	private String doDetailEmployeeView(Model m, @RequestParam(value="id")String id)
	{
		Employee employee = employeeService.getById(Integer.parseInt(id));
		m.addAttribute("employee", employee);
		return "employee-detail";
	}
	
	@RequestMapping(value = "employee-detail", method = RequestMethod.POST)
	private String doDetailEmployeeView(@ModelAttribute(value="employee")Employee employee, BindingResult rs, Model m)
	{
		if (!rs.hasErrors()) {
			employeeService.update(employee);
		} else {
			return "employee-detail";
		}
		return "employee-detail";
	}
	
	@RequestMapping(value = "employee-detail", method = RequestMethod.GET)
	private String doDetailEmployeeView()
	{
		return "redirect:management/employee/employee-list.html";
	}

	@RequestMapping(value = "getAllEmployee", method = RequestMethod.GET)
	@ResponseBody
	private DatatableResponse<EmployeeDto> getAllEmployee()
	{
		List<Employee> listEmp = employeeService.getAll();
		// Employee emp = personService.getById(21);
		// Guard guard = new Guard();
		// PersonalProfile profile = new PersonalProfile();
		// profile.setFirstName("abc");
		// profile.setLastName("");
		// profile.setPhone("0000");
		// guard.setEmployeeCode("2121s");
		// guard.setProfile(profile);
		// personService.add(guard);
		DatatableResponse<EmployeeDto> response = new DatatableResponse<>();
		response.setAaData(EmployeeDto.map(listEmp));
		return response;
	}

	@RequestMapping(value = "addEmployee", method = RequestMethod.POST)
	@ResponseBody
	private StatusResponse<Employee> doAdd()
	{
		return new StatusResponse<Employee>();
	}

	@RequestMapping(value = "updateEmployee", method = RequestMethod.POST)
	@ResponseBody
	private StatusResponse<Employee> doUpdate()
	{
		return new StatusResponse<Employee>();
	}

	@RequestMapping(value = "deleteEmployee", method = RequestMethod.POST)
	@ResponseBody
	private StatusResponse<Employee> doDelete()
	{
		return new StatusResponse<Employee>();
	}

	@RequestMapping(value = "assignEmployee", method = RequestMethod.POST)
	@ResponseBody
	private StatusResponse<Employee> assignEmp()
	{
		return new StatusResponse<Employee>();
	}
}

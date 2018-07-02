package com.apartment.management.response.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.apartment.management.model.person.Employee;

public class EmployeeDto implements Serializable
{
	/**
	 * 
	 */
	private Integer id;
	private static final long serialVersionUID = 1L;
	private String employeeCode;
	private String fullName;
	private String gender;
	private String birthday;
	private String phoneNumber;
	private SimpleDateFormat dateFormat;
	private String position;
	private String assignedDate;

	public EmployeeDto()
	{
		dateFormat = new SimpleDateFormat("dd/MM/yyy");
	}

	public String getEmployeeCode()
	{
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode)
	{
		this.employeeCode = employeeCode;
	}

	public String getFullName()
	{
		return fullName;
	}

	public void setFullName(String fullName)
	{
		this.fullName = fullName;
	}

	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	public String getBirthday()
	{
		return birthday;
	}

	public void setBirthday(Date birthday)
	{
		this.birthday = dateFormat.format(birthday);
	}

	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getPosition()
	{
		return position;
	}

	public void setPosition(String position)
	{
		this.position = position;
	}

	public String getAssignedDate()
	{
		return assignedDate;
	}

	public void setAssignedDate(String assignedDate)
	{
		this.assignedDate = assignedDate;
	}

	public void setBirthday(String birthday)
	{
		this.birthday = birthday;
	}

	public static EmployeeDto map(Employee emp)
	{
		EmployeeDto empDto = new EmployeeDto();
		empDto.setId(emp.getId());
		empDto.setFullName(emp.getProfile().getLastName()
				+ emp.getProfile().getFirstName());
		empDto.setEmployeeCode(emp.getEmployeeCode());
		empDto.setGender(emp.getProfile().isGender() ? "Male" : "Female");
		empDto.setBirthday(emp.getProfile().getBirthday());
		empDto.setPhoneNumber(emp.getProfile().getPhone());
		return empDto;
	}

	public static List<EmployeeDto> map(List<Employee> listEmp)
	{
		List<EmployeeDto> listEmpDto = new ArrayList<>();
		for ( Employee emp : listEmp )
		{
			listEmpDto.add(map(emp));
		}
		return listEmpDto;
	}
}

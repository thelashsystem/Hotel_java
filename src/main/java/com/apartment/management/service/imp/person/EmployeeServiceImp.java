package com.apartment.management.service.imp.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apartment.management.dao.interfaces.person.EmployeeDaoInf;
import com.apartment.management.model.building.Building;
import com.apartment.management.model.person.Employee;
import com.apartment.management.service.interfaces.person.EmployeeService;

@Component
@Service
@Transactional
public class EmployeeServiceImp extends PersonServiceImp<Employee> implements
		EmployeeService
{
	@Autowired
	private EmployeeDaoInf employeeDaoInf;
	
	@Override
	public List<Employee> getEmployeeByBuilding(Building building)
	{
		return employeeDaoInf.getEmployeeByBuilding(building);
	}

}

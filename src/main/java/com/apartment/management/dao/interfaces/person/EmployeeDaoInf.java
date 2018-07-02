package com.apartment.management.dao.interfaces.person;

import java.util.List;

import com.apartment.management.model.building.Building;
import com.apartment.management.model.person.Employee;

public interface EmployeeDaoInf extends PersonDaoInf<Employee>
{
	public List<Employee> getEmployeeByBuilding(Building building);
}

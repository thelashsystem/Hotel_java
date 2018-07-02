package com.apartment.management.service.interfaces.person;

import java.util.List;

import com.apartment.management.dao.interfaces.GeneralDao;
import com.apartment.management.model.building.Building;
import com.apartment.management.model.person.Employee;

public interface EmployeeService extends GeneralDao<Employee, Integer>
{
	public List<Employee> getEmployeeByBuilding(Building building);
}

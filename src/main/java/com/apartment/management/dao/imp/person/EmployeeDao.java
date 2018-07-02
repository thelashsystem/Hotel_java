package com.apartment.management.dao.imp.person;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.person.EmployeeDaoInf;
import com.apartment.management.model.building.Building;
import com.apartment.management.model.person.Employee;

@Component
@Repository
public class EmployeeDao extends PersonDao<Employee> implements EmployeeDaoInf
{
	public EmployeeDao()
	{
		super(Employee.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployeeByBuilding(Building building)
	{
		Query query = session().createQuery("select e from Employee e where e in (select a from Assignment a where a.building = :building)");
		query.setParameter("building", building);
		return query.list();
	}
}

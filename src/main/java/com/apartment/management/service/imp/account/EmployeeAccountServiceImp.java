package com.apartment.management.service.imp.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apartment.management.dao.interfaces.account.EmployeeAccountDaoInf;
import com.apartment.management.model.account.EmployeeAccount;
import com.apartment.management.service.interfaces.account.EmployeeAccountService;

@Component
@Service
@Transactional
public class EmployeeAccountServiceImp implements EmployeeAccountService
{
	@Autowired
	private EmployeeAccountDaoInf employeeAccountDaoInf;
	
	@Override
	public EmployeeAccount getAccount(EmployeeAccount account)
	{
		return employeeAccountDaoInf.getAccount(account);
	}

	@Override
	public void add(EmployeeAccount obj)
	{
		employeeAccountDaoInf.add(obj);
	}

	@Override
	public void update(EmployeeAccount obj)
	{
		employeeAccountDaoInf.update(obj);
	}

	@Override
	public void delete(EmployeeAccount obj)
	{
		employeeAccountDaoInf.delete(obj);
	}

	@Override
	public List<EmployeeAccount> getAll()
	{
		return employeeAccountDaoInf.getAll();
	}

	@Override
	public EmployeeAccount getById(Integer id)
	{
		return employeeAccountDaoInf.getById(id);
	}

}

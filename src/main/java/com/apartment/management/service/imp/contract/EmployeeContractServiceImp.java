package com.apartment.management.service.imp.contract;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.apartment.management.dao.interfaces.contract.EmployeeContractDaoInf;
import com.apartment.management.model.contract.EmployeeContract;
import com.apartment.management.service.interfaces.contract.EmployeeContractService;

@Component
@Service
@Transactional
public class EmployeeContractServiceImp implements EmployeeContractService
{
	@Autowired
	private EmployeeContractDaoInf employeeContractDaoInf;

	@Override
	public void add(EmployeeContract obj)
	{
		employeeContractDaoInf.add(obj);
	}

	@Override
	public void update(EmployeeContract obj)
	{
		employeeContractDaoInf.update(obj);
	}

	@Override
	public void delete(EmployeeContract obj)
	{
		employeeContractDaoInf.delete(obj);
	}

	@Override
	public List<EmployeeContract> getAll()
	{
		return employeeContractDaoInf.getAll();
	}

	@Override
	public EmployeeContract getById(Integer id)
	{
		return employeeContractDaoInf.getById(id);
	}

}

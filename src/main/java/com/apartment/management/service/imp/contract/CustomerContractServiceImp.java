package com.apartment.management.service.imp.contract;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.apartment.management.dao.interfaces.contract.CustomerContractDaoInf;
import com.apartment.management.model.contract.CustomerContract;
import com.apartment.management.service.interfaces.contract.CustomerContractService;

@Component
@Service
@Transactional
public class CustomerContractServiceImp implements CustomerContractService
{
	@Autowired
	private CustomerContractDaoInf customerContractDaoInf;

	@Override
	public void add(CustomerContract obj)
	{
		customerContractDaoInf.add(obj);
	}

	@Override
	public void update(CustomerContract obj)
	{
		customerContractDaoInf.update(obj);
	}

	@Override
	public void delete(CustomerContract obj)
	{
		customerContractDaoInf.delete(obj);
	}

	@Override
	public List<CustomerContract> getAll()
	{
		return customerContractDaoInf.getAll();
	}

	@Override
	public CustomerContract getById(Integer id)
	{
		return customerContractDaoInf.getById(id);
	}

	@Override
	public List<CustomerContract> getUnexpiredContract()
	{
		return customerContractDaoInf.getUnexpiredContract();
	}

}

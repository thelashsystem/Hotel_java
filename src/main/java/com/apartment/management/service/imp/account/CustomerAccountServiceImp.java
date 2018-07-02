package com.apartment.management.service.imp.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apartment.management.dao.interfaces.account.CustomerAccountDaoInf;
import com.apartment.management.model.account.CustomerAccount;
import com.apartment.management.service.interfaces.account.CustomerAccountService;

@Component
@Service
@Transactional
public class CustomerAccountServiceImp implements CustomerAccountService
{
	@Autowired
	private CustomerAccountDaoInf customerAccountDaoInf;
	@Override
	public CustomerAccount getAccount(CustomerAccount account)
	{
		return customerAccountDaoInf.getAccount(account);
	}

	@Override
	public void add(CustomerAccount obj)
	{
		customerAccountDaoInf.add(obj);
	}

	@Override
	public void update(CustomerAccount obj)
	{
		customerAccountDaoInf.update(obj);
	}

	@Override
	public void delete(CustomerAccount obj)
	{
		customerAccountDaoInf.delete(obj);
	}

	@Override
	public List<CustomerAccount> getAll()
	{
		return customerAccountDaoInf.getAll();
	}

	@Override
	public CustomerAccount getById(Integer id)
	{
		return customerAccountDaoInf.getById(id);
	}

	@Override
	public CustomerAccount getAccountByEmail(String email)
	{
		return customerAccountDaoInf.getAccountByEmail(email);
	}

}

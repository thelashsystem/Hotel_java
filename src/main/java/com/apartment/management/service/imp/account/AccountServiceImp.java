package com.apartment.management.service.imp.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apartment.management.dao.imp.account.GeneralAccountDao;
import com.apartment.management.model.account.Account;
import com.apartment.management.service.interfaces.account.AccountService;

@Component
@Service
@Transactional
public class AccountServiceImp<T extends Account> implements AccountService<Account>
{
	@Autowired
	private GeneralAccountDao accountDao;

	@Override
	public void add(Account account)
	{
		accountDao.add(account);
	}

	@Override
	public void update(Account account)
	{
		accountDao.update(account);
	}

	@Override
	public void delete(Account account)
	{
		accountDao.delete(account);
	}

	@Override
	public List<Account> getAll()
	{
		return accountDao.getAll();
	}

	@Override
	public Account getById(Integer id)
	{
		return accountDao.getById(id);
	}

	@Override
	public Account getAccount(Account account)
	{
		return accountDao.getAccount(account);
	}

}

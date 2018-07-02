package com.apartment.management.dao.interfaces.account;

import com.apartment.management.dao.interfaces.GeneralDao;
import com.apartment.management.model.account.Account;

public interface AccountDaoInf<T extends Account, N extends Number> extends
		GeneralDao<T, N>
{
	public T getAccount(T account);
}

package com.apartment.management.service.interfaces.account;

import com.apartment.management.model.account.Account;
import com.apartment.management.service.interfaces.GeneralService;

public interface AccountService<T extends Account> extends
		GeneralService<T, Integer>
{
	public T getAccount(T account);
}

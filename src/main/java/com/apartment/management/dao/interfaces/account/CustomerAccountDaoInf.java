package com.apartment.management.dao.interfaces.account;

import com.apartment.management.model.account.CustomerAccount;

public interface CustomerAccountDaoInf extends AccountDaoInf<CustomerAccount, Integer>
{
	public CustomerAccount getAccountByEmail(String email);
}

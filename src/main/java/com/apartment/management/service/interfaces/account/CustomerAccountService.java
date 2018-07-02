package com.apartment.management.service.interfaces.account;

import com.apartment.management.model.account.CustomerAccount;

public interface CustomerAccountService extends AccountService<CustomerAccount>
{
	public CustomerAccount getAccountByEmail(String email);
}

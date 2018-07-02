package com.apartment.management.dao.imp.account;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.account.CustomerAccountDaoInf;
import com.apartment.management.model.account.CustomerAccount;

@Component
@Repository
public class CustomerAccountDao extends AccountDao<CustomerAccount> implements CustomerAccountDaoInf 
{

	@Override
	public CustomerAccount getAccountByEmail(String email)
	{
		return (CustomerAccount) session().createQuery("from CustomerAccount c where c.email = :email ").setParameter("email", email).uniqueResult();
	}
	
}

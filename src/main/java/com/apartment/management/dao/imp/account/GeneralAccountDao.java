package com.apartment.management.dao.imp.account;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.account.AccountDaoInf;
import com.apartment.management.model.account.Account;

@Component
@Repository
public class GeneralAccountDao extends AccountDao<Account> implements AccountDaoInf<Account, Integer>
{

}

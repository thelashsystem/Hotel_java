package com.apartment.management.dao.imp.account;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.account.EmployeeAccountDaoInf;
import com.apartment.management.model.account.EmployeeAccount;

@Component
@Repository
public class EmployeeAccountDao extends AccountDao<EmployeeAccount> implements EmployeeAccountDaoInf
{

}

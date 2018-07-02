package com.apartment.management.dao.imp.contract;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.contract.EmployeeContractDaoInf;
import com.apartment.management.model.contract.EmployeeContract;

@Component
@Repository
public class EmployeeContractDao extends ContractDao<EmployeeContract>
		implements EmployeeContractDaoInf
{

}

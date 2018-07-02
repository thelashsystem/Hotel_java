package com.apartment.management.dao.imp.contract;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.contract.ServiceContractDaoInf;
import com.apartment.management.model.contract.ServiceContract;

@Component
@Repository
public class ServiceContractDao extends ContractDao<ServiceContract> implements
		ServiceContractDaoInf
{

}

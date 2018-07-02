package com.apartment.management.dao.imp.contract;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.contract.SupplierContractDaoInf;
import com.apartment.management.model.contract.SupplyContract;

@Component
@Repository
public class SupplierContractDao extends ContractDao<SupplyContract> implements
		SupplierContractDaoInf
{

}

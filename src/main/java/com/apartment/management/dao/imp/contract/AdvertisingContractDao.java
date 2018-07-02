package com.apartment.management.dao.imp.contract;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.contract.AdvertisingContractDaoInf;
import com.apartment.management.model.contract.AdvertisingContract;

@Component
@Repository
public class AdvertisingContractDao extends ContractDao<AdvertisingContract>
		implements AdvertisingContractDaoInf
{

}

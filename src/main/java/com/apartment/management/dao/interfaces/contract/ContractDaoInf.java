package com.apartment.management.dao.interfaces.contract;

import com.apartment.management.dao.interfaces.GeneralDao;
import com.apartment.management.model.contract.Contract;

public interface ContractDaoInf<T extends Contract> extends
		GeneralDao<T, Integer>
{

}

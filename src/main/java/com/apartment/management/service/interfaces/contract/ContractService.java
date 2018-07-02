package com.apartment.management.service.interfaces.contract;

import com.apartment.management.model.contract.Contract;
import com.apartment.management.service.interfaces.GeneralService;

public interface ContractService<T extends Contract> extends
		GeneralService<T, Integer>
{

}

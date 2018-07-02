package com.apartment.management.dao.interfaces.provider;

import com.apartment.management.dao.interfaces.GeneralDao;
import com.apartment.management.model.provider.Provider;

public interface ProviderDaoInf<T extends Provider> extends
		GeneralDao<T, Integer>
{

}

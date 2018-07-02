package com.apartment.management.service.interfaces.provider;

import com.apartment.management.model.provider.Provider;
import com.apartment.management.service.interfaces.GeneralService;

public interface ProviderService<T extends Provider> extends
		GeneralService<T, Integer>
{

}

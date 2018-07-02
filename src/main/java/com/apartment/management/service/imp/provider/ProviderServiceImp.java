package com.apartment.management.service.imp.provider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apartment.management.dao.imp.provider.ProviderDao;
import com.apartment.management.model.provider.Provider;
import com.apartment.management.service.interfaces.provider.ProviderService;

@Component
@Service
@Transactional
public class ProviderServiceImp<T extends Provider> implements
		ProviderService<T>
{
	@Autowired
	private ProviderDao<T> providerDao;

	@Override
	public void add(T provider)
	{
		providerDao.add(provider);
	}

	@Override
	public void update(T provider)
	{
		providerDao.delete(provider);
	}

	@Override
	public void delete(T provider)
	{
		providerDao.delete(provider);
	}

	@Override
	public List<T> getAll()
	{
		return providerDao.getAll();
	}

	@Override
	public T getById(Integer id)
	{
		return providerDao.getById(id);
	}

}

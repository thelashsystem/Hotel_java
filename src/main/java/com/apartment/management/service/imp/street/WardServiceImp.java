package com.apartment.management.service.imp.street;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apartment.management.dao.imp.street.WardDao;
import com.apartment.management.model.street.Ward;
import com.apartment.management.service.interfaces.street.WardService;

@Component
@Service
@Transactional
public class WardServiceImp implements WardService
{
	@Autowired
	private WardDao wardDao;

	@Override
	public void add(Ward ward)
	{
		wardDao.add(ward);
	}

	@Override
	public void update(Ward ward)
	{
		wardDao.update(ward);
	}

	@Override
	public void delete(Ward ward)
	{
		wardDao.delete(ward);
	}

	@Override
	public List<Ward> getAll()
	{
		return wardDao.getAll();
	}

	@Override
	public Ward getById(Short id)
	{
		return wardDao.getById(id);
	}
}

package com.apartment.management.service.imp.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apartment.management.dao.interfaces.business.RegisterServiceDaoInf;
import com.apartment.management.model.business.RegisterService;
import com.apartment.management.service.interfaces.business.RegisterServiceService;

@Component
@Service
@Transactional
public class RegisterServiceServiceImp implements RegisterServiceService
{
	@Autowired
	private RegisterServiceDaoInf registerServiceDaoInf;

	@Override
	public void add(RegisterService obj)
	{
		registerServiceDaoInf.add(obj);
	}

	@Override
	public void update(RegisterService obj)
	{
		registerServiceDaoInf.update(obj);
	}

	@Override
	public void delete(RegisterService obj)
	{
		registerServiceDaoInf.delete(obj);
	}

	@Override
	public List<RegisterService> getAll()
	{
		return registerServiceDaoInf.getAll();
	}

	@Override
	public RegisterService getById(Integer id)
	{
		return registerServiceDaoInf.getById(id);
	}

	@Override
	public List<RegisterService> getUnexpiredRegisteredService()
	{
		return registerServiceDaoInf.getUnexpiredRegisteredService();
	}

}

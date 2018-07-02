package com.apartment.management.service.imp.contract;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.apartment.management.dao.interfaces.contract.ServiceContractDaoInf;
import com.apartment.management.model.contract.ServiceContract;
import com.apartment.management.service.interfaces.contract.ServiceContractService;

@Component
@Service
@Transactional
public class ServiceContractServiceImp implements ServiceContractService
{
	@Autowired
	private ServiceContractDaoInf ServiceContractDaoInf;

	@Override
	public void add(ServiceContract obj)
	{
		ServiceContractDaoInf.add(obj);
	}

	@Override
	public void update(ServiceContract obj)
	{
		ServiceContractDaoInf.add(obj);
	}

	@Override
	public void delete(ServiceContract obj)
	{
		ServiceContractDaoInf.add(obj);
	}

	@Override
	public List<ServiceContract> getAll()
	{
		return ServiceContractDaoInf.getAll();
	}

	@Override
	public ServiceContract getById(Integer id)
	{
		return ServiceContractDaoInf.getById(id);
	}

}

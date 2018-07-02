package com.apartment.management.service.imp.contract;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.apartment.management.dao.interfaces.contract.AdvertisingContractDaoInf;
import com.apartment.management.model.contract.AdvertisingContract;
import com.apartment.management.service.interfaces.contract.AdvertisingContractService;

@Component
@Service
@Transactional
public class AdvertisingContractServiceImp implements
		AdvertisingContractService
{
	@Autowired
	private AdvertisingContractDaoInf advertisingContractDaoInf;

	@Override
	public void add(AdvertisingContract obj)
	{
		advertisingContractDaoInf.add(obj);
	}

	@Override
	public void update(AdvertisingContract obj)
	{
		advertisingContractDaoInf.update(obj);
	}

	@Override
	public void delete(AdvertisingContract obj)
	{
		advertisingContractDaoInf.delete(obj);
	}

	@Override
	public List<AdvertisingContract> getAll()
	{
		return advertisingContractDaoInf.getAll();
	}

	@Override
	public AdvertisingContract getById(Integer id)
	{
		return advertisingContractDaoInf.getById(id);
	}

}

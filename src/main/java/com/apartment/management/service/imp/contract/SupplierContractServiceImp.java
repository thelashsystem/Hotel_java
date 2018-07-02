package com.apartment.management.service.imp.contract;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.apartment.management.dao.interfaces.contract.SupplierContractDaoInf;
import com.apartment.management.model.contract.SupplyContract;
import com.apartment.management.service.interfaces.contract.SupplierContractService;

@Component
@Service
@Transactional
public class SupplierContractServiceImp implements SupplierContractService
{
	@Autowired
	private SupplierContractDaoInf supplierContractDaoInf;

	@Override
	public void add(SupplyContract obj)
	{
		supplierContractDaoInf.add(obj);
	}

	@Override
	public void update(SupplyContract obj)
	{
		supplierContractDaoInf.update(obj);
	}

	@Override
	public void delete(SupplyContract obj)
	{
		supplierContractDaoInf.delete(obj);
	}

	@Override
	public List<SupplyContract> getAll()
	{
		return supplierContractDaoInf.getAll();
	}

	@Override
	public SupplyContract getById(Integer id)
	{
		return supplierContractDaoInf.getById(id);
	}

}

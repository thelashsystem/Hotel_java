package com.apartment.management.service.imp.contract;

import java.util.List;

import com.apartment.management.dao.imp.contract.ContractDao;
import com.apartment.management.model.contract.Contract;
import com.apartment.management.service.interfaces.contract.ContractService;

//@Component
//@Service
//@Transactional
public abstract class ContractServiceImp<T extends Contract> implements
		ContractService<T>
{
	// @Autowired
	private ContractDao<T> contractDao;

	@Override
	public void add(T contract)
	{
		contractDao.add(contract);
	}

	@Override
	public void update(T contract)
	{
		contractDao.update(contract);
	}

	@Override
	public void delete(T contract)
	{
		contractDao.delete(contract);
	}

	@Override
	public List<T> getAll()
	{
		return contractDao.getAll();
	}

	@Override
	public T getById(Integer id)
	{
		return contractDao.getById(id);
	}

}

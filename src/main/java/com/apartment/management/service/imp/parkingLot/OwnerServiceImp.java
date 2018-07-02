package com.apartment.management.service.imp.parkingLot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apartment.management.dao.imp.parkingLot.OwnerDao;
import com.apartment.management.model.parkingLot.Owner;
import com.apartment.management.service.interfaces.parkingLot.OwnerService;

@Component
@Service
@Transactional
public class OwnerServiceImp implements OwnerService
{
	@Autowired
	private OwnerDao ownerDao;

	@Override
	public void add(Owner owner)
	{
		ownerDao.add(owner);
	}

	@Override
	public void update(Owner owner)
	{
		ownerDao.update(owner);
	}

	@Override
	public void delete(Owner owner)
	{
		ownerDao.delete(owner);
	}

	@Override
	public List<Owner> getAll()
	{
		return ownerDao.getAll();
	}

	@Override
	public Owner getById(Integer id)
	{
		return ownerDao.getById(id);
	}

}

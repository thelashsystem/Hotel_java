package com.apartment.management.service.imp.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apartment.management.dao.interfaces.business.GuestDaoInf;
import com.apartment.management.model.business.Guest;
import com.apartment.management.service.interfaces.business.GuestService;

@Component
@Service
@Transactional
public class GuestServiceImp implements GuestService
{
	@Autowired
	private GuestDaoInf guestDao;

	@Override
	public void add(Guest guest)
	{
		guestDao.add(guest);
	}

	@Override
	public void update(Guest guest)
	{
		guestDao.update(guest);
	}

	@Override
	public void delete(Guest guest)
	{
		guestDao.delete(guest);
	}

	@Override
	public List<Guest> getAll()
	{
		return guestDao.getAll();
	}

	@Override
	public Guest getById(Long id)
	{
		return guestDao.getById(id);
	}

}

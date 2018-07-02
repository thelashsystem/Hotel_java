package com.apartment.management.service.imp.parkingLot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apartment.management.dao.imp.parkingLot.TransportDao;
import com.apartment.management.model.parkingLot.Transport;
import com.apartment.management.service.interfaces.parkingLot.TransportService;

@Component
@Service
@Transactional
public class TransportServiceImp<T extends Transport> implements
		TransportService<T>
{
	@Autowired
	private TransportDao<T> transportDao;

	@Override
	public void add(T transport)
	{
		transportDao.add(transport);
	}

	@Override
	public void update(T transport)
	{
		transportDao.update(transport);
	}

	@Override
	public void delete(T transport)
	{
		transportDao.delete(transport);
	}

	@Override
	public List<T> getAll()
	{
		return transportDao.getAll();
	}

	@Override
	public T getById(Integer id)
	{
		return transportDao.getById(id);
	}

}

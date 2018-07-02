package com.apartment.management.service.imp.status;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apartment.management.dao.imp.status.StatusDao;
import com.apartment.management.model.status.Status;
import com.apartment.management.service.interfaces.status.StatusService;

@Component
@Service
@Transactional
public class StatusServiceImp implements StatusService
{
	@Autowired
	private StatusDao statusDao;

	@Override
	public void add(Status status)
	{
		statusDao.add(status);
	}

	@Override
	public void update(Status status)
	{
		statusDao.update(status);
	}

	@Override
	public void delete(Status status)
	{
		statusDao.delete(status);
	}

	@Override
	public List<Status> getAll()
	{
		return statusDao.getAll();
	}

	@Override
	public Status getById(Byte id)
	{
		return statusDao.getById(id);
	}
}

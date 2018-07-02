package com.apartment.management.service.imp.building;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apartment.management.dao.interfaces.building.IconDaoInf;
import com.apartment.management.model.building.Icon;
import com.apartment.management.service.interfaces.building.IconService;

@Component
@Service
@Transactional
public class IconServiceImp implements IconService
{
	@Autowired
	private IconDaoInf iconDao;

	@Override
	public void add(Icon icon)
	{
		iconDao.add(icon);
	}

	@Override
	public void update(Icon icon)
	{
		iconDao.update(icon);
	}

	@Override
	public void delete(Icon icon)
	{
		iconDao.delete(icon);
	}

	@Override
	public List<Icon> getAll()
	{
		return iconDao.getAll();
	}

	@Override
	public Icon getById(Short id)
	{
		return iconDao.getById(id);
	}

}

package com.apartment.management.service.imp.asset;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apartment.management.dao.interfaces.asset.EquipmentDaoInf;
import com.apartment.management.model.asset.Equipment;
import com.apartment.management.service.interfaces.asset.EquipmentService;

@Component
@Service
@Transactional
public class EquipmentServiceImp implements EquipmentService
{
	@Autowired
	private EquipmentDaoInf equipmentDao;

	@Override
	public void add(Equipment equipment)
	{
		equipmentDao.add(equipment);
	}

	@Override
	public void update(Equipment equipment)
	{
		equipmentDao.update(equipment);
	}

	@Override
	public void delete(Equipment equipment)
	{
		equipmentDao.delete(equipment);
	}

	@Override
	public List<Equipment> getAll()
	{
		return equipmentDao.getAll();
	}

	@Override
	public Equipment getById(Integer id)
	{
		return equipmentDao.getById(id);
	}

}

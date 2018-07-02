package com.apartment.management.service.imp.asset;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apartment.management.dao.interfaces.asset.SupplierEquipmentDaoInf;
import com.apartment.management.model.asset.SupplierEquipment;
import com.apartment.management.service.interfaces.asset.SupplierEquipmentService;

@Component
@Service
@Transactional
public class SupplierEquipmentServiceImp implements SupplierEquipmentService
{
	@Autowired
	private SupplierEquipmentDaoInf supplierEquipmentDao;

	@Override
	public void add(SupplierEquipment supplierEquipment)
	{
		supplierEquipmentDao.add(supplierEquipment);
	}

	@Override
	public void update(SupplierEquipment supplierEquipment)
	{
		supplierEquipmentDao.update(supplierEquipment);
	}

	@Override
	public void delete(SupplierEquipment supplierEquipment)
	{
		supplierEquipmentDao.delete(supplierEquipment);
	}

	@Override
	public List<SupplierEquipment> getAll()
	{
		return supplierEquipmentDao.getAll();
	}

	@Override
	public SupplierEquipment getById(Integer id)
	{
		return supplierEquipmentDao.getById(id);
	}

}

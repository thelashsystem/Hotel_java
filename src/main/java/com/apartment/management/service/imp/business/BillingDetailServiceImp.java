package com.apartment.management.service.imp.business;

import java.util.List;

import com.apartment.management.dao.imp.business.BillingDetailDao;
import com.apartment.management.model.business.BillingDetail;
import com.apartment.management.service.interfaces.business.BillingDetailService;

//@Component
//@Service
//@Transactional
public abstract class BillingDetailServiceImp<T extends BillingDetail>
		implements BillingDetailService<T>
{
	// @Autowired
	private BillingDetailDao<T> billDetailDao;

	@Override
	public void add(T billDetail)
	{
		billDetailDao.add(billDetail);
	}

	@Override
	public void update(T billDetail)
	{
		billDetailDao.update(billDetail);
	}

	@Override
	public void delete(T billDetail)
	{
		billDetailDao.delete(billDetail);
	}

	@Override
	public List<T> getAll()
	{
		return billDetailDao.getAll();
	}

	@Override
	public T getById(Long id)
	{
		return billDetailDao.getById(id);
	}

}

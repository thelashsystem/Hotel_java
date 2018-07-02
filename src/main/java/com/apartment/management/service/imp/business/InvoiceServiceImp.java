package com.apartment.management.service.imp.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apartment.management.dao.interfaces.business.InvoiceDaoInf;
import com.apartment.management.model.business.Invoice;
import com.apartment.management.service.interfaces.business.InvoiceService;

@Component
@Service
@Transactional
public class InvoiceServiceImp implements InvoiceService
{
	@Autowired
	private InvoiceDaoInf invoiceDao;

	@Override
	public void add(Invoice invoice)
	{
		invoiceDao.add(invoice);
	}

	@Override
	public void update(Invoice invoice)
	{
		invoiceDao.update(invoice);
	}

	@Override
	public void delete(Invoice invoice)
	{
		invoiceDao.delete(invoice);
	}

	@Override
	public List<Invoice> getAll()
	{
		return invoiceDao.getAll();
	}

	@Override
	public Invoice getById(Long id)
	{
		return invoiceDao.getById(id);
	}

}

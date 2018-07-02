package com.apartment.management.service.imp.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.apartment.management.dao.interfaces.business.BillingDaoInf;
import com.apartment.management.model.building.ApartmentType;
import com.apartment.management.model.building.Service;
import com.apartment.management.model.business.ApartmentBilling;
import com.apartment.management.model.business.ApartmentTypePrice;
import com.apartment.management.model.business.Billing;
import com.apartment.management.model.business.RegisterService;
import com.apartment.management.model.business.Resource;
import com.apartment.management.model.business.ResourceBilling;
import com.apartment.management.model.business.ResourcePrice;
import com.apartment.management.model.business.ServiceBilling;
import com.apartment.management.model.business.ServicePrice;
import com.apartment.management.model.contract.CustomerContract;
import com.apartment.management.service.interfaces.building.ServiceService;
import com.apartment.management.service.interfaces.business.ApartmentBillingService;
import com.apartment.management.service.interfaces.business.ApartmentTypePriceService;
import com.apartment.management.service.interfaces.business.BillingService;
import com.apartment.management.service.interfaces.business.RegisterServiceService;
import com.apartment.management.service.interfaces.business.ResourceBillingService;
import com.apartment.management.service.interfaces.business.ResourcePriceService;
import com.apartment.management.service.interfaces.business.ResourceService;
import com.apartment.management.service.interfaces.business.ServiceBillingService;
import com.apartment.management.service.interfaces.business.ServicePriceService;
import com.apartment.management.service.interfaces.contract.CustomerContractService;

@Component
@org.springframework.stereotype.Service
@Transactional
public class BillingServiceImp implements BillingService
{
	@Autowired
	private BillingDaoInf billDao;

	@Autowired
	private ApartmentBillingService roomBillingService;

	@Autowired
	private ServiceBillingService serviceBillingService;

	@Autowired
	private ResourceBillingService resourceBillingService;

	@Autowired
	private ResourceService resourceService;

	@Autowired
	private ServiceService serviceService;

	@Autowired
	private CustomerContractService customerContractService;

	@Autowired
	private RegisterServiceService registerServiceService;

	@Autowired
	private ResourcePriceService resourcePriceService;

	@Autowired
	private ServicePriceService servicePriceService;

	@Autowired
	private ApartmentTypePriceService apartmentTypePriceService;

	private Random random;

	@Override
	public void add(Billing bill)
	{
		billDao.add(bill);
	}

	@Override
	public void update(Billing bill)
	{
		billDao.update(bill);
	}

	@Override
	public void delete(Billing bill)
	{
		billDao.delete(bill);
	}

	@Override
	public List<Billing> getAll()
	{
		return billDao.getAll();
	}

	@Override
	public Billing getById(Integer id)
	{
		return billDao.getById(id);
	}

	@Override
	public Billing createdBilling(CustomerContract customerContract)
	{
		random = new Random();
		Integer id = billDao.createBilling(customerContract);
		Billing billing = getById(id);
		Double totalPrice = 0.0;

		List<ApartmentBilling> listRoomBilling = new ArrayList<>();
		List<ResourceBilling> listResourceBilling = new ArrayList<>();
		List<ServiceBilling> listServiceBilling = new ArrayList<>();

		ApartmentType apartmentType = customerContract.getBookingApartment()
				.getApartment().getApartmentType();
		ApartmentTypePrice roomTypePrice = apartmentTypePriceService
				.getLastestApartmentTypePrice(apartmentType);
		Double roomPrice = roomTypePrice.getPrice();
		ApartmentBilling roomBilling = new ApartmentBilling();
		roomBilling.setBilling(billing);
		roomBilling.setApartmentTypePrice(roomTypePrice);
		roomBilling.setSubPrice(roomPrice);
		listRoomBilling.add(roomBilling);
		totalPrice += roomPrice;
		roomBillingService.add(roomBilling);

		List<Resource> resources = resourceService.getAll();

		for ( Resource resource : resources )
		{
			ResourcePrice resourcePrice = resourcePriceService
					.getLastestResourcePrice(resource);
			ResourceBilling resourceBilling = new ResourceBilling();
			resourceBilling.setBilling(billing);
			resourceBilling.setResourcePrice(resourcePrice);
			Integer quantity = random.nextInt(100);
			resourceBilling.setQuantity(quantity);
			Double subPrice = quantity * resourcePrice.getPrice();
			resourceBilling.setSubPrice(subPrice);
			listResourceBilling.add(resourceBilling);
			totalPrice += subPrice;
			resourceBillingService.add(resourceBilling);
		}

		List<RegisterService> listRegisteredService = registerServiceService
				.getUnexpiredRegisteredService();
		for ( RegisterService registerService : listRegisteredService )
		{
			Service service = registerService.getService();
			ServiceBilling serviceBilling = new ServiceBilling();
			ServicePrice servicePrice = servicePriceService
					.getLastestServicePrice(service);
			Double subServicePrice = servicePrice.getPrice();
			serviceBilling.setServicePrice(servicePrice);
			serviceBilling.setBilling(billing);
			serviceBilling.setSubPrice(subServicePrice);
			listServiceBilling.add(serviceBilling);
			totalPrice += subServicePrice;
			serviceBillingService.add(serviceBilling);
		}
		billing.setTotalPrice(totalPrice);
		billDao.add(billing);
		return billing;
	}

	@Override
	public List<Billing> createdBillings()
	{
		List<Billing> listBilling = new ArrayList<>();
		List<CustomerContract> listCustomerContract = customerContractService
				.getUnexpiredContract();
		for ( CustomerContract customerContract : listCustomerContract )
		{
			listBilling.add(createdBilling(customerContract));
		}
		return listBilling;
	}

}

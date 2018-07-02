package com.apartment.management.dao.imp.person;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.person.CustomerDaoInf;
import com.apartment.management.model.person.Customer;

@Component
@Repository
public class CustomerDao extends PersonDao<Customer> implements CustomerDaoInf
{
	public CustomerDao()
	{
		super(Customer.class);
	}
}

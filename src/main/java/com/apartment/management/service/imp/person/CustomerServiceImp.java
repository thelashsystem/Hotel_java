package com.apartment.management.service.imp.person;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apartment.management.model.person.Customer;
import com.apartment.management.service.interfaces.person.CustomerService;

@Component
@Service
@Transactional
public class CustomerServiceImp extends PersonServiceImp<Customer> implements
		CustomerService
{

}

package com.apartment.management.dao.imp.business;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.business.ServiceBillingDaoInf;
import com.apartment.management.model.business.ServiceBilling;

@Component
@Repository
public class ServiceBillingDao extends BillingDetailDao<ServiceBilling>
		implements ServiceBillingDaoInf
{

}

package com.apartment.management.dao.imp.business;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.business.ResourceBillingDaoInf;
import com.apartment.management.model.business.ResourceBilling;

@Component
@Repository
public class ResourceBillingDao extends BillingDetailDao<ResourceBilling>
		implements ResourceBillingDaoInf
{

}

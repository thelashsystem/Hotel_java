package com.apartment.management.dao.imp.business;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.business.ApartmentBillingDaoInf;
import com.apartment.management.model.business.ApartmentBilling;

@Component
@Repository
public class ApartmentBillingDao extends BillingDetailDao<ApartmentBilling>
		implements ApartmentBillingDaoInf
{

}

package com.apartment.management.dao.imp.contract;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apartment.management.dao.interfaces.contract.CustomerContractDaoInf;
import com.apartment.management.model.contract.CustomerContract;

@Component
@Repository
public class CustomerContractDao extends ContractDao<CustomerContract>
		implements CustomerContractDaoInf
{

	@Override
	public List<CustomerContract> getUnexpiredContract()
	{
		return getUnexpiredContract(new Date());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CustomerContract> getUnexpiredContract(Date currentDate)
	{
		String hSql = "select c from CustomerContract c where c.expiredDate > :currentDate";
		Query query = session().createQuery(hSql);
		query.setParameter("currentDate", currentDate);
		return query.list();

	}

}

package com.apartment.management.model.contract;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.apartment.management.model.account.EmployeeAccount;
import com.apartment.management.model.asset.SupplierEquipment;
import com.apartment.management.model.provider.Supplier;

@Entity
@Table(name = "Supplier_Contract")
public class SupplyContract extends Contract
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne(cascade = CascadeType.ALL)
	private Supplier supplier;
	@OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
	private List<SupplierEquipment> suppliers;
	@ManyToOne(cascade = CascadeType.ALL)
	private EmployeeAccount employee;

	public SupplyContract()
	{
	}

	public Supplier getSupplier()
	{
		return supplier;
	}

	public void setSupplier(Supplier supplier)
	{
		this.supplier = supplier;
	}

	public List<SupplierEquipment> getSuppliers()
	{
		return suppliers;
	}

	public void setSuppliers(List<SupplierEquipment> suppliers)
	{
		this.suppliers = suppliers;
	}

	public EmployeeAccount getEmployee()
	{
		return employee;
	}

	public void setEmployee(EmployeeAccount employee)
	{
		this.employee = employee;
	}

}

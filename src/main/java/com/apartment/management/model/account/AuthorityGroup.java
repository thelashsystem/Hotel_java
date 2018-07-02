package com.apartment.management.model.account;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "AuthorityGroup")
public class AuthorityGroup implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Short id;
	@Column(nullable = false, unique = true, length = 50)
	private String name;
	@Column(columnDefinition = "text")
	private String description;
	@ManyToMany(mappedBy = "authorities", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Permission> permissions;
	@OneToMany(mappedBy = "authorityGroup", cascade = CascadeType.ALL)
	private Set<CustomerAccount> customerAccount;
	@OneToMany(mappedBy = "authorityGroup", cascade = CascadeType.ALL)
	private Set<EmployeeAccount> employeeAccount;
	private Integer status;
	@Transient
	private Map<Integer, String> statusReferences;

	public AuthorityGroup()
	{
		statusReferences = new TreeMap<>();
		statusReferences.put(0, "Available");
		statusReferences.put(1, "Not Available");
		statusReferences.put(2, "Hidden");
	}

	public Short getId()
	{
		return id;
	}

	public void setId(Short id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public Set<Permission> getPermissions()
	{
		return permissions;
	}

	public void setPermissions(Set<Permission> permissions)
	{
		this.permissions = permissions;
	}

	public Set<CustomerAccount> getCustomerAccount()
	{
		return customerAccount;
	}

	public void setCustomerAccount(Set<CustomerAccount> customerAccount)
	{
		this.customerAccount = customerAccount;
	}

	public Set<EmployeeAccount> getEmployeeAccount()
	{
		return employeeAccount;
	}

	public void setEmployeeAccount(Set<EmployeeAccount> employeeAccount)
	{
		this.employeeAccount = employeeAccount;
	}

	public String getStatus()
	{
		return statusReferences.get(status);
	}

	public void setStatus(Integer status)
	{
		this.status = status;
	}

}

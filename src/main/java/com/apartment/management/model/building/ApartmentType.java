package com.apartment.management.model.building;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.apartment.management.model.business.ApartmentTypePrice;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ApartmentType")
public class ApartmentType implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Short id;
	@Column(length = 50)
	private String name;
	@Column(nullable = false, unique = true, length = 30)
	private String code;
	@Fetch(FetchMode.SELECT)
	@OrderBy(value = "updatedDate desc")
	@OneToMany(mappedBy = "apartmentType", cascade = CascadeType.ALL)
	private List<ApartmentTypePrice> prices;
	private String description;
	private Integer orderNum;
	private boolean isHot;
	private boolean isNew;
	private Double depositPercentageRate;
	@Fetch(FetchMode.SELECT)
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "apartmentType", cascade = CascadeType.ALL)
	@OrderBy(value = "orderNum")
	private Set<CriteriaApartmentType> criterias;
	@OneToMany(mappedBy = "apartmentType", cascade = CascadeType.ALL)
	private List<Apartment> apartment;
	private Integer status;
	@Transient
	private Map<Integer, String> statusReferences;
	private Double price;
	private Integer maxNumGuest;

	public ApartmentType()
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

	public Integer getOrderNum()
	{
		return orderNum;
	}

	public void setOrderNum(Integer orderNum)
	{
		this.orderNum = orderNum;
	}

	public boolean isHot()
	{
		return isHot;
	}

	public void setHot(boolean isHot)
	{
		this.isHot = isHot;
	}

	public boolean isNew()
	{
		return isNew;
	}

	public void setNew(boolean isNew)
	{
		this.isNew = isNew;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	@JsonIgnore
	public Set<CriteriaApartmentType> getCriterias()
	{
		return criterias;
	}

	public void setCriterias(Set<CriteriaApartmentType> criterias)
	{
		this.criterias = criterias;
	}

	@JsonIgnore
	public List<ApartmentTypePrice> getPrices()
	{
		return prices;
	}

	public void setPrices(List<ApartmentTypePrice> prices)
	{
		this.prices = prices;
	}

	@JsonIgnore
	public List<Apartment> getApartment()
	{
		return apartment;
	}

	public void setApartment(List<Apartment> apartment)
	{
		this.apartment = apartment;
	}

	public String getStatus()
	{
		return statusReferences.get(status);
	}

	public void setStatus(Integer status)
	{
		this.status = status;
	}

	public Double getDepositPercentageRate()
	{
		return depositPercentageRate;
	}

	public void setDepositPercentageRate(Double depositPercentageRate)
	{
		this.depositPercentageRate = depositPercentageRate;
	}

	public Double getPrice()
	{
		return price;
	}

	public void setPrice(Double price)
	{
		this.price = price;
	}

	public Integer getMaxNumGuest()
	{
		return maxNumGuest;
	}

	public void setMaxNumGuest(Integer maxNumGuest)
	{
		this.maxNumGuest = maxNumGuest;
	}

}

package com.apartment.management.model.business;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.apartment.management.model.building.Apartment;
import com.apartment.management.model.contract.CustomerContract;
import com.apartment.management.model.person.Customer;
import com.apartment.management.model.person.Receptionist;

@Entity
@Table(name = "BookingApartment")
public class BookingApartment implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(columnDefinition = "datetime")
	private Timestamp bookingDate;
	private Date checkin;
	private Date checkout;
	@ManyToOne(cascade = CascadeType.ALL)
	private Customer customer;
	@ManyToOne(cascade = CascadeType.ALL)
	private Receptionist receptionist;
	@OneToMany(mappedBy = "bookingApartment", cascade = CascadeType.ALL)
	private List<CustomerContract> customerContract;
	@OneToMany(mappedBy = "bookingApartment", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Guest> guests;
	private Integer status;
	@Transient
	private Map<Integer, String> statusReferences;
	@ManyToOne(cascade = CascadeType.ALL)
	private Apartment apartment;

	public BookingApartment()
	{
		statusReferences = new TreeMap<>();
		statusReferences.put(0, "Available");
		statusReferences.put(1, "Not Available");
		statusReferences.put(2, "Hidden");
		statusReferences.put(3, "Pending");
		statusReferences.put(4, "Cancel");
		statusReferences.put(5, "Signed");
		statusReferences.put(6, "Expired");
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Date getCheckin()
	{
		return checkin;
	}

	public void setCheckin(Date checkin)
	{
		this.checkin = checkin;
	}

	public Date getCheckout()
	{
		return checkout;
	}

	public void setCheckout(Date checkout)
	{
		this.checkout = checkout;
	}

	public Customer getCustomer()
	{
		return customer;
	}

	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}

	public Receptionist getReceptionist()
	{
		return receptionist;
	}

	public void setReceptionist(Receptionist receptionist)
	{
		this.receptionist = receptionist;
	}

	public List<CustomerContract> getCustomerContract()
	{
		return customerContract;
	}

	public void setCustomerContract(List<CustomerContract> customerContract)
	{
		this.customerContract = customerContract;
	}

	public List<Guest> getGuests()
	{
		return guests;
	}

	public void setGuests(List<Guest> guests)
	{
		this.guests = guests;
	}

	public String getStatus()
	{
		return statusReferences.get(status);
	}

	public void setStatus(Integer status)
	{
		this.status = status;
	}

	public Timestamp getBookingDate()
	{
		return bookingDate;
	}

	public void setBookingDate(Timestamp bookingDate)
	{
		this.bookingDate = bookingDate;
	}

	public Apartment getApartment()
	{
		return apartment;
	}

	public void setApartment(Apartment apartment)
	{
		this.apartment = apartment;
	}

}

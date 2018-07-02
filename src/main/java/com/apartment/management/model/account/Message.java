package com.apartment.management.model.account;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Message")
public class Message implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(columnDefinition = "datetime")
	private Timestamp date;
	@Column(length = 100)
	private String subject;
	@Column(columnDefinition = "text")
	private String content;
	@ManyToOne(cascade = CascadeType.ALL)
	private Message message;
	@ManyToOne(cascade = CascadeType.ALL)
	private CustomerAccount customerAccount;
	@ManyToOne(cascade = CascadeType.ALL)
	private EmployeeAccount employeeAccount;
	@OneToMany(mappedBy = "message", cascade = CascadeType.ALL)
	private Set<Message> feedback;
	private Integer status;
	@Transient
	private Map<Integer, String> statusReferences;

	public Message()
	{
		statusReferences = new TreeMap<>();
		statusReferences.put(0, "Available");
		statusReferences.put(1, "Not Available");
		statusReferences.put(2, "Hidden");
		statusReferences.put(1, "Pending");
		statusReferences.put(2, "Approved");
		
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Timestamp getDate()
	{
		return date;
	}

	public void setDate(Timestamp date)
	{
		this.date = date;
	}

	public String getSubject()
	{
		return subject;
	}

	public void setSubject(String subject)
	{
		this.subject = subject;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public CustomerAccount getCustomerAccount()
	{
		return customerAccount;
	}

	public void setCustomerAccount(CustomerAccount customerAccount)
	{
		this.customerAccount = customerAccount;
	}

	public Message getMessage()
	{
		return message;
	}

	public void setMessage(Message message)
	{
		this.message = message;
	}

	public Set<Message> getFeedback()
	{
		return feedback;
	}

	public void setFeedback(Set<Message> feedback)
	{
		this.feedback = feedback;
	}

	public String getStatus()
	{
		return statusReferences.get(status);
	}

	public void setStatus(Integer status)
	{
		this.status = status;
	}

	public EmployeeAccount getEmployeeAccount()
	{
		return employeeAccount;
	}

	public void setEmployeeAccount(EmployeeAccount employeeAccount)
	{
		this.employeeAccount = employeeAccount;
	}

}

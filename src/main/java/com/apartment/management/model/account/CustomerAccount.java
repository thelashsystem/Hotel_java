package com.apartment.management.model.account;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.apartment.management.model.news.Comment;
import com.apartment.management.model.person.Customer;

@Entity
@Table(name = "Customer_Account")
public class CustomerAccount extends Account
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean isActive;

	@ManyToOne(cascade = CascadeType.ALL)
	private Customer customer;
	@OneToMany(mappedBy = "customerAccount", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Message> messages;
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private Set<Comment> comment;
	private String activeCode;

	public CustomerAccount()
	{
	}

	public boolean isActive()
	{
		return isActive;
	}

	public void setActive(boolean isActive)
	{
		this.isActive = isActive;
	}

	public Customer getCustomer()
	{
		return customer;
	}

	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}

	public Set<Message> getMessages()
	{
		return messages;
	}

	public void setMessages(Set<Message> messages)
	{
		this.messages = messages;
	}

	public Set<Comment> getComment()
	{
		return comment;
	}

	public void setComment(Set<Comment> comment)
	{
		this.comment = comment;
	}

	public String getActiveCode()
	{
		return activeCode;
	}

	public void setActiveCode(String activeCode)
	{
		this.activeCode = activeCode;
	}

}

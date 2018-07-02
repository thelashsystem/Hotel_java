package com.apartment.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apartment.management.model.account.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>
{
	
}

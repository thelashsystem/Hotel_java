package com.apartment.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apartment.management.model.building.Service;

public interface ServiceRepository extends JpaRepository<Service, Short>
{

}

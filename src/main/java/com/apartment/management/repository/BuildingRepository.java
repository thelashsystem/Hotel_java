package com.apartment.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apartment.management.model.building.Building;

public interface BuildingRepository extends JpaRepository<Building, Short>
{

}

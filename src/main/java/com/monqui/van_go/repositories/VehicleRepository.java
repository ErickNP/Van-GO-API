package com.monqui.van_go.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monqui.van_go.entities.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>{

}

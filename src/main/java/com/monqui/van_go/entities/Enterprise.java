package com.monqui.van_go.entities;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.monqui.van_go.entities.location.Address;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_enterprise")
public class Enterprise extends User {
	private static final long serialVersionUID = 1L;

	private String cnpj;
	private boolean active = true;


	@OneToMany(mappedBy = "enterprise", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Driver> drivers;

	@OneToMany(mappedBy = "enterprise", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Vehicle> vehicles;

	public Enterprise() {
	}

	public Enterprise(Long id, String name, String email, String password, String telephone, Address address,
			String cnpj, List<Driver> drivers, List<Vehicle> vehicles) {
		super(id, name, email, password, telephone, address);
		this.cnpj = cnpj;
		this.drivers = drivers;
		this.vehicles = vehicles;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<Driver> getDrivers() {
		return drivers;
	}

	public void setDrivers(List<Driver> drivers) {
		this.drivers = drivers;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(super.getId());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Driver other = (Driver) obj;
		return Objects.equals(super.getId(), other.getId());
	}

}
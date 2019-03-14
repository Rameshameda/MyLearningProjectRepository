package com.springhibernate.bean;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
@Entity
public class Owner {
	@Id
	@GeneratedValue
	int id;
	//@NotFound(action=NotFoundAction.IGNORE)
	String name;
	@OneToMany(mappedBy="owner",cascade=CascadeType.PERSIST)
	//@JoinTable(name="owner_to_vehile", joinColumns= {@JoinColumn(name="owner_id_of_vehile")},inverseJoinColumns= {@JoinColumn(name="vehile_id_of_owner")})
	Collection<Vehicle> vehicle = new ArrayList<Vehicle>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Collection<Vehicle> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
	
}

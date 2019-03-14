package com.springhibernate.bean;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Movie {
	@Id
	@GeneratedValue
	int id;
	String name;
	@ManyToMany(cascade=CascadeType.ALL,mappedBy="movies")
	Collection<Producer> producers = new ArrayList<Producer>();
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
	public Collection<Producer> getProducers() {
		return producers;
	}
	public void setProducers(Collection<Producer> producers) {
		this.producers = producers;
	}

}

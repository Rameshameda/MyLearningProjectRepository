package com.springhibernate.bean;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Producer {
	@Id
	@GeneratedValue
	int id;
	String name;
	@ManyToMany(cascade=CascadeType.ALL)
	Collection<Movie> movies = new ArrayList<Movie>();
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
	public Collection<Movie> getMovies() {
		return movies;
	}
	public void setMovies(Collection<Movie> movies) {
		this.movies = movies;
	}
}

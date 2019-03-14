package com.springhibernate.bean;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
@SelectBeforeUpdate
@Table(name="TEST_BEAN")
@NamedQuery(name="TestBean.byId", query="from TestBean where id = :id")
@NamedNativeQuery(name="TestBean.byValue",query="select * from TEST_BEAN where testValue=:value",resultClass=TestBean.class)
public class TestBean {
	@Id
	@GeneratedValue
	int id;
	String testValue;
	public int getId() {
		return id;
	}
	public String getTestValue() {
		return testValue;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setTestValue(String testValue) {
		this.testValue = testValue;
	}
	@Override
	public String toString() {
		return "TestBean [id=" + id + ", testValue=" + testValue + "]";
	}

}

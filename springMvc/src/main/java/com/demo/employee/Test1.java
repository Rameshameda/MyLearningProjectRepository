package com.demo.employee;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
@Component
public class Test1 {
	@Autowired
	SessionFactory sessionFactory ;
	@Transactional
	public void test() {
		System.out.println("here inside"+sessionFactory.getCurrentSession().createSQLQuery("insert into customers (CUSTOMERID,CUSTOMERNAME,CONTACTNAME,ADDRESS,CITY,POSTALCODE,COUNTRY)  values (17,'Rameshameda','Rameshmeda','E-City','Banglore','560100','India')").executeUpdate());
	}
}

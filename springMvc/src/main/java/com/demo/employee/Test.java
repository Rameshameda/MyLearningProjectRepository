package com.demo.employee;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
@Component
public class Test {
	@Autowired
	SessionFactory sessionFactory ;
	@Autowired
	Test1 test1;
	@Transactional
	public void test() {
		System.out.println("here inside"+sessionFactory.getCurrentSession().createSQLQuery("insert into customers (CUSTOMERID,CUSTOMERNAME,CONTACTNAME,ADDRESS,CITY,POSTALCODE,COUNTRY)  values (18,'Rameshameda','Rameshmeda','E-City','Banglore','560100','India')").executeUpdate());
		test1.test();
	}
	@Transactional
	public void addemp(Employee employee) {
		// TODO Auto-generated method stub
sessionFactory.getCurrentSession().save(employee);
	}
}

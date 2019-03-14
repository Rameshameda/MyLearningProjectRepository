package com.springhibernate;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.springhibernate.bean.TestBean;
import com.springhibernate.conf.HibernateSessionFactory;

public class NamedQueries {
	public static void main(String[] args) {
		SessionFactory factory = HibernateSessionFactory.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query1 = session.getNamedQuery("TestBean.byId");
		//query1.setCacheable(true);
		query1.setInteger("id", 3);
		System.out.println(query1.list());
		Query query2 = session.getNamedQuery("TestBean.byValue");
		query2.setString("value", "new Value5");
		System.out.println(query2.list());
		
		
		Query query3 = session.getNamedQuery("TestBean.byId");
		//query3.setCacheable(true);
		query3.setInteger("id", 3);
		System.out.println(query1.list());
		
		
		System.out.println(session.get(TestBean.class, 5));
		System.out.println(session.get(TestBean.class, 5));
		System.out.println(session.get(TestBean.class, 5));
		
		
		transaction.commit();
		session.close();
	}
}

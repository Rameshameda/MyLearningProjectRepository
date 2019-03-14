package com.springhibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.springhibernate.bean.TestBean;
import com.springhibernate.conf.HibernateSessionFactory;

public class FirstLevelCache {
	public static void main(String[] args) {
		SessionFactory factory = HibernateSessionFactory.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		System.out.println(session.get(TestBean.class, 3));
		System.out.println(session.get(TestBean.class, 3));
		transaction.commit();
		session.close();
		
		  Session session2 = factory.openSession();
		  System.out.println(session2.get(TestBean.class, 3)); session2.close();
		 
	}
}

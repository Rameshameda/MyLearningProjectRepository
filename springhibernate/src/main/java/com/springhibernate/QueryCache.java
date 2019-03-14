package com.springhibernate;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.springhibernate.bean.TestBean;
import com.springhibernate.conf.HibernateSessionFactory;

public class QueryCache {
	public static void main(String[] args) {
		SessionFactory factory = HibernateSessionFactory.getSessionFactory();
		Session session1 = factory.openSession();
		Transaction transaction = session1.beginTransaction();
		Query query1 = session1.createQuery("from TestBean where id=3");
		query1.setCacheable(true);
		System.out.println(query1.list());
		transaction.commit();
		session1.close();
		Session session2 = factory.openSession();
		Query query2 = session2.createQuery("from TestBean where id=3");
		query2.setCacheable(true);
		System.out.println(query2.list());
		session2.close();
	}
}

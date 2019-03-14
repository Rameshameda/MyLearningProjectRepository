package com.springhibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.springhibernate.bean.TestBean;
import com.springhibernate.conf.HibernateSessionFactory;

public class SecoundLevelCache {
	public static void main(String[] args) {
		SessionFactory factory = HibernateSessionFactory.getSessionFactory();
		Session session1 = factory.openSession();
		Transaction transaction = session1.beginTransaction();
		System.out.println(session1.get(TestBean.class, 3));
		System.out.println(session1.get(TestBean.class, 3));
		transaction.commit();
		session1.close();
		Session session2 = factory.openSession();
		System.out.println(session2.get(TestBean.class, 3));
		session2.close();
	}
}

package com.springhibernate;


import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.springhibernate.bean.TestBean;
import com.springhibernate.conf.HibernateSessionFactory;

public class PaginationPropBinding {
	public static void main(String[] args) {
		SessionFactory factory = HibernateSessionFactory.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("select new map(id,testValue) from TestBean where id = :myId and testValue = :myValue");
		//pagination
		//query.setFirstResult(5);
		//query.setMaxResults(3);
		//? binding
		//query.setInteger(0, 13);
		//query.setString(1, "new Value10");
		
		query.setInteger("myId", 13);
		query.setString("myValue", "new Value10");
		List<Map<Integer, String>> testBeans = query.list();
		System.out.println(testBeans);
		transaction.commit();
		session.close();
		factory.close();
	}
}

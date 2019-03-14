package com.springhibernate;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.springhibernate.bean.TestBean;
import com.springhibernate.conf.HibernateSessionFactory;

public class CriteriaRestrictionProjectionsQueryByExample {
	public static void main(String[] args) {
		
		SessionFactory factory = HibernateSessionFactory.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(TestBean.class)
				.add(Restrictions.between("id", 5, 8));
		System.out.println(criteria.list());
		
		
		Criteria criteria2 = session.createCriteria(TestBean.class)
				.addOrder(Order.desc("id")).
				setProjection(Projections.count("id"));
		System.out.println(criteria2.list());
		
		TestBean bean = new TestBean();
		bean.setTestValue("new Value10");
		Example example = Example.create(bean);
		
		System.out.println(session.createCriteria(TestBean.class)
				.add(example).list());
		
		
		transaction.commit();
		session.close();
		
	}

}

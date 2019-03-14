package com.springhibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.springhibernate.bean.Subject;
import com.springhibernate.bean.Teacher;
import com.springhibernate.conf.HibernateSessionFactory;

public class OneToOne {
	public static void main(String[] args) {
		SessionFactory factory = HibernateSessionFactory.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Subject subject = new Subject();
		subject.setName("maths");
		Teacher teacher = new Teacher();
		teacher.setName("mouna");
		teacher.setSubject(subject);
		//session.save(subject);
		session.save(teacher);
		transaction.commit();
		session.close();
		factory.close();
		
	}
}

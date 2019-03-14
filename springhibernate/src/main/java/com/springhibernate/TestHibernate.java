package com.springhibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.springhibernate.bean.Address;
import com.springhibernate.bean.Person;
import com.springhibernate.conf.HibernateSessionFactory;

public class TestHibernate {
	
	public static void main(String[] args) {

		SessionFactory factory = HibernateSessionFactory.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Address address = new Address("Flat No S-07", "Manifest White Orchid,A Block", "celebrity main road", "doddathoguru", "Banglore", "Karnataka");
		List<String> hobbies = new ArrayList<String>();
		hobbies.add("Youtube");
		hobbies.add("NetFlix");
		hobbies.add("PrimeVideo");
		Person person = new Person("Ramesha", "Vishwanataha", "Meda", hobbies, address);
		session.save(person);
		transaction.commit();
		session.close();
		factory.close();
		System.out.println("Task Finished");
		
		
	}

}

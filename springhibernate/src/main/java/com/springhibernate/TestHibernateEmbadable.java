package com.springhibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.springhibernate.bean.Address;
import com.springhibernate.bean.Person;
import com.springhibernate.bean.Student;
import com.springhibernate.bean.User;
import com.springhibernate.conf.HibernateSessionFactory;

public class TestHibernateEmbadable {

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

		User p= new User("naresh", "rai"); 
		Student s= new Student(p, "varanasi");
		session.save(s);

		transaction.commit();
		Person person1 = (Person) session.get(Person.class, 2);
		System.out.println(person1.getHobbies());

		session.close();
		System.out.println("Task Finished");


	}

}

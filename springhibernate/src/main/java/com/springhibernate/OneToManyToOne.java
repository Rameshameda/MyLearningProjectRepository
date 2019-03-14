package com.springhibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.springhibernate.bean.Owner;
import com.springhibernate.bean.Vehicle;
import com.springhibernate.conf.HibernateSessionFactory;

public class OneToManyToOne {
	public static void main(String[] args) {
		SessionFactory factory = HibernateSessionFactory.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Owner owner = new Owner();
		owner.setName("Rameshmeda");
		
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setName("Jazz");
		vehicle1.setOwner(owner);

		Vehicle vehicle2 = new Vehicle();
		vehicle2.setName("Civic");
		vehicle2.setOwner(owner);
		
		owner.getVehicle().add(vehicle1);
		owner.getVehicle().add(vehicle2);
		
		session.persist(owner);
		/*
		 * session.save(vehicle1); session.save(vehicle2);
		 */
		transaction.commit();
		session.close();
	}
}

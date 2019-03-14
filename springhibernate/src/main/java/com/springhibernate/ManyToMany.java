package com.springhibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.springhibernate.bean.Movie;
import com.springhibernate.bean.Producer;
import com.springhibernate.conf.HibernateSessionFactory;
public class ManyToMany {
	public static void main(String[] args) {
		SessionFactory factory = HibernateSessionFactory.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Movie movie1 = new Movie();
		Movie movie2 = new Movie();
		Producer producer1 = new Producer();
		Producer producer2 = new Producer();
		
		movie1.setName("Ah ah");
		movie2.setName("oh oh");
		
		producer1.setName("rameshmeda");
		producer2.setName("rajendra");
		
		movie1.getProducers().add(producer1);
		movie1.getProducers().add(producer2);
		
		producer1.getMovies().add(movie1);
		producer1.getMovies().add(movie2);
		
		movie2.getProducers().add(producer1);
		movie2.getProducers().add(producer2);
		
		producer2.getMovies().add(movie1);
		producer2.getMovies().add(movie2);
		
		session.persist(producer1);
		session.persist(producer2);
		transaction.commit();
		session.close();
		factory.close();
	}

}

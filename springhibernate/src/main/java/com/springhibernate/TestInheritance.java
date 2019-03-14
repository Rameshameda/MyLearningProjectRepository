package com.springhibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.springhibernate.bean.Engine;
import com.springhibernate.bean.FourStrokeEngine;
import com.springhibernate.bean.TwoStrokeEngine;
import com.springhibernate.conf.HibernateSessionFactory;

public class TestInheritance {
	public static void main(String[] args) {
		SessionFactory factory = HibernateSessionFactory.getSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Engine engine = new Engine();
		engine.setName("genaral engine");
		FourStrokeEngine fourStrokeEngine = new FourStrokeEngine();
		fourStrokeEngine.setTwoCycles("in compress expand exast");
		fourStrokeEngine.setName("BS V 4 stroke engine");
		
		TwoStrokeEngine twoStrokeEngine = new TwoStrokeEngine();
		twoStrokeEngine.setName("BS I 2 Stroke Engine");
		twoStrokeEngine.setFourCycles("in out");
		
		session.save(engine);
		session.save(fourStrokeEngine);
		session.save(twoStrokeEngine);
		transaction.commit();
		session.close();
		factory.close();
		
	}

}

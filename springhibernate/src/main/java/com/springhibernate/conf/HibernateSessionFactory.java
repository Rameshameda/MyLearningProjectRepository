package com.springhibernate.conf;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.springhibernate.bean.Address;
import com.springhibernate.bean.Engine;
import com.springhibernate.bean.FourStrokeEngine;
import com.springhibernate.bean.Movie;
import com.springhibernate.bean.Owner;
import com.springhibernate.bean.Person;
import com.springhibernate.bean.Producer;
import com.springhibernate.bean.Student;
import com.springhibernate.bean.Subject;
import com.springhibernate.bean.Teacher;
import com.springhibernate.bean.TestBean;
import com.springhibernate.bean.TwoStrokeEngine;
import com.springhibernate.bean.User;
import com.springhibernate.bean.Vehicle;

public class HibernateSessionFactory {
	public static SessionFactory getSessionFactory() {
		Properties properties = new Properties();
		properties.put(Environment.URL, "jdbc:oracle:thin:@//localhost:1521/TestDatabase");
		properties.put(Environment.USER, "SYSTEM");
		properties.put(Environment.PASS, "meDA#1989");
		properties.put(Environment.DRIVER, "oracle.jdbc.OracleDriver");
		properties.put(Environment.DIALECT, "org.hibernate.dialect.Oracle10gDialect");
		properties.put(Environment.HBM2DDL_AUTO, "create");
		properties.put(Environment.SHOW_SQL, "true");
		properties.put(Environment.USE_SECOND_LEVEL_CACHE, "true");
		properties.put(Environment.USE_QUERY_CACHE, "true");
		properties.put(Environment.CACHE_REGION_FACTORY, "org.hibernate.cache.ehcache.EhCacheRegionFactory");

		Configuration configuration = new Configuration();
		configuration.addProperties(properties);
		//configuration.setNamingStrategy(ImprovedNamingStrategy.INSTANCE);
		
		configuration.addAnnotatedClass(Person.class);
		configuration.addAnnotatedClass(Student.class);
		configuration.addAnnotatedClass(Address.class);
		configuration.addAnnotatedClass(Subject.class);
		configuration.addAnnotatedClass(Teacher.class);
		configuration.addAnnotatedClass(User.class);
		configuration.addAnnotatedClass(Owner.class);
		configuration.addAnnotatedClass(Vehicle.class);
		configuration.addAnnotatedClass(Producer.class);
		configuration.addAnnotatedClass(Movie.class);
		configuration.addAnnotatedClass(Engine.class);
		configuration.addAnnotatedClass(TwoStrokeEngine.class);
		configuration.addAnnotatedClass(FourStrokeEngine.class);
		configuration.addAnnotatedClass(TestBean.class);
		
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
		builder.applySettings(configuration.getProperties());

		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		return factory;
	}

}

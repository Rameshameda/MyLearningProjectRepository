package com.example.hibernate;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.cfg.ImprovedNamingStrategy;

import com.example.hibernate.bean.EmployeeBean;

/**
 * Hello world!
 *
 */
public class App {
	public static void main( String[] args ) {

		Properties settings = new Properties();
		settings.put(Environment.DRIVER, "oracle.jdbc.OracleDriver");
		settings.put(Environment.URL, "jdbc:oracle:thin:@//localhost:1521/TestDatabase");
		settings.put(Environment.USER, "SYSTEM");
		settings.put(Environment.PASS, "meDA#1989");
		settings.put(Environment.DIALECT, "org.hibernate.dialect.Oracle10gDialect");
		settings.put(Environment.SHOW_SQL, "true");
		settings.put(Environment.HBM2DDL_AUTO, "update");
		//settings.put(Environment.name, "update");
		
		Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(EmployeeBean.class);
		configuration.addProperties(settings);
		configuration.setNamingStrategy(ImprovedNamingStrategy.INSTANCE);


		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
		builder.applySettings(configuration.getProperties());

		SessionFactory factory = configuration.buildSessionFactory(builder.build());

		Session session = factory.openSession();
		session.beginTransaction();
		EmployeeBean bean = new EmployeeBean(1, "Ramesha", "Meda");
		session.persist(bean);
		session.getTransaction().commit();
		session.close();
		System.out.println( "Hello World!" );
	}
}

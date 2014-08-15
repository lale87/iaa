package de.nak.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
private static final SessionFactory SESSION_FACTORY;

/**
 * Initialisierung der Hibernate Session
 */
static {
	try {
		Configuration configuration = new Configuration();
		SESSION_FACTORY = configuration.configure()
				.buildSessionFactory(new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).buildServiceRegistry());
	} catch (Exception e) {
		System.err.println("SESSION_FACTORY konnte nicht erzeugt werden");
		throw new ExceptionInInitializerError();
	}
}

/**
 * 
 * 
 * @return SESSION_FACTORY
 */
public static SessionFactory getSessionFactory() {
	return SESSION_FACTORY;
}
}

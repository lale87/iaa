/**
 * 
 */
package de.nak.stundenplandb.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import de.nak.stundenplandb.model.DomainObject;

/**
 * Generic implementation for the CRUD-Operationens on objects in the database.
 * 
 * @author Fabian Kolossa
 *
 * @param <T>
 *            Object-type in the database
 */
public class GenericDAOImpl<T extends DomainObject> implements GenericDAO<T> {

	/**
	 * Object type in the database
	 */
	private Class<T> type;

	/**
	 * The Hibernate session factory.
	 */
	protected SessionFactory sessionFactory;

	public GenericDAOImpl(Class<T> type) {
		super();
		this.type = type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.nak.stundenplandb.dao.GenericDao#load(java.lang.Long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T load(Long id) {
		if (id == null) {
			return null;
		} else {
			return (T) sessionFactory.getCurrentSession().get(type, id);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.nak.stundenplandb.dao.GenericDao#loadAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> loadAll() {
		return sessionFactory.getCurrentSession()
				.createQuery("from " + type.getName()).list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.nak.stundenplandb.dao.GenericDao#save(de.nak.stundenplandb.model.
	 * DomainObject)
	 */
	@Override
	public void save(T obj) {
		sessionFactory.getCurrentSession().saveOrUpdate(obj);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.nak.stundenplandb.dao.GenericDao#delete(de.nak.stundenplandb.model
	 * .DomainObject)
	 */
	@Override
	public void delete(T obj) {
		sessionFactory.getCurrentSession().delete(obj);
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}

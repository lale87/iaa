/**
 * 
 */
package de.nak.stundenplandb.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import de.nak.stundenplandb.model.DomainObject;

/**
 * Generische Implementation der CRUD-Operationen für Objekte in der Datenbank.
 * @author Fabian Kolossa
 *
 * @param <T> Typ der Objekte in der Datenbank
 */
public class GenericDaoImplTemp<T extends DomainObject> implements GenericDaoTemp<T> {

	/**
	 * Typ der Objekte in der Datenbank
	 */
	private Class<T> type;
	
	/**
	 * The Hibernate session factory.
	 */
	protected SessionFactory sessionFactory;
	
	public GenericDaoImplTemp(Class<T> type) {
		super();
		this.type = type;
	}
	
	/* (non-Javadoc)
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

	/* (non-Javadoc)
	 * @see de.nak.stundenplandb.dao.GenericDao#loadAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> loadAll() {
		return sessionFactory.getCurrentSession().createQuery("from " + type.getName()).list();
	}

	/* (non-Javadoc)
	 * @see de.nak.stundenplandb.dao.GenericDao#save(de.nak.stundenplandb.model.DomainObject)
	 */
	@Override
	public void save(T obj) {
		sessionFactory.getCurrentSession().saveOrUpdate(obj);
	}

	/* (non-Javadoc)
	 * @see de.nak.stundenplandb.dao.GenericDao#delete(de.nak.stundenplandb.model.DomainObject)
	 */
	@Override
	public void delete(T obj) {
		sessionFactory.getCurrentSession().delete(obj);
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}

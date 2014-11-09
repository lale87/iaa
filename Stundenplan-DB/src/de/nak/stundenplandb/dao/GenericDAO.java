package de.nak.stundenplandb.dao;

import java.util.List;

import de.nak.stundenplandb.model.DomainObject;

/**
 * Generic Interface for accessing DB-Entities.
 * 
 * @author Fabian Kolossa
 *
 * @param <T>
 *            Object type in the database
 */
public interface GenericDAO<T extends DomainObject> {

	/**
	 * Loads an object from thr database by it's ID
	 * 
	 * @param id
	 *            The object's ID
	 * @return Object from database or NULL
	 */
	T load(Long id);

	/**
	 * Loads all objects of a specific object type from the database
	 * 
	 * @return list with all objects
	 */
	List<T> loadAll();

	/**
	 * Saves or updates an object in the database
	 * 
	 * @param obj
	 *            new or updated object
	 */
	void save(T obj);

	/**
	 * deletes an object from the database
	 * 
	 * @param obj
	 *            the object to delete
	 */
	void delete(T obj);
}

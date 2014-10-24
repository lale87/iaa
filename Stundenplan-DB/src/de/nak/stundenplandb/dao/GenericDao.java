package de.nak.stundenplandb.dao;

import java.util.List;

import de.nak.stundenplandb.model.DomainObject;

/**
 * Allgemeines Interface zum Zugriff auf DB-Entities.
 * @author Fabian Kolossa
 *
 * @param <T> Typ der Objekte in der Datenbank
 */
public interface GenericDao<T extends DomainObject> {
	
	/**
	 * Lädt ein Objekt anhand der zugehörigen ID aus der Datenbank.
	 * @param id ID des Objektes
	 * @return Objekt aus der Datenbank oder null
	 */
	T load(Long id);
	
	/**
	 * Lädt alle Objekte eines Typs aus der Datenbank.
	 * @return Liste mit allen Objekten
	 */
	List<T> loadAll();
	
	/**
	 * Persistiert oder aktualisiert ein Objekt in der Datenbank.
	 * @param obj Neues oder aktualisiertes Objekt
	 */
	void save(T obj);
	
	/**
	 * Löscht ein Objekt aus der Datenbank.
	 * @param obj Zu löschendes Objekt
	 */
	void delete(T obj);
}

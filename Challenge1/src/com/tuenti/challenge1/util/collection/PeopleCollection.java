package com.tuenti.challenge1.util.collection;

import java.util.HashMap;
import java.util.List;

import com.tuenti.challenge1.model.Person;
import com.tuenti.util.list.SortedList;

// TODO: Auto-generated Javadoc
/**
 * The Class PeopleCollection.
 * This collection contaisn all students 
 * This is a Singleton
 */
public class PeopleCollection extends HashMap<Integer, List<Person>> {

	/** Generated serial id. */
	private static final long serialVersionUID = -8847746078824512000L;

	/** The people collection. */
	private static PeopleCollection peopleCollection;

	/**
	 * Gets the single instance of PeopleCollection.
	 *
	 * @return single instance of PeopleCollection
	 */
	public static synchronized PeopleCollection getInstance() {
		if (peopleCollection == null) {
			peopleCollection = new PeopleCollection();
		}
		return peopleCollection;

	}

	/**
	 * Adds the person.
	 *
	 * @param person the person
	 */
	public void addPerson(Person person) {
		Integer id = person.hashCode();
		List<Person> people = getPeople(id);
		if (people != null) {
			people.add(person);
		} else {
			people = new SortedList<>();
			people.add(person);
			peopleCollection.put(id, people);
		}

	}

	/**
	 * Gets the people.
	 *
	 * @param id the id
	 * @return the people
	 */
	public List<Person> getPeople(Integer id) {
		return peopleCollection.get(id);
	}

}

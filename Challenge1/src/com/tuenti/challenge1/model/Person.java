package com.tuenti.challenge1.model;

// TODO: Auto-generated Javadoc
/**
 * The Class Person.
 */
public class Person extends AnonymousPerson implements Comparable<Person> {

	/** The name. */
	private String name;

	/**
	 * Instantiates a new person.
	 *
	 * @param genre the genre
	 * @param age the age
	 * @param studies the studies
	 * @param academicYear the academic year
	 * @param name the name
	 */
	public Person(String genre, Integer age, String studies,
			Integer academicYear, String name) {
		super(genre, age, studies, academicYear);
		this.name = name;
	}

	/**
	 * Instantiates a new person.
	 *
	 * @param values the values
	 */
	public Person(String[] values) {
		super(values[1].trim(), Integer.parseInt(values[2].trim()), values[3].trim(), Integer
				.parseInt(values[4].trim()));
		this.name = values[0];
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Person o) {

		if (o != null) {
			return this.getName().compareTo(o.getName());
		}

		return 0;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getName();
	}

	
}

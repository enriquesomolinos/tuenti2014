package com.tuenti.challenge1.model;

// TODO: Auto-generated Javadoc
/**
 * The Class AnonymousPerson.
 */
public class AnonymousPerson {

	/** The Constant FEMALE. */
	public static final String FEMALE = "F";
	
	/** The Constant MALE. */
	public static final String MALE = "M";

	/** The genre. */
	private String genre;

	/** The age. */
	private Integer age;

	/** The studies. */
	private String studies;

	/** The academic year. */
	private Integer academicYear;

	/**
	 * Instantiates a new anonymous person.
	 *
	 * @param values the values
	 */
	public AnonymousPerson(String[] values) {
		this.genre =values[0].trim();
		this.age = Integer.parseInt(values[1].trim());
		this.studies =values[2].trim();
		this.academicYear =Integer.parseInt(values[3].trim());
		
	}
	
	/**
	 * Instantiates a new anonymous person.
	 *
	 * @param genre the genre
	 * @param age the age
	 * @param studies the studies
	 * @param academicYear the academic year
	 */
	public AnonymousPerson(String genre, Integer age, String studies,
			Integer academicYear) {
		super();
		this.genre = genre;
		this.age = age;
		this.studies = studies;
		this.academicYear = academicYear;
	}

	/**
	 * Gets the genre.
	 *
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * Sets the genre.
	 *
	 * @param genre the new genre
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * Gets the age.
	 *
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * Sets the age.
	 *
	 * @param age the new age
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * Gets the studies.
	 *
	 * @return the studies
	 */
	public String getStudies() {
		return studies;
	}

	/**
	 * Sets the studies.
	 *
	 * @param studies the new studies
	 */
	public void setStudies(String studies) {
		this.studies = studies;
	}

	/**
	 * Gets the academic year.
	 *
	 * @return the academic year
	 */
	public Integer getAcademicYear() {
		return academicYear;
	}

	/**
	 * Sets the academic year.
	 *
	 * @param academicYear the new academic year
	 */
	public void setAcademicYear(Integer academicYear) {
		this.academicYear = academicYear;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((academicYear == null) ? 0 : academicYear.hashCode());
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((studies == null) ? 0 : studies.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AnonymousPerson other = (AnonymousPerson) obj;
		if (academicYear == null) {
			if (other.academicYear != null)
				return false;
		} else if (!academicYear.equals(other.academicYear))
			return false;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (studies == null) {
			if (other.studies != null)
				return false;
		} else if (!studies.equals(other.studies))
			return false;
		return true;
	}

}

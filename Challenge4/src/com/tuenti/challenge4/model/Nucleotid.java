package com.tuenti.challenge4.model;


/**
 * The Class Nucleotid.
 * Represents an atom of the dna string
 */
public class Nucleotid {

	
	/** The Constant ADENINE. */
	public static final String ADENINE = "A";
	
	/** The Constant CYTOSINE. */
	public static final String CYTOSINE = "C";
	
	/** The Constant GUANINE. */
	public static final String GUANINE = "G";
	
	/** The Constant THYMINE. */
	public static final String THYMINE = "T";
	
	/** The value. */
	private String value;

	/**
	 * Instantiates a new nucleotid.
	 *
	 * @param value the value
	 */
	public Nucleotid(String value) {
		super();
		this.value = value;
	}
	
	/**
	 * Instantiates a new nucleotid.
	 *
	 * @param value the value
	 */
	public Nucleotid(char value) {
		super();
		this.value =String.valueOf(value);
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		Nucleotid other = (Nucleotid) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return value;
	}
	
	
	
	
	
}

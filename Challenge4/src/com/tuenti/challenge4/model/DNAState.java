package com.tuenti.challenge4.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.tuenti.challenge4.util.ValidStates;

/**
 * The Class DNAState. Represent a DNA string. This state also contains possible
 * valid states than can be the next states.
 */
public class DNAState {

	/** The valid states. */
	private ValidStates validStates;

	/** The state. */
	private List<Nucleotid> state;

	/**
	 * Instantiates a new DNA state.
	 * 
	 * @param state
	 *            the state
	 * @param validStates
	 *            the valid states
	 */
	public DNAState(List<Nucleotid> state, ValidStates validStates) {
		super();
		this.state = state;
		this.validStates = validStates;
	}

	/**
	 * Instantiates a new DNA state.
	 * 
	 * @param stringState
	 *            the string state
	 * @param validStates
	 *            the valid states
	 */
	public DNAState(String stringState, ValidStates validStates) {
		this(stringState);
		this.validStates = validStates;
	}

	/**
	 * Instantiates a new DNA state.
	 * 
	 * @param stringState
	 *            the string state
	 */
	public DNAState(String stringState) {
		super();

		state = new ArrayList<Nucleotid>();

		for (int i = 0; i < stringState.length(); i++) {
			state.add(new Nucleotid(stringState.charAt(i)));
		}
	}

	/**
	 * Gets the element at.
	 * 
	 * @param position
	 *            the position
	 * @return the element at
	 */
	public Nucleotid getElementAt(Integer position) {
		return state.get(position);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (Nucleotid nucleotid : this.state) {
			sb.append(nucleotid.getValue());
		}
		return sb.toString();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((state == null) ? 0 : toString().hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
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
		DNAState other = (DNAState) obj;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!toString().equals(other.toString()))
			return false;
		return true;
	}

	/**
	 * Checks if is valid next state. If there are not only one change it's
	 * invalid.
	 * 
	 * @param otherState
	 *            the other state
	 * @return the boolean
	 */
	public Boolean isValidNextState(DNAState otherState) {
		Integer distinctNucleotid = 0;
		for (int i = 0; i < state.size(); i++) {
			Nucleotid origin = this.getElementAt(i);
			Nucleotid destiny = otherState.getElementAt(i);
			if (!origin.equals(destiny)) {
				distinctNucleotid++;
				if (distinctNucleotid > 1) {
					return false;
				}
			}

		}
		if (distinctNucleotid == 0) {
			return false;
		}
		return true;
	}

	/**
	 * Gets the valid states.
	 * 
	 * @return the valid states
	 */
	public ValidStates getValidStates() {
		return validStates;
	}

	/**
	 * Sets the valid states.
	 * 
	 * @param validStates
	 *            the new valid states
	 */
	public void setValidStates(ValidStates validStates) {
		this.validStates = validStates;
	}

	/**
	 * Gets the next states. Dado el objeto actual que representa un estado
	 * válido calcula los posibles futuros estados inmediatos y actualiza los
	 * estados validos posibles quitando los que ya han salido.
	 * 
	 * @return the next states
	 * @throws CloneNotSupportedException 
	 */
	public List<DNAState> getNextStates() throws CloneNotSupportedException {

		// first clear the initial state
		validStates.removeState(this);

		List<DNAState> listNextStates = new ArrayList<DNAState>();
		Iterator<DNAState> iteratorStates = validStates.iterator();

		while (iteratorStates.hasNext()) {
			DNAState nextState = iteratorStates.next();
			if (this.isValidNextState(nextState)) {
				ValidStates validStatesOfState;

				validStatesOfState = (ValidStates) validStates.clone();
				validStatesOfState.removeState(nextState);
				nextState.setValidStates(validStatesOfState);

				listNextStates.add(nextState);
			}
		}
		// clear de valid states
		for (DNAState dnaState : listNextStates) {
			validStates.removeState(dnaState);
		}
		return listNextStates;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#clone()
	 */
	public DNAState clone() {
		return new DNAState(this.state, null);
	}
}

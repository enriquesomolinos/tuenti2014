package com.tuenti.challenge4.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.tuenti.challenge4.model.DNAState;

/**
 * The Class ValidStates.
 * This collection contain valid DNA states.
 */
public class ValidStates implements Iterable<DNAState>, Cloneable {

	/** The valid states. */
	private Map<Integer, DNAState> validStates = new HashMap<Integer, DNAState>();

	
	/**
	 * Instantiates a new valid states.
	 */
	public ValidStates() {
		
	}
	
	/**
	 * Instantiates a new valid states.
	 *
	 * @param validStates the valid states
	 */
	public ValidStates(Map<Integer, DNAState> validStates) {
		this.validStates = validStates;
	}

	/**
	 * Adds the state.
	 *
	 * @param state the state
	 */
	public void addState(DNAState state) {
		validStates.put(state.hashCode(), state);
	}

	/**
	 * Adds the state.
	 *
	 * @param stringState the string state
	 */
	public void addState(String stringState) {
		DNAState state = new DNAState(stringState);
		validStates.put(state.hashCode(), state);
	}

	/**
	 * Checks if is valid.
	 *
	 * @param state the state
	 * @return the boolean
	 */
	public Boolean isValid(DNAState state) {
		if (validStates.get(state.hashCode()) != null) {
			return true;
		}
		return false;
	}

	/**
	 * Removes the state.
	 *
	 * @param state the state
	 */
	public void removeState(DNAState state) {
		validStates.remove(state.hashCode());
	}

	/* (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<DNAState> iterator() {
		return validStates.values().iterator();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public ValidStates clone() throws CloneNotSupportedException {

		Map<Integer, DNAState> map1 = validStates;
		Map<Integer, DNAState> map2 = new HashMap<Integer, DNAState>();

		Set<Entry<Integer, DNAState>> set1 = map1.entrySet();
		for (Entry<Integer, DNAState> e : set1)
			map2.put(e.getKey(), e.getValue());

		ValidStates vs = new ValidStates(map2);

		return vs;
	}

}

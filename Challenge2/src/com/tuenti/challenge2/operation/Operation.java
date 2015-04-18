package com.tuenti.challenge2.operation;

import com.tuenti.challenge2.model.Circuit;


/**
 * The Class Operation.
 * All operations extends this class
 */
public abstract class Operation {

	/** The circuit. */
	private Circuit circuit;

	/**
	 * Gets the circuit.
	 *
	 * @return the circuit
	 */
	protected Circuit getCircuit() {
		return this.circuit;
	}

	/**
	 * Sets the circuit.
	 *
	 * @param theCircuit the the circuit
	 * @return the operation
	 */
	protected Operation setCircuit(Circuit theCircuit) {
		this.circuit = theCircuit;
		return this;
	}

	/**
	 * Execute.
	 * Draw the element in the circuit and recalculate de direction vector
	 */
	public abstract void execute();
}

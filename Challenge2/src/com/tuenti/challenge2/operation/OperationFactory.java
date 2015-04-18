package com.tuenti.challenge2.operation;

import com.tuenti.challenge2.model.Circuit;
import com.tuenti.challenge2.service.ICircuitData;

/**
 * A factory for creating Operation objects. 
 */
public class OperationFactory {

	/**
	 * Gets the operation.
	 *
	 * @param operationType the operation type
	 * @param circuit the circuit
	 * @return the operation
	 */
	public static Operation getOperation(String operationType, Circuit circuit) {
		if (operationType.equals(ICircuitData.FINISH_LINE)) {

			return new FinishingLineOperation().setCircuit(circuit);
		} else if (operationType.equals(ICircuitData.STRAIGHT_LINE)) {
			return new StraightLineOperation().setCircuit(circuit);
		} else if (operationType.equals(ICircuitData.SLASH)) {
			return new TurnSlashOperation().setCircuit(circuit);
		} else if (operationType.equals(ICircuitData.BACK_SLASH)) {
			return new TurnBakcSlashOperation().setCircuit(circuit);
		}
		return new NullOperation();

	}
}

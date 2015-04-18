package com.tuenti.challenge2.operation;

import com.tuenti.challenge2.model.Direction;
import com.tuenti.challenge2.service.ICircuitData;


/**
 * The Class StraightLineOperation.
 * Represents the - character
 */
public class StraightLineOperation extends Operation {

	/* (non-Javadoc)
	 * @see com.tuenti.challenge2.operation.Operation#execute()
	 */
	@Override
	public void execute() {
		if (getCircuit().getCurrentDirection().getY() != Direction.NO_VERTICAL_MOVE) {
			getCircuit().draw(ICircuitData.PIPE);
		} else {
			getCircuit().draw(ICircuitData.STRAIGHT_LINE);
		}

	}

}

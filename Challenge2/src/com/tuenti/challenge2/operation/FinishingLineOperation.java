package com.tuenti.challenge2.operation;

import com.tuenti.challenge2.service.ICircuitData;


/**
 * The Class FinishingLineOperation.
 * Represents de # character
 */
public class FinishingLineOperation extends Operation {


	/* (non-Javadoc)
	 * @see com.tuenti.challenge2.operation.Operation#execute()
	 */
	@Override
	public void execute() {
		getCircuit().draw(ICircuitData.FINISH_LINE);
		
	}

	
	
}

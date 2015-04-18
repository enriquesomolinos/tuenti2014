package com.tuenti.challenge2.operation;

import com.tuenti.challenge2.model.Direction;
import com.tuenti.challenge2.service.ICircuitData;

// TODO: Auto-generated Javadoc
/**
 * The Class TurnBakcSlashOperation.
 * Represents de \ character
 */
public class TurnBakcSlashOperation extends Operation {

	/* (non-Javadoc)
	 * @see com.tuenti.challenge2.operation.Operation#execute()
	 */
	@Override
	public void execute() {
		getCircuit().draw(ICircuitData.BACK_SLASH);

		Direction newDirection = new Direction();
		if (getCircuit().getCurrentDirection().getY() != Direction.NO_VERTICAL_MOVE) {
			if (getCircuit().getCurrentDirection().getY() == Direction.UP_MOVE) {
				newDirection.setX(Direction.RIGHT_MOVE);
				newDirection.setY(Direction.NO_VERTICAL_MOVE);
			} else if (getCircuit().getCurrentDirection().getY() == Direction.DOWN_MOVE) {
				newDirection.setX(Direction.LEFT_MOVE);
				newDirection.setY(Direction.NO_VERTICAL_MOVE);
			}

		} else if (getCircuit().getCurrentDirection().getX() != Direction.NO_HORIZONTAL_MOVE) {
			if (getCircuit().getCurrentDirection().getX() == Direction.LEFT_MOVE) {
				newDirection.setX(Direction.NO_HORIZONTAL_MOVE);
				newDirection.setY(Direction.DOWN_MOVE);
			} else if (getCircuit().getCurrentDirection().getX() == Direction.RIGHT_MOVE) {
				newDirection.setX(Direction.NO_HORIZONTAL_MOVE);
				newDirection.setY(Direction.UP_MOVE);
			}

		}
		
		getCircuit().setCurrentDirection(newDirection);

	}

}

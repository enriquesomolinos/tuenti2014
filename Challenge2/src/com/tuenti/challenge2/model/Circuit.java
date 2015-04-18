package com.tuenti.challenge2.model;

import com.tuenti.challenge2.service.ICircuitData;

/**
 * The Class Circuit.
 * Represent in an array all the positions of the circuit
 */
public final class Circuit {

	/** The Constant CIRCUIT_LENGTH. */
	public static final Integer CIRCUIT_LENGTH = 800;
	
	/** The Constant CENTER. */
	public static final Integer CENTER = 400;

	

	/** The circuit. */
	private String[][] circuit = new String[CIRCUIT_LENGTH][CIRCUIT_LENGTH];

	/** The min_width. */
	private Integer min_width = CENTER;
	
	/** The min_height. */
	private Integer min_height = CENTER;

	
	
	/** The max_width. */
	private Integer max_width = CENTER;
	
	/** The max_height. */
	private Integer max_height = CENTER;

	/** The current position. */
	private Position currentPosition = new Position(CENTER, CENTER);

	/** The current direction. */
	private Direction currentDirection = new Direction();

	/**
	 * Gets the current position.
	 *
	 * @return the current position
	 */
	public Position getCurrentPosition() {
		return currentPosition;
	}

	/**
	 * Gets the current direction.
	 *
	 * @return the current direction
	 */
	public Direction getCurrentDirection() {
		return currentDirection;
	}

	/**
	 * Sets the current direction.
	 *
	 * @param currentDirection the new current direction
	 */
	public void setCurrentDirection(Direction currentDirection) {
		this.currentDirection = currentDirection;
	}

	/**
	 * Draw an element in the mcircuit map
	 *
	 * @param element the element
	 */
	public void draw(String element) {
		currentPosition.setX(currentPosition.getX() + currentDirection.getX());
		currentPosition.setY(currentPosition.getY() + currentDirection.getY());

		circuit[currentPosition.getX()][currentPosition.getY()] = element;
		updateMaxSizes();
	}

	/**
	 * Update max sizes.
	 */
	private void updateMaxSizes() {

		if (currentPosition.getX() > max_width) {
			max_width = currentPosition.getX();
		}
		if (currentPosition.getY() > max_height) {
			max_height = currentPosition.getY();
		}
		
		if (currentPosition.getX() < min_width) {
			min_width = currentPosition.getX();
		}
		if (currentPosition.getY()<min_height) {
			min_height = currentPosition.getY();
		}
	}

	/**
	 * Prints the me in console.
	 */
	public void printMeInConsole(){
		StringBuffer outputCircuit = new StringBuffer();
		for(int height = min_height ; height< max_height+1;height++){
			for(int width = min_width ; width< max_width+1;width++){
				if(circuit[width][height]==null){
					outputCircuit.append(ICircuitData.SPACE);
				}else{
					outputCircuit.append(circuit[width][height]);
				}				
			}
			System.out.println(outputCircuit.toString());
			outputCircuit= new StringBuffer();
		}
		
		
	}
}

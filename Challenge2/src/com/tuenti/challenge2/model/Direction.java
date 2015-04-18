package com.tuenti.challenge2.model;


/**
 * The Class Direction.
 * Represent a direction vector
 * X=1 represents left move
 * X=0 no horizontal move
 * X=-1 rigth move
 * Y=0 no vertical move
 * Y=1 up move
 * Y=-1 down move
 */
public class Direction {

	
	public static final Integer NO_HORIZONTAL_MOVE= 0;
	public static final Integer NO_VERTICAL_MOVE= 0;
	public static final Integer LEFT_MOVE= 1;
	public static final Integer RIGHT_MOVE= -1;
	public static final Integer DOWN_MOVE= 1;
	public static final Integer UP_MOVE= -1;
	
	
	/** The x. */
	private Integer x;
	
	/** The y. */
	private Integer y;
	
	/**
	 * Instantiates a new direction.
	 */
	public Direction() {
		super();
		x=LEFT_MOVE;
		y=NO_VERTICAL_MOVE;
	}

	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public Integer getX() {
		return x;
	}

	/**
	 * Sets the x.
	 *
	 * @param x the new x
	 */
	public void setX(Integer x) {
		this.x = x;
	}

	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public Integer getY() {
		return y;
	}

	/**
	 * Sets the y.
	 *
	 * @param y the new y
	 */
	public void setY(Integer y) {
		this.y = y;
	}
	
	
	
}

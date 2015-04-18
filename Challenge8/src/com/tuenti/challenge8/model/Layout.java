package com.tuenti.challenge8.model;

import java.util.Arrays;


/**
 * The Class Layout.
 * Representa el puzzle tanto con nombre como con numeros
 */
public class Layout {

	/** The Constant DIMENSION. */
	public static final int DIMENSION = 3;

	/** The layout. */
	private String[][] layout = new String[DIMENSION][DIMENSION];

	/** The integer layout. */
	private Integer[][] integerLayout = new Integer[DIMENSION][DIMENSION];

	/** The hash code. */
	private int hashCode = -1;

	/**
	 * Instantiates a new layout.
	 *
	 * @param theLayout the the layout
	 * @param solution the solution
	 */
	public Layout(String[][] theLayout, Layout solution) {
		super();
		this.layout = theLayout;

		for (int row = 0; row < DIMENSION; row++)
			for (int column = 0; column < DIMENSION; column++) {
				Position pos = solution.getPosition(layout[row][column]);
				integerLayout[row][column] = (pos.getX() * DIMENSION)
						+ pos.getY() + 1;
			}
		calculateHashCode();
	}

	/**
	 * Instantiates a new layout.
	 *
	 * @param theLayout the the layout
	 * @param theIntegerLayout the the integer layout
	 */
	public Layout(String[][] theLayout, Integer[][] theIntegerLayout) {
		super();
		for (int row = 0; row < DIMENSION; row++)
			for (int column = 0; column < DIMENSION; column++) {

				layout[row][column] = theLayout[row][column].trim();
				integerLayout[row][column] = theIntegerLayout[row][column];

			}
		calculateHashCode();
	}

	/**
	 * Gets the position.
	 *
	 * @param element the element
	 * @return the position
	 */
	public Position getPosition(String element) {
		for (int row = 0; row < DIMENSION; row++)
			for (int column = 0; column < DIMENSION; column++) {
				if (layout[row][column].toString().trim()
						.equals(element.trim())) {
					return new Position(row, column);
				}
			}

		return null;
	}

	/**
	 * Gets the position.
	 *
	 * @param element the element
	 * @return the position
	 */
	public Position getPosition(Integer element) {
		for (int row = 0; row < DIMENSION; row++)
			for (int column = 0; column < DIMENSION; column++) {
				if (integerLayout[row][column].equals(element)) {
					return new Position(row, column);
				}
			}
		return null;
	}

	/**
	 * Adds the element.
	 *
	 * @param pos the pos
	 * @param element the element
	 */
	public void addElement(Position pos, String element) {
		layout[pos.getX()][pos.getY()] = element;
	}

	/**
	 * Adds the element.
	 *
	 * @param pos the pos
	 * @param element the element
	 */
	public void addElement(Position pos, Integer element) {
		integerLayout[pos.getX()][pos.getY()] = element;
	}

	/**
	 * Gets the string position.
	 *
	 * @param row the row
	 * @param column the column
	 * @return the string position
	 */
	public String getStringPosition(Integer row, Integer column) {
		return layout[row][column];
	}

	/**
	 * Gets the integer position.
	 *
	 * @param row the row
	 * @param column the column
	 * @return the integer position
	 */
	public Integer getIntegerPosition(Integer row, Integer column) {
		return integerLayout[row][column];
	}

	/**
	 * Hamming distance.
	 *
	 * @return the integer
	 */
	public Integer hammingDistance() {
		Integer hammingDistance = 0;
		for (int row = 0; row < DIMENSION; row++)
			for (int column = 0; column < DIMENSION; column++)
				if(row==1 && column ==1){
					continue;
				}else
				if (integerLayout[row][column] != (row * DIMENSION) + column
						+ 1) {
					hammingDistance++;
				}
		return hammingDistance;
	}

	/**
	 * Manhattan.
	 *
	 * @return the integer
	 */
	public Integer manhattan() {

		Integer sum = 0;
		Integer goalRow, goalCol;
		Integer value = 0;
		for (int row = 0; row < DIMENSION; row++) {
			for (int col = 0; col < DIMENSION; col++) {
				value = integerLayout[row][col];
				// Because 0 is not at (0, 0).
				goalRow = (value - 1) / DIMENSION;
				goalCol = (value - 1) % DIMENSION;

				
				sum+=Math.abs(goalRow-row) +Math.abs(goalCol-col);
				
				
			}
		}

		// System.out.println(sum);
		return sum;
	}

	/**
	 * Checks if is solution.
	 *
	 * @return the boolean
	 */
	public Boolean isSolution() {
		if (hammingDistance() > 0)
			return false;

		return true;

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (int row = 0; row < DIMENSION; row++) {
			for (int col = 0; col < DIMENSION; col++) {
				s.append(" " + integerLayout[row][col]);
			}
			s.append("\n");
		}
		return s.toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public Layout clone() {
		Layout layout = new Layout(this.layout, this.integerLayout);
		return layout;
	}

	/**
	 * Swap layout.
	 *
	 * @param origin the origin
	 * @param dest the dest
	 * @return the layout
	 */
	public Layout swapLayout(Position origin, Position dest) {
		return swapLayout(origin.getX(), origin.getY(), dest.getX(),
				dest.getY());
	}

	/**
	 * Swap layout.
	 *
	 * @param originRow the origin row
	 * @param originCol the origin col
	 * @param destRow the dest row
	 * @param destCol the dest col
	 * @return the layout
	 */
	private Layout swapLayout(Integer originRow, Integer originCol,
			Integer destRow, Integer destCol) {

		Layout outputLayout = this.clone();

		Integer tmpInteger = outputLayout.getIntegerPosition(originRow,
				originCol);
		String tmpString = outputLayout.getStringPosition(originRow, originCol);

		outputLayout.addElement(new Position(originRow, originCol),
				outputLayout.getIntegerPosition(destRow, destCol));
		outputLayout.addElement(new Position(originRow, originCol),
				outputLayout.getStringPosition(destRow, destCol));

		outputLayout.addElement(new Position(destRow, destCol), tmpInteger);
		outputLayout.addElement(new Position(destRow, destCol), tmpString);
		outputLayout.calculateHashCode();
		return outputLayout;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		if (this.hashCode == -1) {
			calculateHashCode();
		}
		return this.hashCode;
	}

	/**
	 * Calculate hash code.
	 */
	public void calculateHashCode() {
		int result = 0;
		for (int row = 0; row < DIMENSION; row++) {
			for (int col = 0; col < DIMENSION; col++) {
				Integer pow = (int) Math.round(Math.pow(10, (row * DIMENSION)
						+ col));
				Integer tmpResult = integerLayout[row][col] * (pow);
				result = result + tmpResult;

			}

		}
		this.hashCode = result;

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
		Layout other = (Layout) obj;
		if (!Arrays.deepEquals(integerLayout, other.integerLayout))
			return false;
		return true;
	}

	/**
	 * Checks if is solvable.
	 *
	 * @return the integer
	 */
	public Integer isSolvable() {

		int inversions = 0;
		for (int col = 0; col < DIMENSION; col++) {
			for (int row = 0; row < DIMENSION; row++) {
				for (int col2 = col + 1; col2 < DIMENSION; col2++) {
					for (int row2 = row + 1; row2 < DIMENSION; row2++) {
						if (this.integerLayout[row][col] > this.integerLayout[row2][col2]) {
							inversions++;
						}
						if (this.integerLayout[row][col] == 9 && col % 2 == 1)
							inversions++;
					}
				}
			}
		}
		return (inversions);
	}

}

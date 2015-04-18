package com.tuenti.challenge5.model;

public class Tribble {

	public final static String LIFE = "X";
	public final static String BLANCK = "-";
	public final static int MAX_SIZE = 8;
	private String[][] tribbleGrid = new String[MAX_SIZE][MAX_SIZE];

	public void addElement(Position position) {
		if (!(position.getX() < 0 || position.getX() > MAX_SIZE
				|| position.getY() < 0 || position.getY() > MAX_SIZE)) {
			tribbleGrid[position.getX()][position.getY()] = LIFE;
		}

	}

	public void addBlank(Position position) {
		tribbleGrid[position.getX()][position.getY()] = BLANCK;
	}

	public Boolean isOccupied(Position position) {
		if (tribbleGrid[position.getX()][position.getY()].equals(LIFE)) {
			return true;
		}
		return false;
	}
	
	public Boolean isOccupied(Integer row, Integer column) {
		return isOccupied(new Position(row,column));
	}

	public void addRow(String row, Integer column) {
		row = row.trim();
		for (int i = 0; i < MAX_SIZE; i++) {
			tribbleGrid[i][column] = String.valueOf(row.charAt(i));
		}
	}

	public Integer getBorderObjects(Position position) {
		// comprobamos todas las posiciones que rodean
		Integer borderObjects = 0;

		if (position.getX() > 0) {
			if (tribbleGrid[position.getX() - 1][position.getY()].equals(LIFE)) {
				borderObjects++;
			}
			if (position.getY() > 0) {
				if (tribbleGrid[position.getX() - 1][position.getY() - 1]
						.equals(LIFE)) {
					borderObjects++;
				}
			}
			if (position.getY() < MAX_SIZE) {
				if (tribbleGrid[position.getX() - 1][position.getY() + 1]
						.equals(LIFE)) {
					borderObjects++;
				}
			}
		}
		if (position.getX() < MAX_SIZE) {
			if (tribbleGrid[position.getX() + 1][position.getY()].equals(LIFE)) {
				borderObjects++;
			}
			if (position.getY() > 0) {
				if (tribbleGrid[position.getX() + 1][position.getY() - 1]
						.equals(LIFE)) {
					borderObjects++;
				}
				if (position.getY() < MAX_SIZE) {
					if (tribbleGrid[position.getX() + 1][position.getY() + 1]
							.equals(LIFE)) {
						borderObjects++;
					}
				}
			}
		}
		if (position.getY() > 0) {
			if (tribbleGrid[position.getX()][position.getY() - 1].equals(LIFE)) {
				borderObjects++;
			}
		}
		if (position.getY() < MAX_SIZE) {
			if (tribbleGrid[position.getX()][position.getY() + 1].equals(LIFE)) {
				borderObjects++;
			}
		}
		return borderObjects;

	}

	public void draw() {
		System.out.println(this.toString());
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int column = 0; column < Tribble.MAX_SIZE; column++) {

			for (int row = 0; row < Tribble.MAX_SIZE; row++) {
				sb.append(tribbleGrid[row][column]);
			}
			sb.append("\n");
		}
		return sb.toString();
	}

}

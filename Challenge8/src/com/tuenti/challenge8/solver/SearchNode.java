package com.tuenti.challenge8.solver;

import com.tuenti.challenge8.model.Layout;


/**
 * The Class SearchNode.
 */
public class SearchNode implements Comparable<SearchNode> {

	/** The layout. */
	private Layout layout;

	/** The moves. */
	private Integer moves;

	/** The priority. */
	private Integer priority;

	/** The parent. */
	private SearchNode parent;
	
	/** The solver moves. */
	private Integer solverMoves;
	
	/**
	 * Instantiates a new search node.
	 *
	 * @param layout the layout
	 * @param moves the moves
	 */
	public SearchNode(Layout layout, Integer moves) {
		super();
		this.layout = layout;
		this.moves = moves;
		this.priority = (int) (moves+ (layout.manhattan()*0.6));
		this.solverMoves=-1;
		this.parent= null;
	}

	/**
	 * Gets the layout.
	 *
	 * @return the layout
	 */
	public Layout getLayout() {
		return layout;
	}

	/**
	 * Sets the layout.
	 *
	 * @param layout the new layout
	 */
	public void setLayout(Layout layout) {
		this.layout = layout;
	}

	/**
	 * Gets the moves.
	 *
	 * @return the moves
	 */
	public Integer getMoves() {
		return moves;
	}

	/**
	 * Sets the moves.
	 *
	 * @param moves the new moves
	 */
	public void setMoves(Integer moves) {
		this.moves = moves;
	}

	/**
	 * Gets the priority.
	 *
	 * @return the priority
	 */
	public Integer getPriority() {
		return priority;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(SearchNode that) {
		return this.priority - that.priority;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int result = 0;
		result = result + ((layout == null) ? 0 : layout.hashCode());
		return result;
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
		SearchNode other = (SearchNode) obj;
		if (layout == null) {
			if (other.layout != null)
				return false;
		} else if (!layout.equals(other.layout))
			return false;
		return true;
	}

	/**
	 * Gets the parent.
	 *
	 * @return the parent
	 */
	public SearchNode getParent() {
		return parent;
	}

	/**
	 * Sets the parent.
	 *
	 * @param parent the new parent
	 */
	public void setParent(SearchNode parent) {
		this.parent = parent;
	}

	/**
	 * Gets the solver moves.
	 *
	 * @return the solver moves
	 */
	public Integer getSolverMoves() {
		return solverMoves;
	}

	/**
	 * Sets the solver moves.
	 *
	 * @param solverMoves the new solver moves
	 */
	public void setSolverMoves(Integer solverMoves) {
		this.solverMoves = solverMoves;
	}

	
	
	
}

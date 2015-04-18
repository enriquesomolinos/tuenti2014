package com.tuenti.challenge8.solver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tuenti.challenge8.model.Layout;
import com.tuenti.challenge8.model.Position;
import com.tuenti.util.list.SortedList;


/**
 * The Class Resolver.
 */
public class Resolver {

	/** The navigated solutions. */
	private static Map<Integer, SearchNode> navigatedSolutions = new HashMap<Integer, SearchNode>();
	
	/**
	 * Resolve.
	 *
	 * @param initialLayout the initial layout
	 * @return the integer
	 */
	public Integer resolve(Layout initialLayout) {

		SearchNode initialSearchNode = new SearchNode(initialLayout, 0);

		SortedList<SearchNode> fullIntermediateSolutions = new SortedList<SearchNode>();

		Map<Integer, SearchNode> navigatedNodes = new HashMap<Integer, SearchNode>();

		navigatedNodes.put(initialSearchNode.hashCode(), initialSearchNode);

		if (initialSearchNode.getLayout().isSolution()) {
			return initialSearchNode.getMoves();
		} else {
			fullIntermediateSolutions.add(initialSearchNode);
			do {
				SearchNode originSearchNode = fullIntermediateSolutions.get(0);
				
				//comprobamos si ya esta calculado su camino anteriormente
				if(navigatedSolutions.get(originSearchNode.hashCode())!=null){
					return originSearchNode.getMoves()+ navigatedSolutions.get(originSearchNode.hashCode()).getSolverMoves();
					
				}
				
				navigatedNodes.put(originSearchNode.hashCode(),
						originSearchNode);
				fullIntermediateSolutions.remove(0);
				
				List<SearchNode> intermediateSolutions = generateNextLayouts(originSearchNode);
				for (SearchNode searchNode : intermediateSolutions) {
					
					if (searchNode.getLayout().isSolution()) {
						updateNavigatedSolutions(searchNode);
						
						return searchNode.getMoves();
					} else {
						if (searchNode.getPriority() > originSearchNode
								.getPriority() +1) {
							navigatedNodes.put(searchNode.hashCode(),
									searchNode);
						} else if (navigatedNodes
								.get(searchNode.hashCode()) == null) {
							searchNode.setParent(originSearchNode);
							fullIntermediateSolutions.add(searchNode);
						}
					}
				}
				fullIntermediateSolutions.sort();
				//System.out.println("\n");
			} while (fullIntermediateSolutions.size() > 0);

		}
		return null;

	}

	/**
	 * Update navigated solutions.
	 *
	 * @param node the node
	 */
	private void updateNavigatedSolutions(SearchNode node){
		node.setSolverMoves(0);
		navigatedSolutions.put(node.hashCode(), node);
		
		Integer movestoEnd =1;
		while(node.getParent()!=null ){
			
			node = node.getParent();
			node.setSolverMoves(movestoEnd);
			navigatedSolutions.put(node.hashCode(), node);
			movestoEnd++;
		}
		
		
		
	}
	
	/**
	 * Genera los puzzles para el sigueinte movimiento.
	 *
	 * @param originSearchNode the origin search node
	 * @return the list
	 */
	public List<SearchNode> generateNextLayouts(SearchNode originSearchNode) {
		List<SearchNode> listNext = new SortedList<SearchNode>();
		// permutaciones
		Layout originLayout = originSearchNode.getLayout();
		Layout destLayout;
		
		
		destLayout = originLayout.swapLayout(new Position(0, 0), new Position(
				1, 0));
		listNext.add(new SearchNode(destLayout, originSearchNode.getMoves() +1));
		
		destLayout = originLayout.swapLayout(new Position(0, 0), new Position(
				0, 1));
		listNext.add(new SearchNode(destLayout, originSearchNode.getMoves() + 1));
		
		destLayout = originLayout.swapLayout(new Position(1, 0), new Position(
				2, 0));
		listNext.add(new SearchNode(destLayout, originSearchNode.getMoves() + 1));
		
		destLayout = originLayout.swapLayout(new Position(1, 0), new Position(
				1, 1));
		listNext.add(new SearchNode(destLayout, originSearchNode.getMoves() + 1));
		
		destLayout = originLayout.swapLayout(new Position(2, 0), new Position(
				2, 1));
		listNext.add(new SearchNode(destLayout, originSearchNode.getMoves() + 1));
		
		destLayout = originLayout.swapLayout(new Position(0, 1), new Position(
				1, 1));
		listNext.add(new SearchNode(destLayout, originSearchNode.getMoves() + 1));
		
		destLayout = originLayout.swapLayout(new Position(0, 1), new Position(
				0, 2));
		listNext.add(new SearchNode(destLayout, originSearchNode.getMoves() + 1));
		
		destLayout = originLayout.swapLayout(new Position(1, 1), new Position(
				2, 1));
		listNext.add(new SearchNode(destLayout, originSearchNode.getMoves() + 1));
		destLayout = originLayout.swapLayout(new Position(1, 1), new Position(
				1, 2));
		listNext.add(new SearchNode(destLayout, originSearchNode.getMoves()+1));
		
		destLayout = originLayout.swapLayout(new Position(2, 1), new Position(
				2, 2));
		listNext.add(new SearchNode(destLayout, originSearchNode.getMoves() + 1));
		
		destLayout = originLayout.swapLayout(new Position(0,2), new Position(
				1, 2));
		listNext.add(new SearchNode(destLayout, originSearchNode.getMoves() + 1));
		
		destLayout = originLayout.swapLayout(new Position(1,2), new Position(
				2, 2));
		listNext.add(new SearchNode(destLayout, originSearchNode.getMoves() + 1));
		
		
	
		
		
		return listNext;
	}

}

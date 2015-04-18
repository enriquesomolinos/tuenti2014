package com.tuenti.challenge4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.tuenti.challenge4.model.DNAState;
import com.tuenti.challenge4.util.TreeNode;
import com.tuenti.challenge4.util.ValidStates;
 
/**
 * The Class Challenge4.
 */
public class Challenge4 {

	/**
	 * 
	 * La idea es dado un estado inicial, generar la primera lista de mutaciones y dentro de cada mutación sólo guardar las
	 * posibles mutaciones (quitando las que ya han salido). Si en esta lista no esta la solucion, se vuelve a generar los
	 * siguientes estados a partir de esta lista eliminando nuevamente los estados que ya han salido.
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		
		DNAState initialState;
		DNAState targetState;
		TreeNode<DNAState> solutionTreeState;

		

		try {
			ValidStates validStates = new ValidStates();
			BufferedReader br;
			String line;

			br = new BufferedReader(new InputStreamReader(System.in));

			initialState = new DNAState(br.readLine().trim());
			targetState = new DNAState(br.readLine().trim());

			while ((line = br.readLine()) != null) {
				validStates.addState(line.trim());
			}
			br.close();
			br = null;

			initialState.setValidStates(validStates);
			targetState.setValidStates(validStates);

			TreeNode<DNAState> dnaTree = new TreeNode<DNAState>(initialState);

			List<TreeNode<DNAState>> inStates = new ArrayList<TreeNode<DNAState>>();
			inStates.add(dnaTree);
			do{

				inStates = createNextStates(inStates);
				if ((solutionTreeState = containsSolution(inStates, targetState)) != null) {
					solutionTreeState.draw();

				}

			}while(isThereUnNavigatedStates(inStates));
		} catch (NumberFormatException e) {
			System.out.println("The input number is not correct");
		} catch (IOException e) {
			System.out.println("Error while reading input");
		} catch (CloneNotSupportedException e) {
			System.out.println("Error while creating solution");
		}

	}

	/**
	 * Comprueba que todos los elementos de la lista no tienen posibles estados navegables.
	 *
	 * @param listStates the list states
	 * @return the boolean
	 */
	public static Boolean isThereUnNavigatedStates(
			List<TreeNode<DNAState>> listStates) {
		for (TreeNode<DNAState> treeDNAState : listStates) {
			if(treeDNAState.getData().getValidStates().iterator().hasNext()){
				return true;
			}
			
		}
		return false;
	}
	
	
	/**
	 * Comprueba que el listado de estados contiene el estado solucion
	 *
	 * @param listStates the list states
	 * @param targetState the target state
	 * @return the tree node
	 */
	public static TreeNode<DNAState> containsSolution(
			List<TreeNode<DNAState>> listStates, DNAState targetState) {
		for (TreeNode<DNAState> treeDNAState : listStates) {
			if (treeDNAState.getData().equals(targetState)) {
				return treeDNAState;
			}
		}
		return null;
	}

	/**
	 * Genera los nuevos estados a partir del listado de estaods actuales
	 *
	 * @param listStates the list states
	 * @return the list
	 * @throws CloneNotSupportedException the clone not supported exception
	 */
	public static List<TreeNode<DNAState>> createNextStates(
			List<TreeNode<DNAState>> listStates)
			throws CloneNotSupportedException {
		List<TreeNode<DNAState>> outStates = new ArrayList<TreeNode<DNAState>>();

		for (TreeNode<DNAState> treeDNAState : listStates) {
			List<DNAState> nextStates = treeDNAState.getData().getNextStates();
			for (DNAState nextState : nextStates) {
				TreeNode<DNAState> nextTreeNode = treeDNAState
						.addChild(nextState);
				outStates.add(nextTreeNode);

			}
		}
		return outStates;
	}

}

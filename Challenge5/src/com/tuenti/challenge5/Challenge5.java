package com.tuenti.challenge5;

import com.tuenti.challenge5.model.Tribble;
import com.tuenti.challenge5.service.TribbleGenerator;
import com.tuenti.challenge5.util.TribbleCollection;

/**
 * The Class Challenge5.
 */
public class Challenge5 {

	
	public static void main(String[] args) {

		//Tribble startingTribble = TribbleReader.readInput();
		
		Tribble startingTribble = new Tribble();
		startingTribble.addRow("XX----XX", 0);
		startingTribble.addRow("XX----XX", 1);
		startingTribble.addRow("--------", 2);
		startingTribble.addRow("---XX---", 3);
		startingTribble.addRow("---XX---", 4);
		startingTribble.addRow("--------", 5);
		startingTribble.addRow("XX----XX", 6);
		startingTribble.addRow("XX----XX", 7);
		
		TribbleCollection tCollection =  new TribbleCollection();
		
		for(int i = 0; i < 100; i++){
			Tribble generatedTribble = TribbleGenerator.getNextTribble(startingTribble);
			generatedTribble.draw();
			if(tCollection.contains(generatedTribble)!=-1){
				
				System.out.println(tCollection.contains(generatedTribble) + " " + (i-tCollection.contains(generatedTribble)));
				break;
			}
			tCollection.addTribble(generatedTribble);				
		}
	}

}

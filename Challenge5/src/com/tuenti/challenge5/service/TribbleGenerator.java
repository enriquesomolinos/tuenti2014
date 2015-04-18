package com.tuenti.challenge5.service;

import com.tuenti.challenge5.model.Position;
import com.tuenti.challenge5.model.Tribble;

public class TribbleGenerator {

	public static Tribble getNextTribble(Tribble tribble) {
		Tribble newTribble = new Tribble();
		for (int column = 0; column < Tribble.MAX_SIZE; column++) {
			for (int row = 0; row < Tribble.MAX_SIZE; row++) {
				
				Position pos = new Position(row, column);
				if(tribble.isOccupied(pos)){
					if(tribble.getBorderObjects(pos)==0){
						newTribble.addBlank(new Position(row, column));						
					}else if(tribble.getBorderObjects(pos)==1){						
						newTribble.addElement(getOpositePosition(pos,tribble));
						newTribble.addBlank(new Position(row, column));
						
					}else if(tribble.getBorderObjects(pos)==2){
						//cambiar
						newTribble.addBlank(new Position(row, column));
					}else if(tribble.getBorderObjects(pos)==3){
						newTribble.addElement(new Position(row, column));
					}else if(tribble.getBorderObjects(pos)==4){
						//cambiar
						newTribble.addElement(new Position(row, column));
					}else if(tribble.getBorderObjects(pos)==5){
						//cambiar
						newTribble.addElement(new Position(row, column));
					}
				}else{
					newTribble.addBlank(new Position(row, column));
				}
				
			}
		}
		return newTribble;

	}
	
	public static Position getOpositePosition( Position position,Tribble tribble) {
		// comprobamos todas las posiciones que rodean
				

				if (position.getX() > 0) {
					if (tribble.isOccupied(position.getX() - 1,position.getY())) {
						return new Position(position.getX() + 1,position.getY());
						
					}
					if (position.getY() > 0) {
						if (tribble.isOccupied(position.getX() - 1,position.getY() - 1)) {
							return new Position(position.getX() + 1,position.getY()+1);
						}
					}
					if (position.getY() < 8) {
						if (tribble.isOccupied(position.getX() - 1,position.getY() + 1)) {
							return new Position(position.getX() + 1,position.getY()-1);
						}
					}
				}
				if (position.getX() < 8) {
					if (tribble.isOccupied(position.getX() + 1,position.getY())) {
						return new Position(position.getX() - 1,position.getY());
					}
					if (position.getY() > 0) {
						if (tribble.isOccupied(position.getX() + 1,position.getY() - 1)) {
							return new Position(position.getX() - 1,position.getY()+1);
						}
						if (position.getY() < 8) {
							if (tribble.isOccupied(position.getX() + 1,position.getY() + 1)) {
								return new Position(position.getX() - 1,position.getY()-1);
							}
						}
					}
				}
				if (position.getY() > 0) {
					if (tribble.isOccupied(position.getX(),position.getY() - 1)) {
						return new Position(position.getX(),position.getY()+1);
					}
				}
				if (position.getY() < 8) {
					if (tribble.isOccupied(position.getX(),position.getY() + 1)) {
						return new Position(position.getX(),position.getY()-1);
					}
				}
				return null;


	}
	
}

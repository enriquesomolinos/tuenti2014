package com.tuenti.challenge5.util;

import java.util.ArrayList;
import java.util.List;

import com.tuenti.challenge5.model.Tribble;

public class TribbleCollection {

	private List<Tribble> tribbles = new ArrayList<Tribble>();

	public void addTribble(Tribble tribble) {
		tribbles.add(tribble);
	}

	public Integer contains(Tribble solutionTribble) {
		for (int i = 0; i < tribbles.size(); i++) {

			if (tribbles.get(i).toString().equals(solutionTribble.toString())) {
				return i;
			}
		}

		return -1;
	}
}

package com.sbj.util;

import java.util.List;

import com.sbj.dataObjects.TestCaseObject;

public class GameProcessor {
	private static GameProcessor gameProcessor = null;
	
	private GameProcessor() {
		
	}
	
	public static GameProcessor getGameProcessor() {
		synchronized (GameProcessor.class) {
			if(gameProcessor ==null) {
				gameProcessor = new GameProcessor();
			}
			return gameProcessor;
		}
	}
	
	/**
	 * Derive game result 
	 * @param dataObject
	 */
	public void deriveTestCaseResult(final TestCaseObject dataObject) {
		final List<Integer> villainStrengh = dataObject.getVillainStrengths();
		final List<Integer> playersStrengh = dataObject.getPlayerStrengths();

		//use traditional for loop to fetch each items from list 
		// here logic is : subtract villain strength from players strength , 
		// if result is  < 0 for any value then print "LOSE" else print "WIN"
		for(int i = 0 ; i< dataObject.getNoOfPlayers(); i++) {
			if((playersStrengh.get(i) - villainStrengh.get(i)) < 1) {
				System.out.println("LOSE");
				return;
			}
		}
		System.out.println("WIN");
	}

}

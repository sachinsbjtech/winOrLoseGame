package com.sbj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.ValidationException;

import com.sbj.dataObjects.TestCaseObject;
import com.sbj.util.GameHelper;
import com.sbj.util.GameProcessor;
import com.sbj.validator.InputDataValidator;

public class GameStarter {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static GameHelper gameHelper = GameHelper.getGameHelper();
	private static List<TestCaseObject> listOfTestCases = new ArrayList<>();
	private static GameProcessor gameProcessor = GameProcessor.getGameProcessor();
	private static InputDataValidator inputDataValidator = InputDataValidator.getInputDataValidator();
	
	public static void main(String[] args) {
		System.out.println("Please enter Input in required format:");
		
		try {
			String noOfTestCases = br.readLine();
			int noOfTC = gameHelper.stringToInteger(noOfTestCases);
			
			//Validate Test case count as per guidelines
			inputDataValidator.testCaseNumberValidation(noOfTC);
			
			// read console input 
			for(int i =0 ; i < noOfTC ;i++) {
				readTestCaseInput(noOfTestCases);
			}
			System.out.println("Output :");
			
			// process input and decide game result
			for(TestCaseObject dataObject : listOfTestCases) {
				gameProcessor.deriveTestCaseResult(dataObject);
			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ValidationException e) {
			System.out.println(e.getMessage());
		}
	}
	private static void readTestCaseInput(String noOfTestCases) throws IOException, ValidationException {
			String noOfPlayersString = br.readLine();
			
			int noOfPlayers = gameHelper.stringToInteger(noOfPlayersString);
			
			//validate number of players
			inputDataValidator.validatePlayersCount(noOfPlayers);
			
			TestCaseObject dataObject = new TestCaseObject();
			dataObject.setNoOfPlayers(noOfPlayers);

			// read Villain strength 
			String villainStrenghInput = br.readLine();
			
			dataObject.setVillainStrengths(gameHelper.convertStrengthData(villainStrenghInput));
			
			// read Players Strength 
			String playerStrengthInput = br.readLine();
			
			dataObject.setPlayerStrengths(gameHelper.convertStrengthData(playerStrengthInput));
			
			listOfTestCases.add(dataObject);
			
		
		
	}

}

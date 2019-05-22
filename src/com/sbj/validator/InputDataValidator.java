package com.sbj.validator;

import javax.xml.bind.ValidationException;

public class InputDataValidator {
	private static InputDataValidator inputDataValidator = null;
	private InputDataValidator() {
		
	}
	
	public static InputDataValidator getInputDataValidator() {
		synchronized (InputDataValidator.class) {
			if(inputDataValidator==null) {
				inputDataValidator = new InputDataValidator();
			}
			return inputDataValidator;
		}
	}
	/**
	 * validate Players count as per guideline 1<= players <=1000
	 * @param noOfPlayers
	 * @throws ValidationException
	 */
	public void validatePlayersCount(int noOfPlayers) throws ValidationException {
		if(!(noOfPlayers >=1 && noOfPlayers <=1000)) {
			throw new ValidationException("Players count exceed limit.. allowed limit is 1 to 1000..Exiting");
		}
	}
	/**
	 * validate test case count as per guideline 1<= players <=10
	 * @param noofTestCase
	 * @throws ValidationException
	 */
	public void testCaseNumberValidation(int noofTestCase) throws ValidationException {
		if(!(noofTestCase >=1 && noofTestCase <=10)) {
			throw new ValidationException("Test Case count exceed limit.. allowed limit is 1 to 10..Exiting");
		}
	}
	/**
	 * validate Strength/energy input as per guideline 1<= players <=100000
	 * @param strengthData
	 * @throws ValidationException
	 */
	public void validateStengthInput(int strengthData) throws ValidationException {
		if(!(strengthData >=1 && strengthData <=100000)) {
			throw new ValidationException("Strength/Energy exceed limit.. allowed limit is 1 to 100000..Exiting");
		}
	}
}

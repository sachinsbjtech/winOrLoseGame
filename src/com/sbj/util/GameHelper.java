package com.sbj.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.ValidationException;

import com.sbj.validator.InputDataValidator;

public class GameHelper {
	
	private static GameHelper gameHelper = null;
	private static InputDataValidator inputDataValidator = InputDataValidator.getInputDataValidator();
	
	private GameHelper() {
		
	}
	
	public static GameHelper getGameHelper() {
		synchronized (GameHelper.class) {
			if(gameHelper==null) {
				gameHelper = new GameHelper();
			}
			return gameHelper;
		}
	}
	
	/**
	 * Convert Strength input into Sorted List
	 * @param villainStrenghInput
	 * @return
	 * @throws ValidationException 
	 */
	public List<Integer> convertStrengthData(final String villainStrenghInput) throws ValidationException {
		final List<Integer> strengthList = new ArrayList<>();
		
		if(villainStrenghInput !=null) {
			String strengthArray[] = villainStrenghInput.split(" ");
			for(String strength : strengthArray) {
				if(!strength.isEmpty()) {
					int strengthValue = stringToInteger(strength.trim());
					inputDataValidator.validateStengthInput(strengthValue);
					strengthList.add(strengthValue);
				}
			}
		}
		// sort list so that minimum players energy is used to kill Villain
		Collections.sort(strengthList);
		return strengthList;
	}
	/**
	 * convert string to integer
	 * @param input
	 * @return
	 */
	public Integer stringToInteger(final String input) {
		return Integer.parseInt(input.trim());
	}
}

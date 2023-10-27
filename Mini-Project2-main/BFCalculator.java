

/**
 * A simple implementation of a calculator on BigFractions.
 *
 * @author Kevin Johanson
 * 2023
 */

 
public class BFCalculator {

	BigFraction storeValue; // the last value
	BigFraction registerValue; // the value that gets printed out when the register char is called
	
	char storeChar;
	
	// checks if the first char of a string is numeric
	// Arguments: String str
	// Output: boolean
	// 
	public boolean isNumeric(String str) {
		try {
			Double.parseDouble(str.substring(0, 1));
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
		
	}

	/* Evaluates a String expression (no PEMDAS);
	 * 
	 * 
	 */
	public BigFraction evaluate(String exp) {
		BigFraction value = new BigFraction(0);


		String exprSplit[] = exp.split("\\s+"); // splits the expression using spaces into an array

		// goes through the expression and sees if a # or sign appears twice in a row ex. + + or 1/3 1/2
		for (int i = 0; i < exprSplit.length - 1 ; i++) {
			// checks if double symbols ex + +
			if (exprSplit[i].equals("+") ||  exprSplit[i].equals("/") ||  exprSplit[i].equals("-") ||  exprSplit[i].equals("*")) {
					
				if (exprSplit[i+1].equals("+") ||  exprSplit[i+1].equals("/") ||  exprSplit[i+1].equals("-") ||  exprSplit[i+1].equals("*")) {
						System.err.println("Incorrect syntax: two symbols in a row");
						return null;
					} // if 
			} // if
			if (isNumeric(exprSplit[i])) {
				if (isNumeric(exprSplit[i+1])) {
					System.err.println("Incorrect syntax: Two Numbers in a row");
					return null;
				} // if 
			}// if 
		} // for

		if (exprSplit[0] == "") {  // if expression is empty return 0
			return value;
		} else {// sets the initial value to the first number in the expression if the expression has a length
			if (exprSplit[0].length() == 1 && (exprSplit[0].charAt(0) == storeChar)) { // checks to see if the first value in the expression is the store value
			
				value = (registerValue);
			} else {
			value = new BigFraction(exprSplit[0]);
			}
		}

		for (int i = 0; i < exprSplit.length ; i++) { // traverse through split string expression

			if( ((int) exprSplit[i].charAt(0)) >= 48 && ((int) exprSplit[i].charAt(0)) <= 57 ) { // checks to see if array index is a #


			} else if (exprSplit[i].equals("+")) { // calls BigFractions add function if + is found

				if (exprSplit[i+1].length() == 1 && (exprSplit[i+1].charAt(0) == storeChar)) { // checks to see if the value after the symbol in the expression is the store value
					value = value.add(registerValue);
				} else {
					value = value.add(new BigFraction(exprSplit[i+1]));
				}
			} else if (exprSplit[i].equals("-")) { // calls BigFractions subtract function if - is found


				if (exprSplit[i+1].length() == 1 && (exprSplit[i+1].charAt(0) == storeChar)) { // checks to see if the value after the symbol in the expression is the store value
					value = value.subtract(registerValue);
				} else {
					value = value.subtract(new BigFraction(exprSplit[i+1]));
				}
				
			} else if (exprSplit[i].equals("/")) { // calls BigFractions divide function if / is found


				if (exprSplit[i+1].length() == 1 && (exprSplit[i+1].charAt(0) == storeChar)) { // checks to see if the value after the symbol in the expression is the store value
					value = value.divide(registerValue);
				} else {
				value = value.divide(new BigFraction(exprSplit[i+1]));
				}
				
			} else if (exprSplit[i].equals("*")) { // calls BigFractions multiply function if * is found


				if (exprSplit[i+1].length() == 1 && (exprSplit[i+1].charAt(0) == storeChar)) { // checks to see if the value after the symbol in the expression is the store value
					value = value.multiply(registerValue);
				} else {
				value = value.multiply(new BigFraction(exprSplit[i+1]));
				}
				
			}
			
		}
		storeValue = value;
		return value;
	}
	/*
	 * sets storeChar to the char given 
	 * 
	 */
	public void store(char register) {
		storeChar = register;
		registerValue = storeValue;
		
	}
	


}

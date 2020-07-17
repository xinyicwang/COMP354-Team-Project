package gui;

import java.util.ArrayList;

public class EquationParser {

	
	EquationParser(){
		
	}
	
	public double parseEquation(ArrayList<Symbol> symbols)  throws TooManyDecimalException{
		
		validateEquation(symbols);
		
		
		
		return 0;
		
	}
	
	private void validateEquation(ArrayList<Symbol> symbols)  throws TooManyDecimalException{
		
		if(symbols.size() == 1) {
			throw new TooManyDecimalException("Error: Invalid decimal at position 3 (123.456.789)");
		}
		
		//
		
		
	}
}

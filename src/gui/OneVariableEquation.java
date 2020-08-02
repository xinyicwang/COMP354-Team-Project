
package gui;

import Exceptions.InfinityException;
import Exceptions.InvalidInputException;

public interface OneVariableEquation {
	public double calculate(double x) throws InfinityException, InvalidInputException;
}

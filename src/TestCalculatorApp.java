import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Exceptions.InfinityException;
import function.PowersOfPI;
import function.EPower;
import function.Exponentiation;
import function.StandardDeviation;
import function.Mean;

class TestCalculatorApp {

	final double DELTA = 0.0000001;
	
	@Test
	void test1PI() throws InfinityException {
		PowersOfPI calculator = new PowersOfPI();
		assertEquals(Math.pow(Math.PI, 0), calculator.calculatePowersOfPi(0), DELTA);
	}

	@Test
	void test2PI() throws InfinityException {
		PowersOfPI calculator = new PowersOfPI();
		assertEquals(Math.pow(Math.PI, 2.1), calculator.calculatePowersOfPi(2.1), DELTA);
	}

	@Test
	void test3PI() throws InfinityException {
		PowersOfPI calculator = new PowersOfPI();
		assertEquals(Math.pow(Math.PI, -1), calculator.calculatePowersOfPi(-1), DELTA);
	}

	@Test
	void test4PI() throws InfinityException {
		PowersOfPI calculator = new PowersOfPI();
		assertEquals(Math.pow(Math.PI, 100), calculator.calculatePowersOfPi(100), DELTA);
	}
	
	@Test
	void test1E() {
		EPower calculator = new EPower();
		assertEquals(Math.pow(Math.E, 0), calculator.ePower(0), DELTA);
	}

	@Test
	void test2E() {
		EPower calculator = new EPower();
		assertEquals(Math.pow(Math.E, 2.1), calculator.ePower(2.1), DELTA);
	}

	@Test
	void test3E() {
		EPower calculator = new EPower();
		assertEquals(Math.pow(Math.E, -1), calculator.ePower(-1), DELTA);
	}

	@Test
	void test4E() {
		EPower calculator = new EPower();
		assertEquals(Math.pow(Math.E, 100), calculator.ePower(100), DELTA);
	}
	
	@Test
	void test1XY() {
		Exponentiation calculator = new Exponentiation();
		assertEquals(Math.pow(5, 0), calculator.powerInt(5,0), DELTA);
	}

	@Test
	void test2XY() {
		Exponentiation calculator = new Exponentiation();
		assertEquals(Math.pow(3, 2.1), calculator.powerInt(3, 2.1), DELTA);
	}

	@Test
	void test3XY() {
		Exponentiation calculator = new Exponentiation();
		assertEquals(Math.pow(2, -1), calculator.powerInt(2.2, -1), DELTA);
	}

	@Test
	void test4XY() {
		Exponentiation calculator = new Exponentiation();
		assertEquals(Math.pow(2.2, 100), calculator.powerInt(4, 100), DELTA);
	}

}

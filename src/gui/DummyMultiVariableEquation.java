<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> origin/standard-deviation
package gui;

import java.util.List;

public class DummyMultiVariableEquation implements MultiVariableEquation {

	@Override
	public double calculate(List<Double> x) {
		// TODO Auto-generated method stub
		
		double total = 0;
		for(int i = 0; i < x.size();i++) {
			total+= x.get(i);
		}
		return total/x.size();
	}

}
<<<<<<< HEAD
=======
package gui;

import java.util.List;

public class DummyMultiVariableEquation implements MultiVariableEquation {

	@Override
	public double calculate(List<Double> x) {
		// TODO Auto-generated method stub
		
		double total = 0;
		for(int i = 0; i < x.size();i++) {
			total+= x.get(i);
		}
		return total/x.size();
	}

}
>>>>>>> origin/Thuyohn's_Branch
=======
>>>>>>> origin/standard-deviation

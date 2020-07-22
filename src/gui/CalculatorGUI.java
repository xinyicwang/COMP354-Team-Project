/*
 * CalculatorGUI
 * 
 * V0.4
 *
 * 2020-05-31
 * 
 */
package gui;

import function.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CalculatorGUI implements ActionListener {

	
	ArrayList<Double> inputs;
	EquationValue currentOperation;
	EquationType currentType;
	ArrayList<String> functionButtonLabels;
    MultiVariableEquation multiEquation;
    TwoVariableEquation twoEquation;
    OneVariableEquation singleEquation;
    
    MultiVariableEquation stdEquation;
    MultiVariableEquation madEquation;
    TwoVariableEquation powEquation;
    OneVariableEquation sinEquation;
    OneVariableEquation epowEquation;
    OneVariableEquation pipowEquation;
	
	
	
	ArrayList<JButton> functionButtons;
	
	enum EquationType{
		NONE,ONE,TWO,MULTI
	}
	
	enum EquationValue{
		NONE(-1),SIN(0),E(1),PI(2),POW(3),MAD(4),STDEV(5);
		private final int value;
	    private EquationValue(int value) {
	        this.value = value;
	    }

	    public int getValue() {
	        return value;
	    }
	}
	
    JTextField numberInput;
    
    public static void main(String[] args) {
        
        CalculatorGUI c = new CalculatorGUI();
        
        
    }
    
    /**
     * Initialize the GUI and all it's components.
     * 
     */
    public CalculatorGUI() {
        
    	inputs = new ArrayList<Double>();
    	functionButtons = new ArrayList<JButton>();
    	functionButtonLabels = new ArrayList<String>();
    	
    	currentOperation = null;
    	currentType = null;
    	
    	
    	/*   Add your equations here */
    	stdEquation =  new DummyMultiVariableEquation();
        madEquation =  new DummyMultiVariableEquation();
        powEquation =  new DummyTwoVariableEquation();
        sinEquation =  new DummySingleVariableEquation();
        epowEquation =  new DummySingleVariableEquation();
        pipowEquation =  new DummySingleVariableEquation();
    	
        JFrame frame = new JFrame("Transcendental Function Calculator");
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container contentPane = frame.getContentPane();
        contentPane.setPreferredSize(new Dimension(500,500));
        contentPane.setLayout(new GridBagLayout());
        
        
        numberInput = new JTextField("");
        GridBagConstraints inputConstraints = new GridBagConstraints();
        inputConstraints.gridheight = 1;
        inputConstraints.gridwidth = 6;
        inputConstraints.gridx = 0;
        inputConstraints.gridy = 0;
        inputConstraints.weightx = 1.0;
        inputConstraints.weighty = 1.0;
        inputConstraints.fill = GridBagConstraints.BOTH;
        frame.getContentPane().add(numberInput,inputConstraints); 
        
        this.makeButton(0, 1, "7", "7", frame);
        this.makeButton(1, 1, "8", "8", frame);
        this.makeButton(2, 1, "9", "9", frame);
        this.makeButton(0, 2, "4", "4", frame);
        this.makeButton(1, 2, "5", "5", frame);
        this.makeButton(2, 2, "6", "6", frame);
        this.makeButton(0, 3, "1", "1", frame);
        this.makeButton(1, 3, "2", "2", frame);
        
        this.makeButton(2, 3, "3", "3", frame);
        this.makeButton(0, 4, "0", "0", frame,1,2);
        this.makeButton(2, 4, ".", ".", frame);
        this.makeButton(3, 1,"clear","Clear",frame,1,2);
        this.makeButton(5, 1,"ce","CE",frame);
        functionButtons.add(EquationValue.SIN.value, this.makeButton(5, 3, "sincalc", "sin(x)", frame));
        functionButtons.add(EquationValue.E.value, this.makeButton(3, 2, "ecalc", "e^x", frame));
        functionButtons.add(EquationValue.PI.value, this.makeButton(3, 3, "picalc", "π^x", frame));
        functionButtons.add(EquationValue.POW.value, this.makeButton(4, 3, "powcalc", "x^y", frame));
        functionButtons.add(EquationValue.MAD.value, this.makeButton(5, 2, "madcalc", "MAD", frame));
        functionButtons.add(EquationValue.STDEV.value, this.makeButton(4, 2, "stdcalc", "stdev", frame));
        this.makeButton(3, 4, "equals", "=", frame);
        
        
        for(int i = 0; i < functionButtons.size();i++) {
        	functionButtonLabels.add(functionButtons.get(i).getText());
        }
        
        
        
        
        frame.pack();
        frame.setVisible(true);
    }
    
    private JButton makeButton(int x,int y,String actionName,String label, JFrame frame) {
    
    	return this.makeButton(x, y, actionName, label, frame,1,1);
    }
    
    private void toggleOtherFunctionButtons(EquationValue eq,boolean toggle) {
    	int val = eq.value;
    	for (int i = 0; i < functionButtons.size(); i++) {
            if(i != val) {
            	functionButtons.get(i).setEnabled(toggle);
            }
        }
    	
    	
    }
    
    private void toggleAllFunctionButtons(boolean toggle) {
    	for (int i = 0; i < functionButtons.size(); i++) {
            
            	functionButtons.get(i).setEnabled(toggle);
            
        }
    }
    
    private void restoreFunctionButtonLables() {
    	for(int i = 0; i < functionButtons.size();i++) {
        	functionButtons.get(i).setText(functionButtonLabels.get(i));
        }
    }

    private JButton makeButton(int x,int y,String actionName,String label, JFrame frame,int height, int width) {
    	JButton myButton = new JButton(label);
        GridBagConstraints myConstraints = new GridBagConstraints();
        myConstraints.gridheight = height;
        myConstraints.gridwidth = width;
        myConstraints.gridx = x;
        myConstraints.gridy = y;
        myConstraints.weightx = 1.0;
        myConstraints.weighty = 1.0;
        myConstraints.fill = GridBagConstraints.BOTH;
        frame.getContentPane().add(myButton,myConstraints);
        myButton.addActionListener(this);
        myButton.setActionCommand(actionName);
        return myButton;
    }
    
    
    /**
     * Function called when a button is pressed. Determines which button is pressed, and either 
     * appends or modifies the calculator text, or else performs a calculation involving the text.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
    	
    	boolean isBlank = false;
        String command = e.getActionCommand();
        String text = numberInput.getText();
        
        boolean isNumeric = true;
        try {
            int i = Integer.parseInt(command);
        } catch (NumberFormatException nfe) {
            isNumeric = false;
        }
        
        if (isNumeric) {
            numberInput.setText(text+command);
            return;
        }
        if(text.equals("")) {
        	isBlank = true;
        	text = "0";
        }
        
        
        
        
        EquationType eq = EquationType.NONE;
        switch(command) {
        
        	case ".":
            	if(!text.contains(".")) {
            		numberInput.setText(text+command);
            	}
        		break;
        	case "clear":
            	numberInput.setText("");
        		break;
        	case "ecalc":
        		currentOperation = EquationValue.E;
        		eq = EquationType.ONE;
        		singleEquation = epowEquation;
        		break;
        	case "picalc":
        		currentOperation = EquationValue.PI;
        		eq = EquationType.ONE;
        		singleEquation = pipowEquation;
        		break;
        	case "sincalc":
        		currentOperation = EquationValue.SIN;
        		eq = EquationType.ONE;
        		singleEquation = sinEquation;
        		break;
        	case "powcalc":
        		currentOperation = EquationValue.POW;
        		eq = EquationType.TWO;
        		twoEquation = powEquation;
        		break;
        	case "stdcalc":
        		currentOperation = EquationValue.STDEV;
        		eq = EquationType.MULTI;
        		multiEquation = stdEquation;
        		functionButtons.get(EquationValue.STDEV.value).setText("Next");
        		break;
        	case "madcalc":
        		currentOperation = EquationValue.MAD;
        		eq = EquationType.MULTI;
        		multiEquation = madEquation;
        		functionButtons.get(EquationValue.MAD.value).setText("Next");
        		break;
        	
        	
        }
        double num = Double.parseDouble(text);
        double res = num;
        
        if(command.equals("equals")) {
        	
        	switch(currentType) {
        		case TWO:
        			double numA = inputs.get(0);
        			double numB = num;
        			res = twoEquation.calculate(numA, numB);
                	numberInput.setText(res+"");
                	inputs.clear();
                	currentType = null;
                	currentOperation = null;
                	toggleAllFunctionButtons(true);
        			break;
        		case MULTI:
        			if(!isBlank) {
        				inputs.add(num);
        			}
        			res = multiEquation.calculate(inputs);
        			numberInput.setText(res+"");
                	inputs.clear();
                	currentType = null;
                	currentOperation = null;
                	toggleAllFunctionButtons(true);
                	restoreFunctionButtonLables();
        	}
        }
        
	    switch(eq) {
	        case NONE:
	        	return;
	        case ONE:
            	res = singleEquation.calculate(num);
            	numberInput.setText(res+"");
	        	break;
	        case TWO:
	        	currentType = eq;
	        	inputs.add(0, num);
            	numberInput.setText("");
            	toggleAllFunctionButtons(false);
	        	
	        	break;
	        case MULTI:
	        	currentType = eq;
	        	inputs.add(num);
	        	numberInput.setText("");
	        	toggleOtherFunctionButtons(currentOperation,false);
	        	break;
	        
        }
        
        
        
    }
    
    

}

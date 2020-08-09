/*
 * CalculatorGUI
 * Team J - COMP 354
 * Concordia University 
 * 
 * Version: Iteration II
 *
 * Due: August 10th 2020
 * 
 * Copyright notice
 * 
 * 
 */
package gui;

import function.*;

import javax.swing.*;

import Exceptions.InfinityException;
import Exceptions.InvalidInputException;
import Exceptions.OverflowException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * This class manages the GUI of the calculator, as well as the logic behind 
 * selecting/chaining equations and handling overflows.
 * 
 * @Version 1.0 24 July 2020
 * 
 * @author Jenny Velicogna
 * 
 */

public class CalculatorGUI implements ActionListener {
	
	
	/**
	 * Instance variables - doc comment
	 */
	
	final int MAX_VALUE = 1000000000;
	final int MAX_CHARACTERS = 20;
	
	boolean toClear;
	boolean errorDisplayed;
	
	ArrayList<Double> inputs;
	EquationValue currentOperation;
	EquationType currentType;
	
	ArrayList<String> functionButtonLabels;
	ArrayList<JButton> functionButtons;
	JButton equalsButton;
	JTextField numberInput;
    
	MultiVariableEquation multiEquation;
    TwoVariableEquation twoEquation;
    OneVariableEquation singleEquation;
    
    MultiVariableEquation stdEquation;
    MultiVariableEquation madEquation;
    TwoVariableEquation powEquation;
    OneVariableEquation sinEquation;
    OneVariableEquation epowEquation;
    OneVariableEquation pipowEquation;
	
	
    
    
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
	
    
    public static void main(String[] args) {
        
        CalculatorGUI c = new CalculatorGUI();
        
        
    }
    
    /**
     * Constructor
     * 
     */
    public CalculatorGUI() {
        
    	errorDisplayed = false;
    	toClear = false;
    	inputs = new ArrayList<Double>();
    	functionButtons = new ArrayList<JButton>();
    	functionButtonLabels = new ArrayList<String>();
    	
    	currentOperation = EquationValue.NONE;
    	currentType = EquationType.NONE;
    	
    	
    	/*   Add your equations here */
    	stdEquation =  new StandardDeviation();
        madEquation =  new Mean();
        powEquation =  new Exponentiation();
        sinEquation =  new SinCalculator();
        epowEquation =  new EPower();
        pipowEquation =  new PowersOfPI();
    	
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
        numberInput.setText("0");
        numberInput.setEditable(false);
        numberInput.setHorizontalAlignment(JTextField.CENTER);
        Font bigFont = numberInput.getFont().deriveFont(Font.PLAIN, 36f);
        numberInput.setFont(bigFont);
        
        this.makeButton(0, 1, "7", "7", frame);
        this.makeButton(1, 1, "8", "8", frame);
        this.makeButton(2, 1, "9", "9", frame);
        this.makeButton(0, 2, "4", "4", frame);
        this.makeButton(1, 2, "5", "5", frame);
        this.makeButton(2, 2, "6", "6", frame);
        this.makeButton(0, 3, "1", "1", frame);
        this.makeButton(1, 3, "2", "2", frame);
        this.makeButton(2, 3, "3", "3", frame);
        this.makeButton(0, 4, "negative", "+/-", frame,1,1);
        this.makeButton(1, 4, "0", "0", frame,1,1);
        this.makeButton(2, 4, ".", ".", frame);
        this.makeButton(3, 1,"clear","Clear",frame,1,2);
        this.makeButton(5, 1,"ce","CE",frame);
        
        functionButtons.add(EquationValue.SIN.value, this.makeButton(5, 3, "sincalc", "sin(x)", frame));
        functionButtons.add(EquationValue.E.value, this.makeButton(3, 2, "ecalc", "e^x", frame));
        functionButtons.add(EquationValue.PI.value, this.makeButton(3, 3, "picalc", "π^x", frame));
        functionButtons.add(EquationValue.POW.value, this.makeButton(4, 3, "powcalc", "x^y", frame));
        functionButtons.add(EquationValue.MAD.value, this.makeButton(5, 2, "madcalc", "MAD", frame));
        functionButtons.add(EquationValue.STDEV.value, this.makeButton(4, 2, "stdcalc", "stdev", frame));
        equalsButton = this.makeButton(3, 4, "equals", "=", frame);
        
        equalsButton.setEnabled(false);
        
        
        
        for (int i = 0; i < functionButtons.size();i++) {
        	functionButtonLabels.add(functionButtons.get(i).getText());
        }
        
        
        
        
        frame.pack();
        frame.setVisible(true);
    }
    
    /**
     * @param int x position of button with GridBagLayout
     * @param int y position of button with GridBagLayout
     * @param String actionName the action command to be associated with the button
     * @param String label the label of the button
     * @param JFrame frame the frame to apply the button to
     * 
     * @return the created button
     */
    private JButton makeButton(int x,int y,String actionName,String label, JFrame frame) {
    
    	return this.makeButton(x, y, actionName, label, frame,1,1);
    }
    
    /**
     * @param x position of button with GridBagLayout
     * @param y position of button with GridBagLayout
     * @param actionName the action command to be associated with the button
     * @param label the label of the button
     * @param frame the frame to apply the button to
     * @param height the height of the button with GridBagLayout
     * @param width the width of the button with GridBagLayout
     * 
     * @return the created button
     */
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
     * @param eq the type of equation of the button to skip
     * @param toggle the state to change the buttons to
     */
    private void toggleOtherFunctionButtons(EquationValue eq,boolean toggle) {
    	int val = eq.value;
    	for (int i = 0; i < functionButtons.size(); i++) {
            if(i != val) {
            	functionButtons.get(i).setEnabled(toggle);
            }
        }
    	equalsButton.setEnabled(!toggle);
    	
    }
    
    /**
     * @param toggle the state to change the buttons to
     */
    
    private void toggleAllFunctionButtons(boolean toggle) {
    	for (int i = 0; i < functionButtons.size(); i++) {
            
            	functionButtons.get(i).setEnabled(toggle);
            
        }
    	equalsButton.setEnabled(!toggle);
    }
    
    
    /**
     * Restores the original lables of the buttons
     */
    private void restoreFunctionButtonLables() {
    	for (int i = 0; i < functionButtons.size();i++) {
        	functionButtons.get(i).setText(functionButtonLabels.get(i));
        }
    }

    
    /**
     * 
     * @param d the double to convert
     * @return the string value
     * @throws OverflowException If the double is larger then the calculators limit
     */
    String doubleToString(double d) throws OverflowException {
    	
    	if(Math.abs(d) >= MAX_VALUE) {
    		throw new OverflowException();
    	}
    	if(d % 1.0 != 0) {
    		return String.valueOf(d);
    	}
    	else {
    		DecimalFormat df = new DecimalFormat("#");
    		String formatted = df.format(d); 
    		return formatted;
    	}
    }
    
    /** 
     * {@inheritDoc} 
     * 
     * 
     * */
    @Override
    public void actionPerformed(ActionEvent e) {
    	
    	
    	boolean isBlank = false;
        String command = e.getActionCommand();
        String text = numberInput.getText();
        
        if(errorDisplayed) {
    		if(!command.equals("clear") && !command.equals("ce")) {
    			return;
    		}
    		if(command.equals("ce")) {
    			command = "clear";
    		}
    	}
    	
        
        boolean isNumeric = true;
        try {
            int i = Integer.parseInt(command);
        } catch (NumberFormatException nfe) {
            isNumeric = false;
        }
        
        if (isNumeric) {
        	if(toClear) {
        		text = "";
        	}
        	if(text.equals("0")) {
        		text = "";
        	}
        	String result = text+command;
        	double d = Double.parseDouble(result);
        	if(Math.abs(d) < MAX_VALUE && result.length() < MAX_CHARACTERS) {
        		numberInput.setText(text+command);
        	}
            toClear = false;
            return;
        }
        
        
        
        
        
        EquationType eq = EquationType.NONE;
        switch(command) {
        
        	case ".":
        		if(toClear) {
        			text = "0";
        		}
            	if(!text.contains(".")) {
            		numberInput.setText(text+command);
            	}
            	toClear = false;
        		break;
        	case "negative":
        		if(toClear) {
        			text = "0";
        		}
            	if(!text.contains("-")) {
            		numberInput.setText("-"+text);
            	}else {
            		numberInput.setText(text.replace("-", ""));
            	}
            	toClear = false;
        		break;
        	case "clear":
            	inputs.clear();
            	currentOperation = EquationValue.NONE;
            	currentType = EquationType.NONE;
            	toggleAllFunctionButtons(true);
            	restoreFunctionButtonLables();
        		/*Fall-through*/
        	case "ce":
            	numberInput.setText("0");
            	toClear = false;
            	errorDisplayed = false;
        		return;
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
				try {
					res = twoEquation.calculate(numA, numB);
				} catch (InvalidInputException e1) {
					
					numberInput.setText(e1.getMessage());
    				errorDisplayed = true;
				}
        			try {
        				numberInput.setText(doubleToString(res));
        			}
        			catch(OverflowException err)
        			{
        				numberInput.setText("Overflow Error!");
        				errorDisplayed = true;
        				
        			}
                	inputs.clear();
                	currentType = EquationType.NONE;
                	currentOperation = EquationValue.NONE;
                	toggleAllFunctionButtons(true);
                	toClear = true;
        			break;
        		case MULTI:
        			if(!isBlank) {
        				inputs.add(num);
        			}
        			res = multiEquation.calculate(inputs);
        			try {
        				numberInput.setText(doubleToString(res));
        			}
        			catch(OverflowException err)
        			{
        				numberInput.setText("Overflow Error!");
        				errorDisplayed = true;
        				
        			}
                	inputs.clear();
                	currentType = EquationType.NONE;
                	currentOperation = EquationValue.NONE;
                	toggleAllFunctionButtons(true);
                	restoreFunctionButtonLables();
                	toClear = true;
                	break;
			default:
				break;
        	}
        }
        
	    switch(eq) {
	        case NONE:
	        	return;
	        case ONE:
				
				try {
					res = singleEquation.calculate(num);
				} catch (InfinityException e1) {
					numberInput.setText("Overflow Error!");
					e1.printStackTrace();
				} catch (InvalidInputException e1) {
					numberInput.setText(e1.getMessage());
					e1.printStackTrace();
				}
				
            	try {
    				numberInput.setText(doubleToString(res));
    			}
    			catch(OverflowException err)
    			{
    				numberInput.setText("Overflow Error!");
    				errorDisplayed = true;
    				
    			}
            	toClear = true;
	        	break;
	        case TWO:
	        	currentType = eq;
	        	inputs.add(0, num);
            	numberInput.setText("0");
            	toggleAllFunctionButtons(false);
	        	
	        	break;
	        case MULTI:
	        	currentType = eq;
	        	inputs.add(num);
	        	numberInput.setText("0");
	        	toggleOtherFunctionButtons(currentOperation,false);
	        	break;
        }
        
        
    }
    
    

}

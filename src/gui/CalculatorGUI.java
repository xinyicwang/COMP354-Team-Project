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
	EquationValue equation;
	
	ArrayList<JButton> functionButtons;
	
	enum EquationType{
		NONE,ONE,TWO,MULTI
	}
	
	enum EquationValue{
		SIN(0),E(1),PI(2),POW(3),MAD(4),STDEV(5);
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
        functionButtons.add(EquationValue.E.value, this.makeButton(3, 2, "ecalc", "e^x", frame));
        functionButtons.add(EquationValue.PI.value, this.makeButton(3, 3, "picalc", "π^x", frame));
        functionButtons.add(EquationValue.POW.value, this.makeButton(4, 3, "powcalc", "x^y", frame));
        functionButtons.add(EquationValue.SIN.value, this.makeButton(5, 3, "sincalc", "sin(x)", frame));
        functionButtons.add(EquationValue.STDEV.value, this.makeButton(4, 2, "stdcalc", "stdev", frame));
        functionButtons.add(EquationValue.MAD.value, this.makeButton(5, 2, "madcalc", "MAD", frame));
        this.makeButton(3, 4, "equals", "=", frame);
        
        
        
        
        
        
        
        frame.pack();
        frame.setVisible(true);
    }
    
    private JButton makeButton(int x,int y,String actionName,String label, JFrame frame) {
    
    	return this.makeButton(x, y, actionName, label, frame,1,1);
    }
    
    private void disableOtherFunctionButtons(EquationValue eq) {
    	int val = eq.value;
    	for (int i = 0; i < functionButtons.size(); i++) {
            if(i != val) {
            	functionButtons.get(i).setEnabled(false);
            }
        }
    	
    	
    }
    
    private void enableAllFunctionButtons() {
    	for (int i = 0; i < functionButtons.size(); i++) {
            
            	functionButtons.get(i).setEnabled(true);
            
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
        	text = "0";
        }
        
        
        
        
        EquationType eq = EquationType.NONE;
        MultiVariableEquation multiEquation = null;
        TwoVariableEquation twoEquation = null;
        OneVariableEquation singleEquation = null;
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
        		eq = EquationType.ONE;
        		singleEquation = new DummySingleVariableEquation();
        		break;
        	case "picalc":
        		eq = EquationType.ONE;
        		singleEquation = new DummySingleVariableEquation();
        		break;
        	case "sincalc":
        		eq = EquationType.ONE;
        		singleEquation = new DummySingleVariableEquation();
        		break;
        	case "powcalc":
        		eq = EquationType.TWO;
        		twoEquation = new DummyTwoVariableEquation();
        		break;
        	case "stdcalc":
        		eq = EquationType.MULTI;
        		multiEquation = new DummyMultiVariableEquation();
        		break;
        	case "madcalc":
        		eq = EquationType.MULTI;
        		multiEquation = new DummyMultiVariableEquation();
        	
        	
        }
        double num = Double.parseDouble(text);
        double res = num;
	    switch(eq) {
	        case NONE:
	        	return;
	        case ONE:
            	res = singleEquation.calculate(num);
	        	break;
	        case TWO:
	        	break;
	        case MULTI:
	        	break;
	        
        }
	    numberInput.setText(res+"");
        
        
        
    }
    
    

}

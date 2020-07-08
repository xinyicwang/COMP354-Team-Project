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

public class CalculatorGUI implements ActionListener {

    JTextField numberInput;
    
    public static void main(String[] args) {
        
        CalculatorGUI c = new CalculatorGUI();
    }
    
    /**
     * Initialize the GUI and all it's components.
     * 
     */
    public CalculatorGUI() {
        
    
        JFrame frame = new JFrame("Transcendental Function Calculator");
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container contentPane = frame.getContentPane();
        contentPane.setPreferredSize(new Dimension(500,500));
        contentPane.setLayout(new GridBagLayout());
        
        
        numberInput = new JTextField("");
        GridBagConstraints inputConstraints = new GridBagConstraints();
        inputConstraints.gridheight = 1;
        inputConstraints.gridwidth = 4;
        inputConstraints.gridx = 0;
        inputConstraints.gridy = 0;
        inputConstraints.weightx = 1.0;
        inputConstraints.weighty = 1.0;
        inputConstraints.fill = GridBagConstraints.BOTH;
        frame.getContentPane().add(numberInput,inputConstraints); 
        
        JButton buttonNumber7 = new JButton("7");
        GridBagConstraints numberConstraints7 = new GridBagConstraints();
        numberConstraints7.gridheight = 1;
        numberConstraints7.gridwidth = 1;
        numberConstraints7.gridx = 0;
        numberConstraints7.gridy = 1;
        numberConstraints7.weightx = 1.0;
        numberConstraints7.weighty = 1.0;
        numberConstraints7.fill = GridBagConstraints.BOTH;
        frame.getContentPane().add(buttonNumber7,numberConstraints7); 
        buttonNumber7.addActionListener(this);
        buttonNumber7.setActionCommand("7");
        
        JButton buttonNumber8 = new JButton("8");
        GridBagConstraints numberConstraints8 = new GridBagConstraints();
        numberConstraints8.gridheight = 1;
        numberConstraints8.gridwidth = 1;
        numberConstraints8.gridx = 1;
        numberConstraints8.gridy = 1;
        numberConstraints8.weightx = 1.0;
        numberConstraints8.weighty = 1.0;
        numberConstraints8.fill = GridBagConstraints.BOTH;
        frame.getContentPane().add(buttonNumber8,numberConstraints8); 
        buttonNumber8.addActionListener(this);
        buttonNumber8.setActionCommand("8"); 
        
        JButton buttonNumber9 = new JButton("9");
        GridBagConstraints numberConstraints9 = new GridBagConstraints();
        numberConstraints9.gridheight = 1;
        numberConstraints9.gridwidth = 1;
        numberConstraints9.gridx = 2;
        numberConstraints9.gridy = 1;
        numberConstraints9.weightx = 1.0;
        numberConstraints9.weighty = 1.0;
        numberConstraints9.fill = GridBagConstraints.BOTH;
        frame.getContentPane().add(buttonNumber9,numberConstraints9); 
        buttonNumber9.addActionListener(this);
        buttonNumber9.setActionCommand("9");
        
        JButton buttonNumber4 = new JButton("4");
        GridBagConstraints numberConstraints4 = new GridBagConstraints();
        numberConstraints4.gridheight = 1;
        numberConstraints4.gridwidth = 1;
        numberConstraints4.gridx = 0;
        numberConstraints4.gridy = 2;
        numberConstraints4.weightx = 1.0;
        numberConstraints4.weighty = 1.0;
        numberConstraints4.fill = GridBagConstraints.BOTH;
        frame.getContentPane().add(buttonNumber4,numberConstraints4);
        buttonNumber4.addActionListener(this);
        buttonNumber4.setActionCommand("4");
        
        JButton buttonNumber5 = new JButton("5");
        GridBagConstraints numberConstraints5 = new GridBagConstraints();
        numberConstraints5.gridheight = 1;
        numberConstraints5.gridwidth = 1;
        numberConstraints5.gridx = 1;
        numberConstraints5.gridy = 2;
        numberConstraints5.weightx = 1.0;
        numberConstraints5.weighty = 1.0;
        numberConstraints5.fill = GridBagConstraints.BOTH;
        frame.getContentPane().add(buttonNumber5,numberConstraints5);
        buttonNumber5.addActionListener(this);
        buttonNumber5.setActionCommand("5");
        
        JButton buttonNumber6 = new JButton("6");
        GridBagConstraints numberConstraints6 = new GridBagConstraints();
        numberConstraints6.gridheight = 1;
        numberConstraints6.gridwidth = 1;
        numberConstraints6.gridx = 2;
        numberConstraints6.gridy = 2;
        numberConstraints6.weightx = 1.0;
        numberConstraints6.weighty = 1.0;
        numberConstraints6.fill = GridBagConstraints.BOTH;
        frame.getContentPane().add(buttonNumber6,numberConstraints6);
        buttonNumber6.addActionListener(this);
        buttonNumber6.setActionCommand("6");
        
        JButton buttonNumber1 = new JButton("1");
        GridBagConstraints numberConstraints1 = new GridBagConstraints();
        numberConstraints1.gridheight = 1;
        numberConstraints1.gridwidth = 1;
        numberConstraints1.gridx = 0;
        numberConstraints1.gridy = 3;
        numberConstraints1.weightx = 1.0;
        numberConstraints1.weighty = 1.0;
        numberConstraints1.fill = GridBagConstraints.BOTH;
        frame.getContentPane().add(buttonNumber1,numberConstraints1);
        buttonNumber1.addActionListener(this);
        buttonNumber1.setActionCommand("1");
        
        JButton buttonNumber2 = new JButton("2");
        GridBagConstraints numberConstraints2 = new GridBagConstraints();
        numberConstraints2.gridheight = 1;
        numberConstraints2.gridwidth = 1;
        numberConstraints2.gridx = 1;
        numberConstraints2.gridy = 3;
        numberConstraints2.weightx = 1.0;
        numberConstraints2.weighty = 1.0;
        numberConstraints2.fill = GridBagConstraints.BOTH;
        frame.getContentPane().add(buttonNumber2,numberConstraints2);
        buttonNumber2.addActionListener(this);
        buttonNumber2.setActionCommand("2");

        JButton buttonNumber3 = new JButton("3");
        GridBagConstraints numberConstraints3 = new GridBagConstraints();
        numberConstraints3.gridheight = 1;
        numberConstraints3.gridwidth = 1;
        numberConstraints3.gridx = 2;
        numberConstraints3.gridy = 3;
        numberConstraints3.weightx = 1.0;
        numberConstraints3.weighty = 1.0;
        numberConstraints3.fill = GridBagConstraints.BOTH;
        frame.getContentPane().add(buttonNumber3,numberConstraints3);
        buttonNumber3.addActionListener(this);
        buttonNumber3.setActionCommand("3");
        
        JButton buttonNumber0 = new JButton("0");
        GridBagConstraints numberConstraints0 = new GridBagConstraints();
        numberConstraints0.gridheight = 1;
        numberConstraints0.gridwidth = 2;
        numberConstraints0.gridx = 0;
        numberConstraints0.gridy = 4;
        numberConstraints0.weightx = 1.0;
        numberConstraints0.weighty = 1.0;
        numberConstraints0.fill = GridBagConstraints.BOTH;
        frame.getContentPane().add(buttonNumber0,numberConstraints0);
        buttonNumber0.addActionListener(this);
        buttonNumber0.setActionCommand("0");
        
        JButton buttonDot = new JButton(".");
        GridBagConstraints numberConstraintsdot = new GridBagConstraints();
        numberConstraintsdot.gridheight = 1;
        numberConstraintsdot.gridwidth = 1;
        numberConstraintsdot.gridx = 2;
        numberConstraintsdot.gridy = 4;
        numberConstraintsdot.weightx = 1.0;
        numberConstraintsdot.weighty = 1.0;
        numberConstraintsdot.fill = GridBagConstraints.BOTH;
        frame.getContentPane().add(buttonDot,numberConstraintsdot);
        buttonDot.addActionListener(this);
        buttonDot.setActionCommand(".");

        JButton buttonClear = new JButton("Clear");
        GridBagConstraints clearConstraints = new GridBagConstraints();
        clearConstraints.gridheight = 1;
        clearConstraints.gridwidth = 1;
        clearConstraints.gridx = 3;
        clearConstraints.gridy = 1;
        clearConstraints.weightx = 1.0;
        clearConstraints.weighty = 1.0;
        clearConstraints.fill = GridBagConstraints.BOTH;
        frame.getContentPane().add(buttonClear,clearConstraints);
        buttonClear.addActionListener(this);
        buttonClear.setActionCommand("clear");
        
        JButton buttoneCalc = new JButton("e^x");
        GridBagConstraints eCalcConstraints = new GridBagConstraints();
        eCalcConstraints.gridheight = 1;
        eCalcConstraints.gridwidth = 1;
        eCalcConstraints.gridx = 3;
        eCalcConstraints.gridy = 2;
        eCalcConstraints.weightx = 1.0;
        eCalcConstraints.weighty = 1.0;
        eCalcConstraints.fill = GridBagConstraints.BOTH;
        frame.getContentPane().add(buttoneCalc,eCalcConstraints);
        buttoneCalc.addActionListener(this);
        buttoneCalc.setActionCommand("ecalc");
        
        JButton buttonPiCalc = new JButton("π^x");
        GridBagConstraints piCalcConstraints = new GridBagConstraints();
        piCalcConstraints.gridheight = 1;
        piCalcConstraints.gridwidth = 1;
        piCalcConstraints.gridx = 3;
        piCalcConstraints.gridy = 3;
        piCalcConstraints.weightx = 1.0;
        piCalcConstraints.weighty = 1.0;
        piCalcConstraints.fill = GridBagConstraints.BOTH;
        frame.getContentPane().add(buttonPiCalc,piCalcConstraints);
        buttonPiCalc.addActionListener(this);
        buttonPiCalc.setActionCommand("picalc");
        
        
        JButton buttonPowCalc = new JButton("x^x");
        GridBagConstraints powCalcConstraints = new GridBagConstraints();
        powCalcConstraints.gridheight = 1;
        powCalcConstraints.gridwidth = 1;
        powCalcConstraints.gridx = 3;
        powCalcConstraints.gridy = 4;
        powCalcConstraints.weightx = 1.0;
        powCalcConstraints.weighty = 1.0;
        powCalcConstraints.fill = GridBagConstraints.BOTH;
        frame.getContentPane().add(buttonPowCalc,powCalcConstraints);
        buttonPowCalc.addActionListener(this);
        buttonPowCalc.setActionCommand("powcalc");
        
        
        
        
        
        frame.pack();
        frame.setVisible(true);
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
        if (command.equals(".")) {
        	if(!text.contains(".")) {
        		numberInput.setText(text+command);
        	}
            return;
        }
        
        if (command.equals("clear")) {
        	numberInput.setText("");
            return;
        }

        if (command.equals("ecalc")) {
        	double num = Double.parseDouble(text);
        	double res = EPower.ePower(num);
        	numberInput.setText(res+"");
            return;
        }
        
        if (command.equals("picalc")) {
        	double num = Double.parseDouble(text);
        	double res = PowersOfPI.powersOfPi(num);
        	numberInput.setText(res+"");
            return;
        }
    }
    
    private float performeCalc(float input) {
    	/* TODO: Redirect to class file. Implement function */
    	
    	return input / 2;
    	
    }
    
    private float performPiCalc(float input) {
    	/* TODO: Redirect to class file. Implement function */
    	
    	return input * 2;
    	
    }

}

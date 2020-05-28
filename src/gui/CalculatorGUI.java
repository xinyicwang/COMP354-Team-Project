package gui;
import javax.swing.*;
import java.awt.*;

public class CalculatorGUI {

	public static void main(String[] args) {
		
		
		//Todo: Figure out how to make it fill the screen
		
		
		JFrame frame = new JFrame("My First GUI");
		frame.setSize(300,300);
		
		Container contentPane = frame.getContentPane();
		//contentPane.setPreferredSize(new Dimension(200,200));
		contentPane.setLayout(new GridBagLayout());
		
		

		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton buttonNumber1 = new JButton("1");
		JButton buttonNumber2 = new JButton("2");
		JButton buttonNumber3 = new JButton("3");
		JButton buttonNumber4 = new JButton("4");
		JButton buttonNumber5 = new JButton("5");
		JButton buttonNumber6 = new JButton("6");
		JButton buttonNumber7 = new JButton("7");
		JButton buttonNumber8 = new JButton("8");
		JButton buttonNumber9 = new JButton("9");
		JButton buttonNumber0 = new JButton("0");
		JButton buttonDot = new JButton(".");
		
		JTextField numberinput = new JTextField("955522666.42");
		
		
		GridBagConstraints inputConstraints = new GridBagConstraints();
		inputConstraints.gridheight = 1;
		inputConstraints.gridwidth = 3;
		inputConstraints.gridx = 0;
		inputConstraints.gridy = 0;
		inputConstraints.fill = GridBagConstraints.HORIZONTAL;
		frame.getContentPane().add(numberinput,inputConstraints); // Adds Button to content pane of frame
		
		
		GridBagConstraints numberConstraints7 = new GridBagConstraints();
		numberConstraints7.gridheight = 1;
		numberConstraints7.gridwidth = 1;
		numberConstraints7.gridx = 0;
		numberConstraints7.gridy = 1;
		frame.getContentPane().add(buttonNumber7,numberConstraints7); // Adds Button to content pane of frame
		
		GridBagConstraints numberConstraints8 = new GridBagConstraints();
		numberConstraints8.gridheight = 1;
		numberConstraints8.gridwidth = 1;
		numberConstraints8.gridx = 1;
		numberConstraints8.gridy = 1;
		frame.getContentPane().add(buttonNumber8,numberConstraints8); // Adds Button to content pane of frame
		
		GridBagConstraints numberConstraints9 = new GridBagConstraints();
		numberConstraints9.gridheight = 1;
		numberConstraints9.gridwidth = 1;
		numberConstraints9.gridx = 2;
		numberConstraints9.gridy = 1;
		frame.getContentPane().add(buttonNumber9,numberConstraints9); // Adds Button to content pane of frame
		
		GridBagConstraints numberConstraints4 = new GridBagConstraints();
		numberConstraints4.gridheight = 1;
		numberConstraints4.gridwidth = 1;
		numberConstraints4.gridx = 0;
		numberConstraints4.gridy = 2;
		frame.getContentPane().add(buttonNumber4,numberConstraints4);
		
		GridBagConstraints numberConstraints5 = new GridBagConstraints();
		numberConstraints5.gridheight = 1;
		numberConstraints5.gridwidth = 1;
		numberConstraints5.gridx = 1;
		numberConstraints5.gridy = 2;
		frame.getContentPane().add(buttonNumber5,numberConstraints5);
		
		GridBagConstraints numberConstraints6 = new GridBagConstraints();
		numberConstraints6.gridheight = 1;
		numberConstraints6.gridwidth = 1;
		numberConstraints6.gridx = 2;
		numberConstraints6.gridy = 2;
		frame.getContentPane().add(buttonNumber6,numberConstraints6);
		
		GridBagConstraints numberConstraints1 = new GridBagConstraints();
		numberConstraints1.gridheight = 1;
		numberConstraints1.gridwidth = 1;
		numberConstraints1.gridx = 0;
		numberConstraints1.gridy = 3;
		frame.getContentPane().add(buttonNumber1,numberConstraints1);
		
	    GridBagConstraints numberConstraints2 = new GridBagConstraints();
	    numberConstraints2.gridheight = 1;
	    numberConstraints2.gridwidth = 1;
	    numberConstraints2.gridx = 1;
	    numberConstraints2.gridy = 3;
	    frame.getContentPane().add(buttonNumber2,numberConstraints2);

	    GridBagConstraints numberConstraints3 = new GridBagConstraints();
	    numberConstraints3.gridheight = 1;
	    numberConstraints3.gridwidth = 1;
	    numberConstraints3.gridx = 2;
	    numberConstraints3.gridy = 3;
	    frame.getContentPane().add(buttonNumber3,numberConstraints3);
	    
	    GridBagConstraints numberConstraints0 = new GridBagConstraints();
	    numberConstraints0.gridheight = 1;
	    numberConstraints0.gridwidth = 2;
	    numberConstraints0.gridx = 0;
	    numberConstraints0.gridy = 4;
	    numberConstraints0.fill = GridBagConstraints.HORIZONTAL;
	    frame.getContentPane().add(buttonNumber0,numberConstraints0);
		
		
	    GridBagConstraints numberConstraintsdot = new GridBagConstraints();
	    numberConstraintsdot.gridheight = 1;
	    numberConstraintsdot.gridwidth = 1;
	    numberConstraintsdot.gridx = 2;
	    numberConstraintsdot.gridy = 4;
	    numberConstraints0.fill = GridBagConstraints.HORIZONTAL;
	    frame.getContentPane().add(buttonDot,numberConstraintsdot);
		
		frame.setVisible(true);
	}

}

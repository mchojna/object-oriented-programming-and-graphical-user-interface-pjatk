package mvc;

import java.awt.*;
import javax.swing.*;

public class View {
	
	private JFrame frame;
	private JLabel label;
	private JButton button;
	private JTextField textField;
	
	View() {
		frame = new JFrame();
		label= new JLabel("Result");
		textField = new JTextField("Enter x here");
		button = new JButton("Sum");
		
		frame.setLayout(new FlowLayout());
		frame.add(label);
		frame.add(textField);
		frame.add(button);
		
		frame.pack();
		frame.setVisible(true);
	}

	public JLabel getLabel() {
		return label;
	}

	public JButton getButton() {
		return button;
	}

	public JTextField getTextField() {
		return textField;
	}
	
}
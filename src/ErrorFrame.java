import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ErrorFrame extends JFrame {
	private final JTextField error;
	private final JButton button;
	
	public ErrorFrame() {
		super("Error");
		setLayout(new FlowLayout());
		
		error = new JTextField("Enter only number for Student ID");
		error.setEditable(false);
		add(error);
		
		button = new JButton("Return to Menu");
		add(button);

		
		ButtonHandler handler = new ButtonHandler();
		button.addActionListener(handler);
	
	}
	
	private class ButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) 
		{
			IOFrame ioFrame = new IOFrame();
	  		ioFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  		ioFrame.setSize(300,300);
	  		ioFrame.setVisible(true);
		}
	}
}

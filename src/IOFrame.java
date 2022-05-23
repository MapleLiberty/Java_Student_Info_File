import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.*;

public class IOFrame extends JFrame{
	private final JButton enterButton;
	private final JButton loadButton;
	
	public IOFrame(){
		super("Student Information");
		setLayout(new FlowLayout());
		
		enterButton = new JButton("Enter Info");
		add(enterButton);
		
		loadButton = new JButton("Load Info");
		add(loadButton);
		
		ButtonHandlerOne handler1 = new ButtonHandlerOne();
		enterButton.addActionListener(handler1);
		ButtonHandlerTwo handler2 = new ButtonHandlerTwo();
		loadButton.addActionListener(handler2);
	}
	
	private class ButtonHandlerOne implements ActionListener {
	      @Override
	      public void actionPerformed(ActionEvent event)
	      {
	    	  EnterFrame ioFrame = new EnterFrame();
	  		  ioFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  		  ioFrame.setSize(300,300);
	  		  ioFrame.setVisible(true);
	      }
	 } 
	
	private class ButtonHandlerTwo implements ActionListener {
	      @Override
	      public void actionPerformed(ActionEvent event)
	      {
	    	  LoadFrame ioFrame = new LoadFrame();
	  		  ioFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  		  ioFrame.setSize(300,300);
	  		  ioFrame.setVisible(true);
	      }
	 } 
	
}



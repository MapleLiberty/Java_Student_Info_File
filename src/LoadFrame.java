import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoadFrame extends JFrame {
	private final JTextArea textArea;
	private final JButton returnButton;
	
	Student[] student;

	public LoadFrame(){
		super("Student Information");
		setLayout(new FlowLayout());
		
		String studentString = new String();
		
		try {
			ReadInfo r = new ReadInfo();
			r.read();
			

			int count = r.getCount();
			student = new Student[count];
			student = r.getStudent();
			
			for(int i = 0; i < count; i++) {
				studentString += student[i].toString();
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		

		textArea = new JTextArea(studentString,10,15);
		textArea.setEditable(false);
		add(new JScrollPane(textArea));
	

		returnButton = new JButton("Return to Menu");
		add(returnButton);
		
		ButtonHandlerOne handler1 = new ButtonHandlerOne();
		returnButton.addActionListener(handler1);
	}
	
	private class ButtonHandlerOne implements ActionListener {
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

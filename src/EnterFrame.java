import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EnterFrame extends JFrame {
	private final JTextField textField1;
	private final JTextField textField2;
	private final JTextField textField3;
	private final JTextField input1;
	private final JTextField input2;
	private final JTextField input3;
	
	private final JButton courseButton;
	
	private Student student;
	
	public EnterFrame(){
		super("Student Information");
		setLayout(new FlowLayout());

		try {
			student = new Student();
		}
		catch(Exception e) {
			System.out.println("EnterFrame()");
			System.out.println(e);
		}
		
		Box box1 = Box.createHorizontalBox();
		textField1 = new JTextField("Student ID");
		textField1.setEditable(false);
		box1.add(textField1);
		input1 = new JTextField(10);
		box1.add(input1);
		add(box1);
		
		Box box2 = Box.createHorizontalBox();
		textField2 = new JTextField("First Name");
		textField2.setEditable(false);
		box2.add(textField2);
		input2 = new JTextField(10);
		box2.add(input2);
		add(box2);
		
		Box box3 = Box.createHorizontalBox();
		textField3 = new JTextField("Last Name");
		textField3.setEditable(false);
		box3.add(textField3);
		input3 = new JTextField(10);
		box3.add(input3);
		add(box3);
		
		courseButton = new JButton("Add course");
		add(courseButton);
		ButtonHandler handler = new ButtonHandler();
		courseButton.addActionListener(handler);
	}
	
	private class ButtonHandler implements ActionListener {
	      @Override
	      public void actionPerformed(ActionEvent event)
	      { 
	    	  try {
	    	    student.setID(Integer.parseInt(input1.getText()));
			    student.setfName(input2.getText());
			    student.setlName(input3.getText());
		    	CourseFrame courseFrame = new CourseFrame(student);
		  		courseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  		courseFrame.setSize(300,300);
		  		courseFrame.setVisible(true);
	    	  }
	    	  catch(Exception e) {
	    		ErrorFrame errorFrame = new ErrorFrame();
	    		errorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    		errorFrame.setSize(300,300);
	    		errorFrame.setVisible(true);
	    	  }
	      }
	   } 
}

import java.awt.*;
import java.awt.event.*;
import java.util.InputMismatchException;

import javax.swing.*;

public class CourseFrame extends JFrame {
	private final JTextField textField1;
	private final JTextField input1;

	private final JButton courseButton1;
	private final JButton courseButton2;
	
	private Student student;
	
	public CourseFrame(){
		super("Student Information");
		setLayout(new FlowLayout());
		
		textField1 = new JTextField("Course Name");
		textField1.setEditable(false);
		add(textField1);
		input1 = new JTextField(10);
		add(input1);
		
		courseButton1 = new JButton("Add more course");
		add(courseButton1);
		courseButton2= new JButton("End");
		add(courseButton2);
		ButtonHandlerOne handler1 = new ButtonHandlerOne();
		courseButton1.addActionListener(handler1);
		ButtonHandlerTwo handler2 = new ButtonHandlerTwo();
		courseButton2.addActionListener(handler2);
	}
	
	public CourseFrame(Student s) {
		this();
		student = new Student();
		student = s;
	}
	
	private class ButtonHandlerOne implements ActionListener {
	      @Override
	      public void actionPerformed(ActionEvent event)
	      {	
	    	  try {
	    	    student.setCourse(input1.getText());
	    	  }
	    	  catch(Exception e) {
	    		  System.out.println(e);
	    	  }
	    	  
	    	  CourseFrame ioFrame = new CourseFrame(student);
	  		  ioFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  		  ioFrame.setSize(300,300);
	  		  ioFrame.setVisible(true);
	      }
	} 
	
	private class ButtonHandlerTwo implements ActionListener {
	      @Override
	      public void actionPerformed(ActionEvent event)
	      {
	    	  try {
	    		student.resizeCourses();
	  		    WriteInfo w = new WriteInfo(student);
	  			w.write();	
	  		  }
	  		  catch(Exception e) {
	  			System.out.println(e);
	  		  }
	    	  
	    	  IOFrame ioFrame = new IOFrame();
	  		  ioFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  		  ioFrame.setSize(300,300);
	  		  ioFrame.setVisible(true);
	      }
	} 
}

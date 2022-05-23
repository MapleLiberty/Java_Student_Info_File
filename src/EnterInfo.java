import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EnterInfo {
	Scanner scanner;
	Student student;
	
	public EnterInfo() {
		scanner = null;
		student = new Student();
	}
	
	public Student enter() {
		try {
			scanner = new Scanner(System.in);
			
			System.out.println("Enter student id: ");
			int id = scanner.nextInt();
			
			System.out.println("Enter first name: ");
			String fName = scanner.next();
		
			System.out.println("Enter last name: ");
			String lName = scanner.next();
			
			String[] rawCourses = new String[100];
			int index = 0;
			while(true) {
				System.out.println("Enter course name: ");
				String course = scanner.next();
				rawCourses[index++] = course;
				
				System.out.println("Are there any more courses? 1) Yes 2) No");
				
				int flag = scanner.nextInt();

				if(flag == 2) 
					break;
			}
			int count = 0;
			int ind = 0;
			while(true) {
				String test = rawCourses[ind++];
				if(test != null)
					count++;
				else
					break;
			}
			String[] filteredCourses = new String[count];
			for(int i = 0; i < count; i++)
				filteredCourses[i] = rawCourses[i];
			
			scanner.close();
			
			student.setID(id);
			student.setfName(fName);
			student.setlName(lName);
			student.setCourses(filteredCourses);
			
			System.out.println("Entered");
			System.out.println(student);
			
		}
		catch(InputMismatchException e) {
			System.out.println("Please enter the right type of input");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return student;
	}
}

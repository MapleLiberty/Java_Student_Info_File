import java.io.*;

public class ReadInfo {
	FileInputStream fis;
	ObjectInputStream ois;
	Student temp;
	Student student[];
	int count;
	boolean keepRead;
	
	public ReadInfo() {
		try {
			fis = null;
			ois = null;
			temp = new Student();
			count = 0;
			keepRead = true;
		}
		catch(Exception e) {
			System.out.println("ReadInfo()");
			System.out.println(e);
		}
	}
	
	public int countStudent() {
		try {
			fis = new FileInputStream("File.out");
			ois = new ObjectInputStream(fis);
			
			while(keepRead) {
				if(fis.available() != 0) {
					temp = (Student)ois.readObject();
					count++;
				}
				else {
					keepRead = false;
				}
			}
			
			fis.close();
		}
		catch(Exception e) {
			System.out.println("countStudent()");
			System.out.println(e);
			System.out.println("This exception may happen at the first Input");
		}
		
		return count;
	}
	
	public void read() {
		try {			
			student = new Student[countStudent()];
			
			fis = new FileInputStream("File.out");
			ois = new ObjectInputStream(fis);
			
			for(int i = 0; i < count; i++) {
				student[i] = (Student)ois.readObject();
			}
			
			fis.close();
			
		}
		catch(IOException e) {
			System.out.println("read()");
			System.out.println(e);
			System.out.println("This exception may happen at the first Input");
		}
		catch(Exception e) {
			System.out.println("read()");
			System.out.println(e);
			System.out.println("This exception may happen at the first Input");
		}
	}
	
	public Student[] getStudent() {
		return student;
	}
	
	public Student getStudentByID(int i) {
		return student[i];
	}
	
	public int getCount() {
		return count;
	}
}

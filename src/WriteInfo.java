import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteInfo {
	FileOutputStream fos;
	ObjectOutputStream oos;
	Student[] student;
	
	public WriteInfo(Student student) {
		try {
			fos = null;			
			oos = null;
			
			ReadInfo r = new ReadInfo();
			r.read();
			
			this.student = new Student[r.countStudent()+1];
			
			for(int i = 0; i < r.countStudent(); i++) {
				this.student[i] = r.getStudentByID(i);
			}
			this.student[r.countStudent()] = student;
		}
		catch(Exception e) {
			System.out.println("WriteInfo()");
			System.out.println(e);
		}
	}
	
	public void write() {
		try {
			fos = new FileOutputStream("File.out");
			
			oos = new ObjectOutputStream(fos);
			
			for(Student s: student) {
				oos.writeObject(s);
			}
			
			oos.flush();
			fos.close();
		}
		catch(IOException e) {
			System.out.println("write()");
			System.out.println(e);
		}
		catch(Exception e) {
			System.out.println("write()");
			System.out.println(e);
		}
	}
}

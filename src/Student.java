
public class Student implements java.io.Serializable {	
	int stdID;
	String firstName;
	String lastName;
	String courses[];
	
	int i; // index for course array
	
	public Student() {
		i = 0;
		courses = new String[30];
	}
	
	public Student(int id,String fName,String lName,String[] coursesArray) {
		stdID = id;
		firstName = fName;
		lastName = lName;
		courses = coursesArray;
	}
	
	public String toString() {
		String re = "Student id:  "+ getID() + "\nFirst Name:  "+ getfName() + "\nLast Name:   " + getlName() + "\nCourse(s):";
		for(String course: courses) {
			re += "\n"+course;
		}
		re += "\n\n";
		return re;
	}
	
	public void setID(int id){
		stdID = id;
	}
	
	public void setfName(String fName){
		firstName = fName;
	}
	
	public void setlName(String lName){
		lastName = lName;
	}
	
	public void setCourse(String course) {
		this.courses[i++] = course;
	}
	
	public void setCourses(String[] coursesArray) {
		courses = coursesArray;
	}
	
	public int getID() {
		return stdID;
	}
	
	public String getfName() {
		return firstName;
	}
	

	public String getlName() {
		return lastName;
	}
	
	public String[] getCourses() {
		return courses;
	}
	
	public String printCourses() {
		String re = new String();
		for(String course: courses) {
			re += course + "\n";
		}
		return re;
	}
	
	public void resizeCourses() {
		int count = 0;
		for(int j = 0;j < courses.length;j++) {
			if(courses[j] != null) {
				count++;
			}
			else
				break;
		}
		String[] newCourses = new String[count];
		for(int j = 0;j < count;j++) {
			newCourses[j] = courses[j];
		}
		courses = newCourses;
	}
}

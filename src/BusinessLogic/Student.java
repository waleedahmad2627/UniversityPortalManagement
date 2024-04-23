package BusinessLogic;

import java.util.ArrayList;

public class Student extends User {
	private String rollNo;
	private double cgpa;
	private ArrayList<Course> registeredCourses;
	
	public Student(){
		rollNo = "";
		cgpa= 0;
		registeredCourses = new ArrayList<Course>(); 
	}
	
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", Name=" + Name + ", email=" + email + ", password=" + password
				+ ", cgpa=" + cgpa + ", registeredCourses=" + registeredCourses + "]";
	}
	
	
	public boolean registerNewCourse(Course c) {
		for(Course c1 :registeredCourses) {
			if(c1.getCourseCode().equals(c.getCourseCode())) {
				return false;
			}
		}
		c.newStudentEnrolled(rollNo);
		registeredCourses.add(c);
		return true;
	}
	 
	public String printFeeChallan() {
		String s = "Fast Nuces \n";
		s+="Student Fee Challan\n";
		s+="Your Name: " + this.Name + " Roll number: " + this.rollNo + "\n";
		s+="Your total Courses registered are " + this.registeredCourses.size() + "\n";
		int calc = 0;
		for(Course c:registeredCourses) {
			calc+= c.getCrdHrs()*8500;
		}
		s+="Total payable ammount is " + calc;
		return s;
	}
	
	
	public String viewProgress(String crsCode) {
		Course c1 = null;
		for(Course c: registeredCourses) {
			if(c.getCourseCode().equals(crsCode)) {
				c1 = c;
			}
		}
		if(c1!=null) {
			Marks m = c1.getStudentMarks(this.rollNo);
				String s ="Assignments: " +m.getAssignments().toString() + "\n";
				s+="Quizes: " + m.getQuizes().toString() + "\n";
				s+= "Sessionals: " + m.getSessionals().toString() + "\n";
				s+="Final marks: " + m.getFinalMarks().toString() + "\n" ;
				s+= "Grade: " + m.getGrade();
				return s;
		}
		return null;
	}
	
	public String viewAttendance(String crsCode) {
		Course c1 = null;
		for(Course c: registeredCourses) {
			if(c.getCourseCode().equals(crsCode)) {
				c1 = c;
			}
		}
		if(c1!=null) {
			Attendance a = c1.getStudentAttendance(this.rollNo);
			String s ="";
			for(int i = 0 ; i<a.getDate().size() ; i++) {
				s+=a.getDate().get(i)+"  " ;
				if( a.getPresence().get(i)) {
					s+= "Present \n";
				}
				else {
					s+= "Absent \n";
				}
			}
			return s;
		}
		return null;
	}
	
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public double getCgpa() {
		return cgpa;
	}
	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}
	public ArrayList<Course> getRegisteredCourses() {
		return registeredCourses;
	}
	public void setRegisteredCourses(ArrayList<Course> registeredCourses) {
		this.registeredCourses = registeredCourses;
	}
	
}

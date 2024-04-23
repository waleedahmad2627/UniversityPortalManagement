package BusinessLogic;

import java.io.Serializable;
import java.util.ArrayList;

public class studentRegister  implements Serializable {
	private ArrayList<Student> studentList;
	public studentRegister(){
		studentList = new ArrayList<Student>(); 
	} 
	
	public String verifyStudent(String email, String password) {
		for(Student t: studentList) {
			if(t.getEmail().equals(email) && t.getPassword().equals(password)) {
				return t.getRollNo();
			}
		}
		return null;
	}
	
	
	public boolean registerStudentCourse(Course c, String rollNo) {
		Student s1 = null;
		for(Student s: studentList) {
			if(s.getRollNo().equals(rollNo)) {
				s1= s;
			}
		}
		if(s1!=null) {
			return s1.registerNewCourse(c);
		}
		return false;
	}
	
	public String printFeeChallan(String rollNo) {
		Student s = null;
		for(Student c1:studentList) {
			if(c1.getRollNo().equals(rollNo)) {
				s = c1;
			}
		}
		if(s!=null) {
			return s.printFeeChallan();
		}
		return null;
	}
	
	public String viewProgress(String crsCode, String rollNo) {
		Student s = null;
		for(Student c1:studentList) {
			if(c1.getRollNo().equals(rollNo)) {
				s = c1;
			}
		}
		if(s!=null) {
			return s.viewProgress(crsCode);
		}
		return null;
	}
	
	public String viewAttendance(String crsCode, String rollNo) {
		Student s = null;
		for(Student c1:studentList) {
			if(c1.getRollNo().equals(rollNo)) {
				s = c1;
			}
		}
		if(s!=null) {
			return s.viewAttendance(crsCode);
		}
		return null;
	}
	
	public ArrayList<Student> getAllCourseStudents(Course c) {
		if(c==null) {
			return null;
		}
		//String s = "";
		ArrayList<Student> Students = new ArrayList<Student>();
		for(Student st : studentList) {
			for(Course c1 : st.getRegisteredCourses()) {
				if(c1.getCourseCode().equals(c.getCourseCode())) {
					//s+= st.getName() + " " + st.getRollNo() + "\n";
					Students.add(st);
				}
			}
		}
		return Students;
	}
	
	public boolean addNewStudent(String name, String email, String pass, String rollNo) {
		boolean flag= true;
		for(Student c1:studentList) {
			if(c1.getRollNo().equals(rollNo)) {
				flag= false;
			}
		}
		if (flag) {
			Student s = new Student();
			s.setCgpa(0);
			s.setEmail(email);
			s.setName(name);
			s.setPassword(pass);
			s.setRollNo(rollNo);
			studentList.add(s);
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public void setup(Course c) {
		Student s = new Student();
		s.setEmail("studentEmail");
		s.setPassword("studentPass");
		s.setRollNo("111");
		s.setName("waleed");
		s.registerNewCourse(c);
		studentList.add(s);
	}
	public boolean deleteStudent(String rollNo) {
		Student s = null;
		for(Student s1 : studentList) {
			if(s1.getRollNo().equals(rollNo)) {
				s=s1;
			}
		}
		if(s!=null) {			
			studentList.remove(s);
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "studentRegister [studentList=" + studentList + "]";
	}
	public ArrayList<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}

	public ArrayList<Course> getStudentCourses(String signedInId) {
		for(Student s:studentList) {
			if(s.getRollNo().equals(signedInId)) {
				return s.getRegisteredCourses();
			}
		}
		return null;
	}
	
}

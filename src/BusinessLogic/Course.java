package BusinessLogic;

import java.io.Serializable;
import java.util.ArrayList;

public class Course  implements Serializable {
	private String courseCode;
	private String courseName;
	private Integer crdHrs;
	private ArrayList<Marks> marks;
	private ArrayList<Attendance> attendance;
	public Course() {
		marks = new ArrayList<Marks>();
		attendance = new ArrayList<Attendance>();
		courseCode = courseName = "";
		crdHrs = 0;
	}
	
	
	public Course(String courseCode, String courseName, Integer crdHrs, ArrayList<Marks> marks,
			ArrayList<Attendance> attendance) {
		super();
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.crdHrs = crdHrs;
		this.marks = marks;
		this.attendance = attendance;
	}


	public void newStudentEnrolled(String rollNo) {
		Marks m = new Marks();
		Attendance a = new Attendance();
		m.setRollNo(rollNo);
		a.setRollNo(rollNo);
		marks.add(m);
		attendance.add(a);
		
	}

	public Marks getStudentMarks(String rollNo) {
		for(Marks m : this.marks) {
			if(m.getRollNo().equals(rollNo)) {
				return m;
			}
		}
		return null;
	}
	
	public Attendance getStudentAttendance(String rollNo) {
		for(Attendance m : this.attendance) {
			if(m.getRollNo().equals(rollNo)) {
				return m;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		return "Course [courseCode=" + courseCode + ", courseName=" + courseName + ", crdHrs=" + crdHrs + ", marks="
				+ marks + ", attendance=" + attendance + "]";
	}

	public String viewOnlyAP(String rollNo) {
		String s="";
		for(Attendance a: attendance) {
			if(a.getRollNo().equals(rollNo)) {
				for(int i = 0 ; i<a.getPresence().size(); i++) {
					if(a.getPresence().get(i)) {
						s+="P";
					}
					else {
						s+="A";
					}
				}
			}
		}
		return s;
	}

	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Integer getCrdHrs() {
		return crdHrs;
	}
	public void setCrdHrs(Integer crdHrs) {
		this.crdHrs = crdHrs;
	}
	public ArrayList<Marks> getMarks() {
		return marks;
	}
	public void setMarks(ArrayList<Marks> marks) {
		this.marks = marks;
	}
	public ArrayList<Attendance> getAttendance() {
		return attendance;
	}
	public void setAttendance(ArrayList<Attendance> attendance) {
		this.attendance = attendance;
	}
	
}

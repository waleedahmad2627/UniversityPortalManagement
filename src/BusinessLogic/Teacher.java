package BusinessLogic;

import java.util.ArrayList;

public class Teacher extends User {

	private String id;
	private ArrayList<Course> teachingCourses;
	public Teacher(){
		 id = "";
		teachingCourses = new ArrayList<Course>();
	}
	
	public String getId() {
		return id;
	}
	
	public boolean addTeachingCourse(Course c) {
		boolean flag = true;
		for(Course c1 :teachingCourses) {
			if(c1.getCourseCode().equals(c.getCourseCode())) {
				flag = false;
			}
		}
		if(flag) {
			teachingCourses.add(c);
			return true;
		}
		return false;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Teacher(String name, String email, String password, ArrayList<Course> teachingCourses) {
		super();
		this.Name = name;
		this.email = email;
		this.password = password;
		this.teachingCourses = teachingCourses;
	}

	@Override
	public String toString() {
		return "Teacher [name=" + Name + ", email=" + email + ", password=" + password + ", teachingCourses="
				+ teachingCourses + "]";
	}

	public void addNewTeachingCourse(Course c) {
		teachingCourses.add(c);
	}

	public ArrayList<Course> getTeachingCourses() {
		return teachingCourses;
	}
	public void setTeachingCourses(ArrayList<Course> teachingCourses) {
		this.teachingCourses = teachingCourses;
	}
	
	public boolean markAttendance(String crsCode, String rollNo, Boolean presence) {
		Course selected = null;
		for(Course c: teachingCourses) {
			if(c.getCourseCode().equals(crsCode)) {
				selected = c;
			}
		}
		if(selected!=null) {
			for(Attendance a : selected.getAttendance()) {
				if(a.getRollNo().equals(rollNo)) {
					a.getPresence().add(presence);
					a.getDate().add(java.time.LocalDate.now().toString());
					System.out.println("second");
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean updateAttendance(String crsCode, String rollNo, boolean presence, int index) {
		Course selected = null;
		for(Course c: teachingCourses) {
			if(c.getCourseCode().equals(crsCode)) {
				selected = c;
			}
		}
		if(selected!=null) {
			for(Attendance a : selected.getAttendance()) {
				if(a.getRollNo().equals(rollNo)) {
					a.getPresence().set(index, presence) ;
					
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean markAssignment(String crsCode, String rollNo, int score) {
		Course selected = null;
		for(Course c: teachingCourses) {
			if(c.getCourseCode().equals(crsCode)) {
				selected = c;
			}
		}
		if(selected!=null) {
			System.out.println("3");
			for(Marks m : selected.getMarks()) {
				if(m.getRollNo().equals(rollNo)) {
					System.out.println("4");
					m.getAssignments().add(score);
					return true;
				}
			}
		}
		return false;
	}
	
	
	public String viewAssignment(String crsCode, String rollNo) {
		Course selected = null;
		for(Course c: teachingCourses) {
			if(c.getCourseCode().equals(crsCode)) {
				selected = c;
			}
		}
		if(selected!=null) {
			System.out.println("3");
			for(Marks m : selected.getMarks()) {
				if(m.getRollNo().equals(rollNo)) {
					String s = m.getAssignments().toString();
					return s;
				}
			}
		}
		return null;
	}
	
	public String viewQuizes(String crsCode, String rollNo) {
		Course selected = null;
		for(Course c: teachingCourses) {
			if(c.getCourseCode().equals(crsCode)) {
				selected = c;
			}
		}
		if(selected!=null) {
			System.out.println("3");
			for(Marks m : selected.getMarks()) {
				if(m.getRollNo().equals(rollNo)) {
					String s = m.getQuizes().toString();
					return s;
				}
			}
		}
		return null;
	}
	
	public String viewSessionals(String crsCode, String rollNo) {
		Course selected = null;
		for(Course c: teachingCourses) {
			if(c.getCourseCode().equals(crsCode)) {
				selected = c;
			}
		}
		if(selected!=null) {
			System.out.println("3");
			for(Marks m : selected.getMarks()) {
				if(m.getRollNo().equals(rollNo)) {
					String s = m.getSessionals().toString();
					return s;
				}
			}
		}
		return null;
	}
	
	public String viewFinal(String crsCode, String rollNo) {
		Course selected = null;
		for(Course c: teachingCourses) {
			if(c.getCourseCode().equals(crsCode)) {
				selected = c;
			}
		}
		if(selected!=null) {
			for(Marks m : selected.getMarks()) {
				if(m.getRollNo().equals(rollNo)) {
					String s = m.getFinalMarks().toString();
					return s;
				}
			}
		}
		return null;
	}
	
	public String viewGrade(String crsCode, String rollNo) {
		Course selected = null;
		for(Course c: teachingCourses) {
			if(c.getCourseCode().equals(crsCode)) {
				selected = c;
			}
		}
		if(selected!=null) {
			for(Marks m : selected.getMarks()) {
				if(m.getRollNo().equals(rollNo)) {
					String s = m.getGrade().toString();
					return s;
				}
			}
		}
		return null;
	}
	
	public boolean markQuiz(String crsCode, String rollNo, int score) {
		Course selected = null;
		for(Course c: teachingCourses) {
			if(c.getCourseCode().equals(crsCode)) {
				selected = c;
			}
		}
		if(selected!=null) {
			for(Marks m : selected.getMarks()) {
				if(m.getRollNo().equals(rollNo)) {
					m.getQuizes().add(score);
					return true;
				}
			}
		}
		return false;
	}
	
	
	public boolean markSessional(String crsCode, String rollNo, int score) {
		Course selected = null;
		for(Course c: teachingCourses) {
			if(c.getCourseCode().equals(crsCode)) {
				selected = c;
			}
		}
		if(selected!=null) {
			for(Marks m : selected.getMarks()) {
				if(m.getRollNo().equals(rollNo)) {
					m.getSessionals().add(score);
					return true;
				}
			}
		}
		return false;
	}
	
	
	public boolean markFinal(String crsCode, String rollNo, int score) {
		Course selected = null;
		for(Course c: teachingCourses) {
			if(c.getCourseCode().equals(crsCode)) {
				selected = c;
			}
		}
		if(selected!=null) {
			for(Marks m : selected.getMarks()) {
				if(m.getRollNo().equals(rollNo)) {
					m.setFinalMarks(score);
					return true;
				}
			}
		}
		return false;
	}
	
	

	public boolean markGrade(String crsCode, String rollNo, String grade) {
		Course selected = null;
		for(Course c: teachingCourses) {
			if(c.getCourseCode().equals(crsCode)) {
				selected = c;
			}
		}
		if(selected!=null) {
			for(Marks m : selected.getMarks()) {
				if(m.getRollNo().equals(rollNo)) {
					m.setGrade(grade);
					return true;
				}
			}
		}
		return false;
	}
	
	
}

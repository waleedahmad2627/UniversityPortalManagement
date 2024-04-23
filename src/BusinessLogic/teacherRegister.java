package BusinessLogic;

import java.io.Serializable;
import java.util.ArrayList;

public class teacherRegister  implements Serializable {	
	private ArrayList<Teacher> teacherList;
	
	public teacherRegister(){
		teacherList = new ArrayList<Teacher>(); 
	
	}
	
	public void setup(Course c) {
		Teacher t = new Teacher();
		t.setEmail("teacherEmail");
		t.setPassword("teacherPass");
		t.setName("t1");
		t.setId("1");


		t.getTeachingCourses().add(c);
		teacherList.add(t);
	}
	
	public String verifyTeacher(String email, String password) {
		for(Teacher t: teacherList) {
			if(t.getEmail().equals(email) && t.getPassword().equals(password)) {
				return t.getId();
			}
		}
		return null;
	}
	
	public boolean addTeachingCourse(Course c) {
		return teacherList.get(0).addTeachingCourse(c);
	}
	
	
	public void addNewTeacher(Teacher t) {
		teacherList.add(t);
	}

	public ArrayList<Teacher> getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(ArrayList<Teacher> teacherList) {
		this.teacherList = teacherList;
	}

	@Override
	public String toString() {
		return "teacherRegister [teacherList=" + teacherList + "]";
	}
	
	public boolean markAttendance(String crsCode, String rollNo, Boolean presence, String id) {
		Teacher selected = null;
		for (Teacher t : teacherList) {
			if(t.getId().equals(id)) {
				System.out.println("First");
				selected = t;
			}
		}
		if(selected!=null) {
			return selected.markAttendance(crsCode, rollNo, presence);
		}
		return false;
	}
	
	public boolean updateAttendance(String crsCode, String rollNo, Boolean presence, String id, int index) {
		Teacher selected = null;
		for (Teacher t : teacherList) {
			if(t.getId().equals(id)) {
				System.out.println("First");
				selected = t;
			}
		}
		if(selected!=null) {
			return selected.updateAttendance(crsCode, rollNo, presence,index);
		}
		return false;
	}
	
	public String viewAssignment(String crsCode, String rollNo, String id) {
		Teacher selected = null;
		for (Teacher t : teacherList) {
			if(t.getId().equals(id)) {
				System.out.println("First");
				selected = t;
			}
		}
		if(selected!=null) {
			return selected.viewAssignment(crsCode, rollNo);
		}
		return null;
	}
	
	public String viewQuizes(String crsCode, String rollNo, String id) {
		Teacher selected = null;
		for (Teacher t : teacherList) {
			if(t.getId().equals(id)) {
				System.out.println("First");
				selected = t;
			}
		}
		if(selected!=null) {
			return selected.viewQuizes(crsCode, rollNo);
		}
		return null;
	}
	
	public String viewSessionals(String crsCode, String rollNo, String id) {
		Teacher selected = null;
		for (Teacher t : teacherList) {
			if(t.getId().equals(id)) {
				System.out.println("First");
				selected = t;
			}
		}
		if(selected!=null) {
			return selected.viewSessionals(crsCode, rollNo);
		}
		return null;
	}
	
	public String viewFinal(String crsCode, String rollNo, String id) {
		Teacher selected = null;
		for (Teacher t : teacherList) {
			if(t.getId().equals(id)) {
				System.out.println("First");
				selected = t;
			}
		}
		if(selected!=null) {
			return selected.viewFinal(crsCode, rollNo);
		}
		return null;
	}
	

	public String viewGrade(String crsCode, String rollNo, String id) {
		Teacher selected = null;
		for (Teacher t : teacherList) {
			if(t.getId().equals(id)) {
				System.out.println("First");
				selected = t;
			}
		}
		if(selected!=null) {
			return selected.viewGrade(crsCode, rollNo);
		}
		return null;
	}
	
	
	
	
	public boolean markAssignment(String crsCode, String rollNo, int score, String id) {
		Teacher selected = null;
		for (Teacher t : teacherList) {
			if(t.getId().equals(id)) {
				selected = t;
			}
		}
		if(selected!=null) {
			System.out.println("2");
			return selected.markAssignment(crsCode, rollNo, score);
		}
		return false;
	}
	
	
	public boolean markQuiz(String crsCode, String rollNo, int score, String id) {
		Teacher selected = null;
		for (Teacher t : teacherList) {
			if(t.getId().equals(id)) {
				selected = t;
			}
		}
		if(selected!=null) {
			return selected.markQuiz(crsCode, rollNo, score);
		}
		return false;
	}
	
	public boolean markSessional(String crsCode, String rollNo, int score, String id) {
		Teacher selected = null;
		for (Teacher t : teacherList) {
			if(t.getId().equals(id)) {
				selected = t;
			}
		}
		if(selected!=null) {
			return selected.markSessional(crsCode, rollNo, score);
		}
		return false;
	}
	
	public boolean markFinal(String crsCode, String rollNo, int score, String id) {
		Teacher selected = null;
		for (Teacher t : teacherList) {
			if(t.getId().equals(id)) {
				selected = t;
			}
		}
		if(selected!=null) {
			return selected.markFinal(crsCode, rollNo, score);
		}
		return false;
	}
	
	
	public boolean markGrade(String crsCode, String rollNo, String grade, String id) {
		Teacher selected = null;
		for (Teacher t : teacherList) {
			if(t.getId().equals(id)) {
				selected = t;
			}
		}
		if(selected!=null) {
			return selected.markGrade(crsCode, rollNo, grade);
		}
		return false;
	}
	
}

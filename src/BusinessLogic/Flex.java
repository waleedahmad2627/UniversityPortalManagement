package BusinessLogic;

import java.io.Serializable;
import java.util.ArrayList;

import DB.FileHandler;

public class Flex implements Serializable{
	private studentRegister sr;
	private teacherRegister tr;
	private courseRegister cr;
	private String signedInId;
	private String signedType;
	private Admin admin;
	private String selectedCourse;
	private String selectedStudent;
	
	public String getSignedInId() {
		return signedInId;
	}
	
	
	public studentRegister getSr() {
		return sr;
	}


	public void setSr(studentRegister sr) {
		this.sr = sr;
	}


	public teacherRegister getTr() {
		return tr;
	}


	public void setTr(teacherRegister tr) {
		this.tr = tr;
	}


	public courseRegister getCr() {
		return cr;
	}


	public void setCr(courseRegister cr) {
		this.cr = cr;
	}

	
	public boolean registerStudentCourse(String crsCode) {
		Course c1= cr.getCoursebyCode(crsCode);
		return sr.registerStudentCourse(c1, signedInId);
	}
	
	public String printFeeChallan() {
		return sr.printFeeChallan(signedInId);
	}
	
	public void setSignedInId(String signedInId) {
		this.signedInId = signedInId;
	}

	public String getSignedType() {
		return signedType;
	}

	public void setSignedType(String signedType) {
		this.signedType = signedType;
	}

	public Flex(){
	
		sr = new studentRegister();
		tr = new teacherRegister();
		cr = new courseRegister();
//		FileHandler fh = new FileHandler();
//		fh.saveFlex(this);
//		  = fh.getFlex()
////		cr = fh.getCourseList();
////		sr = fh.getStudentList();
////		tr = fh.getTeacherList();
		signedInId =  signedType = selectedCourse = selectedStudent = null;
		this.setup();
//		System.out.println(sr.printFeeChallan("111"));
		}
	
	public String getSelectedCourse() {
		return selectedCourse;
	}

	public void setSelectedCourse(String selectedCourse) {
		this.selectedCourse = selectedCourse;
	}

	public void setup() {
		cr.addNewCourse("111", "PF", 3);
		tr.setup(cr.getCourseList().get(0));
		sr.setup(cr.getCourseList().get(0));
		admin = new Admin();
		admin.setup();
		
	}
	
	public String viewOnlyAP(String rollNo) {
		return cr.getOnlyAP(rollNo, this.selectedCourse);
	}
	public ArrayList<Student> getAllCourseStudents() {
		return sr.getAllCourseStudents(cr.getCoursebyCode(selectedCourse));
	}
	
	public ArrayList<Course> getStudentCourses(){
		return sr.getStudentCourses(this.signedInId);
	}
	public String viewAssignments() {
		return tr.viewAssignment(selectedCourse,selectedStudent, signedInId);
	}
	
	public String viewQuizes() {
		return tr.viewQuizes(selectedCourse,selectedStudent, signedInId);
	}
	
	public String viewSessionals() {
		return tr.viewSessionals(selectedCourse,selectedStudent, signedInId);
	}
	
	public String viewFinal() {
		return tr.viewFinal(selectedCourse,selectedStudent, signedInId);
	}
	
	public String viewGrade() {
		return tr.viewGrade(selectedCourse,selectedStudent, signedInId);
	}
	
	public boolean checkUser(String email, String password, String type) {
		if(type.equals("admin") ||  type.equals("Admin")) {
			if(admin.getEmail().equals(email) && admin.getPassword().equals(password)) {
				signedType= "admin";
				return true;
			}
			return false;
		}
		else if(type.equals("teacher") || type.equals("Teacher")) {
			String temp = tr.verifyTeacher(email, password);
			if(temp!=null) {
				signedInId = temp;
				signedType = "teacher";
				return true;
			}
			return false;
		}
		else if(type.equals("Student") || type.equals("student")) {
			String temp = sr.verifyStudent(email, password);
			if(temp!=null) {
				signedInId = temp;
				signedType = "student";
				return true;
			}
			return false;
		}
		return false;
	}
	
	public String viewProgress() {
		if(signedType.equals("student")|| signedType.equals("Student")) {			
			return sr.viewProgress(this.selectedCourse, signedInId);
		}
		return null;
	}
	
	
	public String viewAttendance() {
		if(signedType.equals("student")|| signedType.equals("Student")) {			
			return sr.viewAttendance(this.selectedCourse, signedInId);
		}
		return null;
	}
	
	public void Logout() {
		signedInId = null;
		signedType = null;
		selectedCourse= null;
	}
	
	public ArrayList<Course> getAllCourses(){
		return cr.getCourseList();
	}
	
	public ArrayList<Student> getAllStudents(){
		return sr.getStudentList();
	}
	
	public boolean addNewStudent(String name, String pass, String rollNo) {
		if(signedType.equals("admin")) {
			return sr.addNewStudent(name, rollNo, pass, rollNo);
		}
		return false;
	}
	public boolean deleteStudent(String rollNo) {
		if(signedType.equals("admin")) {
			return sr.deleteStudent(rollNo);
		}
		return false;
	}
	public boolean addNewCourse(String crsCode, String crsName , int crhr) {
		if(signedType.equals("admin")) {
			Course c =  cr.addNewCourse(crsCode, crsName, crhr);
			if(c!=null) {
				return tr.addTeachingCourse(c);
			}
		}
		return false;
	}
	public boolean deleteCourse(String crscCode) {
		if(signedType.equals("admin")) {
			return cr.deleteCourse(crscCode);
		}
		return false;
	}
	
	
	
	public boolean markAttendance( String rollNo, boolean presence ) {
		if(signedType.equals("teacher")) {
			
			return tr.markAttendance(this.selectedCourse, rollNo, presence, signedInId);
		}
		return false;
	}

	public boolean updateAttendance( String rollNo, boolean presence ,int index) {
		if(signedType.equals("teacher")) {
			
			return tr.updateAttendance(this.selectedCourse, rollNo, presence, signedInId,index);
		}
		return false;
	}
	
	
	public boolean markAssignment( int score ) {
		if(signedType.equals("teacher")) {
			System.out.println("1");
			return tr.markAssignment(this.selectedCourse, this.selectedStudent, score, signedInId);
		}
		return false;
	}
	
	public boolean markQuiz( int score ) {
		if(signedType.equals("teacher")) {
			return tr.markQuiz(this.selectedCourse, this.selectedStudent, score, signedInId);
		}
		return false;
	}
	
	
	public boolean markSessional(  int score ) {
		if(signedType.equals("teacher")) {
			return tr.markSessional(this.selectedCourse, this.selectedStudent, score, signedInId);
		}
		return false;
	}
	
	public boolean markFinal( int score ) {
		if(signedType.equals("teacher")) {
			return tr.markFinal(this.selectedCourse, this.selectedStudent, score, signedInId);
		}
		return false;
	}
	
	public boolean markGrade(  String grade ) {
		if(signedType.equals("teacher")) {
			return tr.markGrade(this.selectedCourse, this.selectedStudent, grade, signedInId);
		}
		return false;
	}


	public String getSelectedStudent() {
		return selectedStudent;
	}


	public void setSelectedStudent(String selectedStudent) {
		this.selectedStudent = selectedStudent;
	}
	
	
}

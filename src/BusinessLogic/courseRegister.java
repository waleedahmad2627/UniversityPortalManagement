package BusinessLogic;

import java.io.Serializable;
import java.util.ArrayList;

public class courseRegister implements Serializable {
	private ArrayList<Course> courseList;
	
	public courseRegister(){
		courseList = new ArrayList<Course>();
	}
	public boolean deleteCourse(String crsCode) {
		Course c = null; 
		for(Course c1:courseList) {
			if(c1.getCourseCode().equals(crsCode)) {
				c = c1;
			}
		}
		if(c!=null) {			
			courseList.remove(c);
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public Course getCoursebyCode(String crsCode) {
		for(Course c1:courseList) {
			if(c1.getCourseCode().equals(crsCode)) {
				return c1;
			}
		}
		return null;
	}
	
	public String getOnlyAP(String rollNo, String crsCode) {
		for(Course c:courseList) {
			if(c.getCourseCode().equals(crsCode)) {
				return c.viewOnlyAP(rollNo);
			}
		}
		return null;
	}
	
	public Course addNewCourse(String crsCode, String crsName , int crhr) {
		boolean flag= true;
		for(Course c1:courseList) {
			if(c1.getCourseCode().equals(crsCode)) {
				flag= false;
			}
		}
		if(flag) {
		Course c = new Course();
		c.setCourseCode(crsCode);
		c.setCourseName(crsName);
		c.setCrdHrs(crhr);
		
		courseList.add(c);
		return c;
		}
		else {
			return null;
		}
	}
	
	public ArrayList<Course> getCourseList() {
		return courseList;
	}
	public void setCourseList(ArrayList<Course> courseList) {
		this.courseList = courseList;
	}
	@Override
	public String toString() {
		return "courseRegister [courseList=" + courseList + "]";
	}
	
}

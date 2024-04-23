package BusinessLogic;

import java.util.ArrayList;


abstract public class PersistanceHandler {
	public abstract void saveCourseList(courseRegister s);
	public abstract courseRegister getCourseList();
	public abstract void saveStudentList(studentRegister s);
	public abstract studentRegister getStudentList();
	public abstract void saveTeacherList(teacherRegister s);
	public abstract teacherRegister getTeacherList();
}

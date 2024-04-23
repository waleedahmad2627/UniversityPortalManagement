package DB;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import BusinessLogic.*;



public class FileHandler extends PersistanceHandler {

	@Override
	public void saveCourseList(courseRegister s) {
		try {

			ArrayList<Course> students = null;
			File f = new File("Course.ser");
			if (f.exists()) {
				//if file exists read arraylist object from existing file
//				students = readCustomer(); 
				if (students==null) {
					students = new ArrayList<Course>();	
				}
			}
			else {
				//if file does not exist create a new arraylist
				students = new ArrayList<Course>();
			}
//			f.delete();
//			students.add(s);
			// append mode does work properly with object output stream so read all
			// existing students in file and add in array, then add new student and
			// save array to file
			FileOutputStream fileOut = new FileOutputStream("Course.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(s);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}		
	}
	
	
	public void saveFlex(Flex ff) {
		try {

			ArrayList<Course> students = null;
			File f = new File("Flex.ser");
			if (f.exists()) {
				//if file exists read arraylist object from existing file
//				students = readCustomer(); 
				if (students==null) {
					students = new ArrayList<Course>();	
				}
			}
			else {
				//if file does not exist create a new arraylist
				students = new ArrayList<Course>();
			}
//			f.delete();
//			students.add(s);
			// append mode does work properly with object output stream so read all
			// existing students in file and add in array, then add new student and
			// save array to file
			FileOutputStream fileOut = new FileOutputStream("Flex.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(ff);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}	
	}
	
	
	public Flex getFlex() {
		// TODO Auto-generated method stub
		Flex students = null;
				try {
					FileInputStream fileIn = new FileInputStream("Flex.ser");
					ObjectInputStream in = new ObjectInputStream(fileIn);
					// read and save all students from file to array
//					if(fileIn.c)
					students = (Flex) in.readObject();
					in.close();
					fileIn.close();
				} catch (IOException i) {
					i.printStackTrace();
					return null;
				} catch (ClassNotFoundException c) {
					System.out.println("Flex class not found");
					c.printStackTrace();
					return null;
				}
				return students;
	}
	
	@Override
	public courseRegister getCourseList() {
		// TODO Auto-generated method stub
		courseRegister students = null;
		try {
			FileInputStream fileIn = new FileInputStream("Course.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			// read and save all students from file to array
//			if(fileIn.c)
			students = (courseRegister) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return null;
		} catch (ClassNotFoundException c) {
			System.out.println("Course class not found");
			c.printStackTrace();
			return null;
		}
		return students;
	}
	

	@Override
	public void saveStudentList(studentRegister s) {
		try {

			ArrayList<Student> students = null;
			File f = new File("Student.ser");
			if (f.exists()) {
				//if file exists read arraylist object from existing file
//				students = readCustomer(); 
				if (students==null) {
					students = new ArrayList<Student>();	
				}
			}
			else {
				//if file does not exist create a new arraylist
				students = new ArrayList<Student>();
			}
//			f.delete();
//			students.add(s);
			// append mode does work properly with object output stream so read all
			// existing students in file and add in array, then add new student and
			// save array to file
			FileOutputStream fileOut = new FileOutputStream("Student.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(s);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}		
	}

	@Override
	public studentRegister getStudentList() {
		// TODO Auto-generated method stub
		studentRegister students = null;
				try {
					FileInputStream fileIn = new FileInputStream("Student.ser");
					ObjectInputStream in = new ObjectInputStream(fileIn);
					// read and save all students from file to array
//					if(fileIn.c)
					students = (studentRegister) in.readObject();
					in.close();
					fileIn.close();
				} catch (IOException i) {
					i.printStackTrace();
					return null;
				} catch (ClassNotFoundException c) {
					System.out.println("Student class not found");
					c.printStackTrace();
				return null;
			}
		return students;
	}

	@Override
	public void saveTeacherList(teacherRegister s) {
		try {

			ArrayList<Teacher> students = null;
			File f = new File("Student.ser");
			if (f.exists()) {
				//if file exists read arraylist object from existing file
//				students = readCustomer(); 
				if (students==null) {
					students = new ArrayList<Teacher>();	
				}
			}
			else {
				//if file does not exist create a new arraylist
				students = new ArrayList<Teacher>();
			}
//			f.delete();
//			students.add(s);
			// append mode does work properly with object output stream so read all
			// existing students in file and add in array, then add new student and
			// save array to file
			FileOutputStream fileOut = new FileOutputStream("Teacher.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(s);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}		
	}

	@Override
	public teacherRegister getTeacherList() {
		// TODO Auto-generated method stub
		teacherRegister students = null;
		try {
			FileInputStream fileIn = new FileInputStream("Teacher.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			// read and save all students from file to array
//			if(fileIn.c)
			students = (teacherRegister) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return null;
		} catch (ClassNotFoundException c) {
			System.out.println("Teacher class not found");
			c.printStackTrace();
		return null;
	}
		return students;
	}



}

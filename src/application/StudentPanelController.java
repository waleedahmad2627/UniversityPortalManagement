package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import BusinessLogic.Course;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class StudentPanelController implements Initializable {

    @FXML
    private Button ChallanBtn;

    @FXML
    private ListView<String> CourseList;

    @FXML
    private Button RegisterBtn;

    @FXML
    private Button ViewAttendanceBtn;

    @FXML
    private Button ViewMarksbtn;

    @FXML
    private Button logout;

    @FXML
    void Logout(ActionEvent event) throws IOException {
    	Main.getFlex().Logout();
    	Main m = new Main();
    	m.changeScene("Register.fxml");
    }

    @FXML
    void PrintFee(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("PrintFeeChallan.fxml");
    }

    @FXML
    void RegisterCourse(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("RegisterCourse.fxml");
    }

    @FXML
    void ViewAttendance(ActionEvent event) throws IOException {
    	String selectedItem = CourseList.getSelectionModel().getSelectedItem();
    	Main.getFlex().setSelectedCourse(selectedItem.split(" ")[1]);
    	Main m= new Main();
    	m.changeScene("ViewStudentAttendance.fxml");
    }

    @FXML
    void viewMarks(ActionEvent event) throws IOException {
    	String selectedItem = CourseList.getSelectionModel().getSelectedItem();
    	Main.getFlex().setSelectedCourse(selectedItem.split(" ")[1]);
    	Main m= new Main();
    	m.changeScene("ViewStudentMarks.fxml");
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		String r1 = "CourseName  CourseCode  Credit hours";
		CourseList.getItems().add(r1);
		ArrayList<Course> Courses = Main.getFlex().getStudentCourses();
		for(Course s:Courses) {
			String a1 = s.getCourseName() + " " + s.getCourseCode() + " " + s.getCrdHrs();
			CourseList.getItems().add(a1);			
		}
			
	}

}

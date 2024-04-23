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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class RegisterCourseController implements Initializable{

    @FXML
    private ListView<String> CourseTable;

    @FXML
    private Button back;

    @FXML
    private Button enroll;

    @FXML
    private Label info;

    @FXML
    void Back(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("StudentPanel.fxml");
    }

    @FXML
    void Enroll(ActionEvent event) {
    	String selectedItem = CourseTable.getSelectionModel().getSelectedItem();
    	boolean done = Main.getFlex().registerStudentCourse(selectedItem.split(" ")[1]);
    	if(done)
    	info.setText("Course has been registered");
    	else
    		info.setText("Error!!");
    }
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		String r1 = "CourseName  CourseCode  Credit hours";
		CourseTable.getItems().add(r1);
		ArrayList<Course> Courses = Main.getFlex().getAllCourses();
		for(Course s:Courses) {
			String a1 = s.getCourseName() + " " + s.getCourseCode() + " " + s.getCrdHrs();
			CourseTable.getItems().add(a1);			
		}			
	}
}

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

public class TeacherPanelController implements Initializable {

    @FXML
    private Button Back;

    @FXML
    private ListView<String> CourseTable;

    @FXML
    private Button SelectCourse;
    
    @FXML
    void Select(ActionEvent event) throws IOException{
    	String selectedItem = CourseTable.getSelectionModel().getSelectedItem();
    	Main.getFlex().setSelectedCourse(selectedItem.split(" ")[1]);
    	System.out.print(Main.getFlex().getSelectedCourse());
    	Main m = new Main();
    	m.changeScene("ManageCourse.fxml");
    }



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		String r1 = "CourseName  CourseCode  Credit hours";
		CourseTable.getItems().add(r1);
		ArrayList<Course> Courses = Main.getFlex().getAllCourses();
		for(Course s:Courses) {
			String a1 = s.getCourseName() + " " + s.getCourseCode() + " " + s.getCrdHrs();
			CourseTable.getItems().add(a1);			
		}

	
		}
	  @FXML
	    void logout(ActionEvent event) throws IOException {
		  Main m = new Main();
		  Main.getFlex().Logout();
	    m.changeScene("Register.fxml");
	    }
	}

package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import BusinessLogic.Course;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
public class DeleteCourseController implements Initializable {
	@FXML
	private Button backButton;
	@FXML
	private Button DeleteButton;

	//@FXML
	//private TableColumn<Student, String> firstname;

	@FXML
	private Label info;

//	@FXML
//	private TableColumn<Student, String> lastname;

//	@FXML
//	private TableColumn<Student, Integer> rnCol;

	//private TableView<Student> studentTable;
	
	@FXML
	private ListView<String> studentTable;

	@FXML
	void Back(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("AdminPanel.fxml");
	}
	
	@FXML
	void View(ActionEvent event) {

		String selectedItem = studentTable.getSelectionModel().getSelectedItem();
		int index = studentTable.getSelectionModel().getSelectedIndex();
		boolean done = Main.getFlex().deleteCourse(selectedItem.split(" ")[1]);
		if(done) {
			info.setText("Course Deleted Successfully");
			studentTable.getItems().remove(index);
			
		}
		else {
			info.setText("Course didnt delete Try again !!");
		}
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		String r1 = "CourseName  CourseCode  Credit hours";
		studentTable.getItems().add(r1);
		ArrayList<Course> Courses = Main.getFlex().getAllCourses();
		for(Course s:Courses) {
			String a1 = s.getCourseName() + " " + s.getCourseCode() + " " + s.getCrdHrs();
			studentTable.getItems().add(a1);			
		}
			
	}

}

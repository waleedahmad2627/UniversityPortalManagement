package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import BusinessLogic.Course;
import BusinessLogic.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class SetAttendanceController implements Initializable {

    @FXML
    private Button AbsentBtn;

    @FXML
    private ListView<String> CourseTable;

    @FXML
    private Button PresntBtn;

    @FXML
    private Button back;
    
    @FXML
    private Label info;
    
    @FXML
    private TextField Index;

    @FXML
    void Back(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("ManageCourse.fxml");
    }

    @FXML
    void MarkAbsent(ActionEvent event) throws IOException {
    	if(Index.getText().isEmpty()) {
	
			String selectedItem = CourseTable.getSelectionModel().getSelectedItem();
			boolean done = Main.getFlex().markAttendance(selectedItem.split(" ")[1], false);
			
			if(done) {
				info.setText("Attendance Updated");
				
			}
			else {
				info.setText("Error !!");
			}
    	}
    	else {
    		String selectedItem = CourseTable.getSelectionModel().getSelectedItem();
    	
			boolean done = Main.getFlex().updateAttendance(selectedItem.split(" ")[1], false, Integer.parseInt(Index.getText()));
			
			if(done) {
				info.setText("Attendance Updated");	
			}
			else {
				info.setText("Error !!");
			}
    	}
    	
    	Main m = new Main();
    	m.changeScene("SetAttendance.fxml");
    }

    @FXML
    void MarkPresent(ActionEvent event) throws IOException {
    	if(Index.getText().isEmpty()) {
	
			String selectedItem = CourseTable.getSelectionModel().getSelectedItem();
			boolean done = Main.getFlex().markAttendance(selectedItem.split(" ")[1], true);
			
			if(done) {
				info.setText("Attendance Updated");
				
			}
			else {
				info.setText("Error !!");
			}
    	}
    	else {
    		String selectedItem = CourseTable.getSelectionModel().getSelectedItem();
    	
			boolean done = Main.getFlex().updateAttendance(selectedItem.split(" ")[1], true, Integer.parseInt(Index.getText()));
			
			if(done) {
				info.setText("Attendance Updated");	
			}
			else {
				info.setText("Error !!");
			}
    	}
    	
    	Main m = new Main();
    	m.changeScene("SetAttendance.fxml");
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

		String r1 = "Name  RollNumber  Attendance";
		CourseTable.getItems().add(r1);
		ArrayList<Student> Students = Main.getFlex().getAllCourseStudents();
		for(Student s:Students) {
			String a1 = s.getName() + " " + s.getRollNo() + " " + Main.getFlex().viewOnlyAP(s.getRollNo()) ;
			CourseTable.getItems().add(a1);			
		}
			
	
	}

}

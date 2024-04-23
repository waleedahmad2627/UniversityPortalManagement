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

public class DeleteStudentController  implements Initializable{

    @FXML
    private Button DeleteButton;

    @FXML
    private Button backButton;

    @FXML
    private Label info;

    @FXML
    private ListView<String> studentTable;

    @FXML
    void Back(ActionEvent event)throws IOException {
    	Main m = new Main();
		m.changeScene("AdminPanel.fxml");
    }

    @FXML
    void View(ActionEvent event)throws IOException {
		String selectedItem = studentTable.getSelectionModel().getSelectedItem();
		int index = studentTable.getSelectionModel().getSelectedIndex();
		boolean done = Main.getFlex().deleteStudent(selectedItem.split(" ")[1]);
		if(done) {
			info.setText("Student Deleted Successfully");
			studentTable.getItems().remove(index);
			
		}
		else {
			info.setText("Student didnt delete Try again !!");
		}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		String r1 = "StudentName RollNumber";
		studentTable.getItems().add(r1);
		ArrayList<Student> Students = Main.getFlex().getAllStudents();
		for(Student s:Students) {
			String a1 = s.getName() + " " + s.getRollNo() ;
			studentTable.getItems().add(a1);			
		}
			
	}

}

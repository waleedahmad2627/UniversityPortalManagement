package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import BusinessLogic.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class SelectStudentController implements Initializable {

    @FXML
    private ListView<String> MarksTable;

    @FXML
    private Button SelectStudent;

    @FXML
    private Button back;

    @FXML
    private Label info;

    @FXML
    void Back(ActionEvent event) throws IOException {
    	Main m = new Main();
		m.changeScene("ManageCourse.fxml");
    
    }

    @FXML
    void Select(ActionEvent event) throws IOException {
    	
    	String selectedItem = MarksTable.getSelectionModel().getSelectedItem();
		Main.getFlex().setSelectedStudent(selectedItem.split(" ")[1]);
		Main m = new Main();
		m.changeScene("SetMarks.fxml");
		
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		String r1 = "StudentName RollNumber";
		MarksTable.getItems().add(r1);
		ArrayList<Student> Students = Main.getFlex().getAllStudents();
		for(Student s:Students) {
			String a1 = s.getName() + " " + s.getRollNo() ;
			MarksTable.getItems().add(a1);			
		}
			
	
	}

}

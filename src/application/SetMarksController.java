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
import javafx.scene.control.TextField;

public class SetMarksController implements Initializable {

    @FXML
    private Button Done;

    @FXML
    private TextField Index;

    @FXML
    private ListView<String> MarksTable;

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
    void Marks(ActionEvent event) throws IOException {
    	
    	String selectedItem = MarksTable.getSelectionModel().getSelectedItem();
    	boolean done = false;
		int index = MarksTable.getSelectionModel().getSelectedIndex();
		if(index == 1) {
		 done = Main.getFlex().markAssignment(Integer.parseInt(Index.getText()));
		 }
		else if (index==2) {
		 done = Main.getFlex().markQuiz(Integer.parseInt(Index.getText()));
		}
		else if (index==3) {
			done = Main.getFlex().markSessional(Integer.parseInt(Index.getText()));
		}
		else if(index ==4) {
			done = Main.getFlex().markFinal(Integer.parseInt(Index.getText()));
		}
		else if (index == 5) {
			done = Main.getFlex().markGrade(Index.getText());
		}
		if(done) {
			info.setText("Student Deleted Successfully");			
		}
		else {
			info.setText("Student didnt delete Try again !!");
		}
     Main m = new Main();
     m.changeScene("SetMarks.fxml");
    }
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
    		ArrayList<Student> Students = Main.getFlex().getAllStudents();
    		Student x= null;
    		for(Student s: Students) {
    			if(s.getRollNo().equals(Main.getFlex().getSelectedStudent())) {
    			   x=s;
    			}
    		}
			String a1 = x.getName() + " " + x.getRollNo() + " ";
			String a6 = "Assignments : " +Main.getFlex().viewAssignments();
			String a3 = "Quizes : " +Main.getFlex().viewQuizes();
			String a2 = "Sessionals :  " +Main.getFlex().viewSessionals();
			String a4= "Final : " + Main.getFlex().viewFinal();
			String a5 = "Grade : " + Main.getFlex().viewGrade();
			MarksTable.getItems().add(a1);		
			MarksTable.getItems().add(a6);
			MarksTable.getItems().add(a3);
			MarksTable.getItems().add(a2);
			MarksTable.getItems().add(a4);
			MarksTable.getItems().add(a5);
		
	
	}
}

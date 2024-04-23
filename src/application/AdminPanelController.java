package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import java.io.IOException;
import javafx.event.ActionEvent;

public class AdminPanelController {

	 @FXML
	    private Button AddCourseBtn;

	    @FXML
	    private Button AddStudentBtn;

	    @FXML
	    private Button DeleteCourseBtn;

	    @FXML
	    private Button DeleteStudentBtn;

	    @FXML
	    void AddCourse(ActionEvent event)throws IOException {
	    	Main m=new Main();
	    	m.changeScene("AddCourseScreen.fxml");
	    }

	    @FXML
	    void AddStudent(ActionEvent event) throws IOException{
	    	Main m=new Main();
	    	m.changeScene("AddStudent.fxml");
	    }

	    @FXML
	    void DeleteCourse(ActionEvent event)throws IOException {
	    	Main m=new Main();
	    	m.changeScene("DeleteCourse.fxml");
	    }

	    @FXML
	    void DeleteStudent(ActionEvent event) throws IOException{
	    	Main m=new Main();
	    	m.changeScene("DeleteStudent.fxml");
	    }
	    
	    @FXML
	    void Logout(ActionEvent event) throws IOException {
	    	Main.getFlex().Logout();
	    	Main m = new Main();
	    	m.changeScene("Register.fxml");
	    }

}
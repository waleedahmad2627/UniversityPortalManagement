package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddCourseController {

    @FXML
    private Button Addbtn;

    @FXML
    private TextField Code;

    @FXML
    private TextField CourseName;

    @FXML
    private TextField CreditHrs;

    @FXML
    private Label info;

    @FXML
    void AddCourse(ActionEvent event) throws IOException{
    	boolean done = Main.getFlex().addNewCourse(Code.getText(), CourseName.getText(), Integer.parseInt(CreditHrs.getText()));
    	if(done) {
    		info.setText("Course Has been Added Sucessfully");
    	}else {
    		info.setText("Course Already Exists");
    	}
    }
    
    @FXML
    void Back(ActionEvent event)throws IOException  {
    	Main m=new Main();
    	m.changeScene("AdminPanel.fxml");
    }

}
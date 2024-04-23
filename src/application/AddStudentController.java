package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddStudentController {

    @FXML
    private Button Addbtn;

    @FXML
    private TextField Name;

    @FXML
    private TextField Password;

    @FXML
    private TextField RollNumbers;

    @FXML
    private Label info;

    @FXML
    void AddStudent(ActionEvent event) throws IOException{
    	boolean done = Main.getFlex().addNewStudent(Name.getText(),Password.getText(),RollNumbers.getText());
    	if(done) {
    		info.setText("Student Succesfully Added");
    	}
    	else {
    		info.setText("Error! Try agian");
    	}
    }

    @FXML
    void Back(ActionEvent event) throws IOException{
    	Main m=new Main();
    	m.changeScene("AdminPanel.fxml");
    }

}

package application;

import javafx.fxml.*;
import javafx.scene.control.*;

import java.io.IOException;

import javafx.event.ActionEvent;
public class RegisterController {
	
    @FXML
    private TextField firstname;

    @FXML
    private TextField password;

    @FXML
    private Button regButton;

    @FXML
    private Label info;
    
    @FXML
    private RadioButton rbAdmin;

    @FXML
    private RadioButton rbStudent;

    @FXML
    private RadioButton rbTeacher;
    
    @FXML
    void RadioSet(ActionEvent event) {
//    	if(rbAdmin.isSelected()) {
//    		rbTeacher.setSelected(false);
//    		rbStudent.setSelected(false);
//    	}
//    	if(rbTeacher.isSelected()) {
//    		rbStudent.setSelected(false);
//    		rbAdmin.setSelected(false);
//    	}
//    	if(rbStudent.isSelected()) {
//    		rbAdmin.setSelected(false);    	
//    		rbTeacher.setSelected(false);
//    	}
    	//rbTeacher.setToggleGroup(null);
    }
    @FXML
    void Register(ActionEvent event) throws IOException {
    	Main m=new Main();
    	if(firstname.getText().isEmpty() || password.getText().isEmpty())
    	{
    		info.setText("Enter Data in all fields");
    	}
    	else {
    		if(rbAdmin.isSelected()) {
    			//This if condition will check if username and password matches in data base of admin
    			if(Main.getFlex().checkUser(firstname.getText(), password.getText(),"Admin")) {
    				m.changeScene("AdminPanel.fxml");
    			}
    			else {
    				info.setText("incorrect username or password");
    			}
    		}
    		else if(rbTeacher.isSelected()) {
    			//This if condition will check if username and password matches in data base of Teacher
    			if(Main.getFlex().checkUser(firstname.getText(), password.getText(),"Teacher")) {
    				System.out.print("Logged in as Teacher");
    				m.changeScene("TeacherPanel.fxml");
    			}
    			else {
    				info.setText("incorrect username or password");
    			}
    		}
    		else {
    			//This if condition will check if username and password matches in data base of Student
    			if(Main.getFlex().checkUser(firstname.getText(), password.getText(),"Student")) {
    				m.changeScene("StudentPanel.fxml");
    			}
    			else {
    				info.setText("incorrect username or password");
    			}
    		}
    		
    	}
    }
}

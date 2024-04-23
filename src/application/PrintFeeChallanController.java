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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class PrintFeeChallanController implements Initializable{

    @FXML
    private Button back;

    @FXML
    private Label info;
    
    @FXML
    private ListView<String> FeeList;

    @FXML
    void Back(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("StudentPanel.fxml");
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		String r1 = Main.getFlex().printFeeChallan();
		FeeList.getItems().add(r1);
		
			
	
	}
    
    

}

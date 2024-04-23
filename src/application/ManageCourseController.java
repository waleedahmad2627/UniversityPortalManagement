package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ManageCourseController {

    @FXML
    private Button AttendanceBtn;

    @FXML
    private Button MarksBtn;

    @FXML
    private Button back;

    @FXML
    void Attendance(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("SetAttendance.fxml");
    }

    @FXML
    void Back(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("TeacherPanel.fxml");
    }

    @FXML
    void Marks(ActionEvent event) throws IOException {
    	Main m = new Main();
    	m.changeScene("SelectStudent.fxml");
    }

}

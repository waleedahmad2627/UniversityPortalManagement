package application;

import java.io.IOException;

import BusinessLogic.Flex;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.fxml.*;
import DB.*;

public class Main extends Application {
	private static Stage stg;
	static FileHandler FH = new FileHandler();
	private static Flex flex = FH.getFlex(); // BL controller object

	@Override
	public void start(Stage primaryStage) {
		try {
			stg = primaryStage;
			Parent root = FXMLLoader.load(getClass().getResource("Register.fxml"));
			Scene scene = new Scene(root, 600, 400);
			primaryStage.setTitle("University Management System");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Flex getFlex() {
		return flex;
	}

	public void changeScene(String fxml) throws IOException {
		Parent pane = FXMLLoader.load(getClass().getResource(fxml));
		stg.getScene().setRoot(pane);
	}

	public static void main(String[] args) {
		launch(args);
		System.out.print("Stored in Db");
			FH.saveFlex(flex);
	}
}

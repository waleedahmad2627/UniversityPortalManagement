module flexx {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	requires java.xml;
	
	opens application to javafx.graphics, javafx.fxml;
}

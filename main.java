import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.geometry.*;

public class main extends Application {
	Button button;
	String[] userLogins = new String[] { "AndrewAdmin" };

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Buttons
		button = new Button("View Source Code");
		button.setOnAction(e -> { 
			EnglishLanguageCalculator.main(userLogins);
		});

		// Layout
		StackPane layout = new StackPane();
		layout.getChildren().add(button);
		Scene mainScene = new Scene(layout, 1600, 900);

		// Adding everything
		primaryStage.setTitle("Collab App");
		primaryStage.setScene(mainScene);
		primaryStage.show();
		primaryStage.show();

		login.display("Login Window", "Please Log In", userLogins);


	}

}
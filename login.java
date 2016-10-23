import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.text.Text;

public class login {

    private static void closeWindow(){
        System.exit(0);
    }
    
    public static void display(String title, String message, String[] database) {

        // Stage Details
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(500);
        window.setOnCloseRequest(e -> {
            e.consume();
            closeWindow();
        });
        Label label = new Label();
        label.setText(message);

        // Scene Details
        GridPane layout = new GridPane();        
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setVgap(8);
        layout.setHgap(10);
    //    layout.setGridLinesVisible(true);

        Text gitDownload = new Text();
        gitDownload.setText("To update this app you must have Git installed." 
            + "\nVisit: https://www.git-scm.com/downloads");
        GridPane.setConstraints(gitDownload, 1, 0);

        //Name Label
        Label nameLabel = new Label("Username:");
        GridPane.setConstraints(nameLabel, 0, 1);


        //Name Input
        TextField nameInput = new TextField();
        nameInput.setPromptText("username");
        GridPane.setConstraints(nameInput, 1, 1);

        //Password Label
        Label passLabel = new Label("Password:");
        GridPane.setConstraints(passLabel, 0, 2);

        //Password Input
        TextField passInput = new TextField();
        passInput.setPromptText("password");
        GridPane.setConstraints(passInput, 1, 2);

        //Login
        Button loginButton = new Button("Log In");
        GridPane.setConstraints(loginButton, 1, 3);

        loginButton.setOnAction( e -> { 
            if (loginVerifier.main(nameInput.getText(), passInput.getText(), database)) {
                System.out.println("Login Successful!");
                window.close();
            } else if (!loginVerifier.main(nameInput.getText(), passInput.getText(), database)) {
                System.out.println("Login Unsuccessful");
                passInput.setText("");
            }
        });

        layout.getChildren().addAll(gitDownload, nameLabel, nameInput, passLabel, passInput, loginButton);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
    
}









// Make link to git download copiable OR hyperlink
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.geometry.*;
import java.io.*;
import java.util.Scanner;


public class main extends Application {
	Button button;
	Scanner sc = new Scanner(System.in);
	String[] userLogins = new String[] { "AndrewAdmin" };

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		// Layout
		GridPane layout = new GridPane();
		layout.setVgap(8);
        layout.setHgap(10);
    	layout.setAlignment(Pos.CENTER);
		

		// Buttons
		button = new Button("View Source Code");
		button.setOnAction(e -> { 
			EnglishLanguageCalculator.main(userLogins);
		});
        GridPane.setConstraints(button, 3, 3);
		
        Button button1 = new Button("Create new branch on local");
        GridPane.setConstraints(button1, 0, 1);
        button1.setOnAction(e -> {
	        System.out.println("Please enter the name of your new branch");
	        String branchName = sc.nextLine();
        	gitCommands("git branch " + branchName);
        });


		Button button2 = new Button("Change active branch");
        GridPane.setConstraints(button2, 0, 2);
        button2.setOnAction(e -> {	        
        	System.out.println("Please enter the name of the branch you would like to switch to");
	        String branchName = sc.nextLine();
   			gitCommands("git checkout " + branchName);
        });



        Button button3 = new Button("Fetch updates from online master");
        GridPane.setConstraints(button3, 0, 3);
        button3.setOnAction(e -> gitCommands("git status"));

        Button button4 = new Button("Merge updates to local copy of current branch");
        GridPane.setConstraints(button4, 0, 4);
        button4.setOnAction(e -> gitCommands("git status"));



        Button button5 = new Button("Commit changes to local copy");
        GridPane.setConstraints(button5, 0, 5);
        button5.setOnAction(e ->  {	        
        	System.out.println("Describe the changes you have made");
	        String commitMessage = sc.nextLine(); 
	        gitCommands("git commit -am \"+"+commitMessage+"\"");
	    });



        Button button6 = new Button("Push changes from local copy to online copy");
        GridPane.setConstraints(button6, 0, 6);
        button6.setOnAction(e -> gitCommands("git status"));























		layout.getChildren().addAll(button, button1, button2, button3, button4, button5, button6);
		Scene mainScene = new Scene(layout, 1600, 900);

		// Adding everything
		primaryStage.setTitle("Collab App");
		primaryStage.setScene(mainScene);
		primaryStage.show();
		primaryStage.show();

		login.display("Login Window", "Please Log In", userLogins);


	}


	public static void gitCommands(String command) {
 		try {
            Process p = Runtime.getRuntime().exec(command);
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException f) {
            f.printStackTrace();
        }
	}



}
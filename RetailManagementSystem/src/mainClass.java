import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.layout.StackPane;
import javafx.stage.*;
public class mainClass extends Application implements EventHandler<ActionEvent>{
	
	Stage window;
	Scene scene1, scene2;
	Button button;
	public static void main(String[] args)
	{
		launch(args);
		StockManager mg = new StockManager();
		mg.addScore(5);
		
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		window = primaryStage;
		primaryStage.setTitle("Retail Management System");
		
		Label label1 = new Label("Welcome to retail management system");
		
		button = new Button("Submit");
		button.setOnAction(this);
		
		VBox layout = new VBox();
		TextField usernameField = new TextField("Username");
		TextField passwordField = new TextField("Password");
		//StackPane layout = new StackPane();
		layout.getChildren().add(label1);
		layout.getChildren().add(usernameField);
		layout.getChildren().add(passwordField);
		layout.getChildren().add(button);
		
		Scene scene = new Scene(layout, 500, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	@Override
	public void handle(ActionEvent event)
	{
		if(event.getSource()==button)
		{
			System.out.println("submitted");
		}
	}
	
}

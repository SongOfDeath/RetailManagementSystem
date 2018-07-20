import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.layout.StackPane;
import javafx.stage.*;
import javafx.geometry.*;
public class mainClass extends Application implements EventHandler<ActionEvent> {
	
	Stage window;
	Scene scene, electronicsHomeScene, booksHomeScene, clothesHomeScene;
	Button button, addStockButton;
	VBox layout, electronicsHomeLayout, booksHomeLayout, clothesHomeLayout;
	TextField usernameField = new TextField("Username");
	PasswordField  passwordField = new PasswordField();// ("Password");
	ChoiceBox<String> shopTypeChoiceBox = new ChoiceBox<>();
	
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
		
		Label welcomeLabel = new Label("Welcome to retail management system");
		
		button = new Button("Submit");
		button.setOnAction(this);
		addStockButton = new Button("Add Stock");
		button.setOnAction(this);
		///////////////////////
		shopTypeChoiceBox.getItems().add("Electronics");
		shopTypeChoiceBox.getItems().add("Books");
		shopTypeChoiceBox.getItems().add("Clothes");
		shopTypeChoiceBox.setValue("Electronics");
		///////////////////////
		layout = new VBox(10);
		layout.setPadding(new Insets(20,20,20,20));
		electronicsHomeLayout = new VBox(10);
		electronicsHomeLayout.setPadding(new Insets(20,20,20,20));
		//StackPane layout = new StackPane();
		layout.getChildren().add(welcomeLabel);
		layout.getChildren().add(usernameField);
		layout.getChildren().add(passwordField);
		layout.getChildren().add(button);
		layout.getChildren().add(shopTypeChoiceBox);
		
		//////////////
		

		
		///////////
		scene = new Scene(layout, 500, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	@Override
	public void handle(ActionEvent event)
	{
		if(event.getSource()==button)
		{
			System.out.println("submitted");
			electronicsHomeScene = new Scene(electronicsHomeLayout, 500, 500);
			window.setScene(electronicsHomeScene);
			window.show();
			System.out.println(shopTypeChoiceBox.getValue());
			if(shopTypeChoiceBox.getValue()=="Electronics")
			{
				electronicsHomeLayout.getChildren().add(addStockButton);
				window.setScene(electronicsHomeScene);
			}
		}
	}
	
}

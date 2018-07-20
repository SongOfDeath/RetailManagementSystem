import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.*;
public class mainClass extends Application{
	
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
		primaryStage.setTitle("Shop System");
		button = new Button("Submit");
		
		StackPane layout = new StackPane();
		layout.getChildren().add(button);
		
		Scene scene = new Scene(layout, 500, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
}

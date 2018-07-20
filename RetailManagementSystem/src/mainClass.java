import controller.GeneralManager;
import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.layout.StackPane;
import javafx.stage.*;
import model.StockManager;
import javafx.geometry.*;

public class mainClass extends Application implements EventHandler<ActionEvent> {
	
	GeneralManager genMngr = new GeneralManager();
	
	Stage window;
	Scene scene, electronicsHomeScene, booksHomeScene, clothesHomeScene;
	String storeType = "Electronics";
	//BUTTONS
	Button button, addStockButton, stocksManagementToolButton, takeCustomerFeedbackButton, billingManagementToolButton, salesManagementToolButton, itemRepairOrdersButton, promotionsManagementButton, usedGoodsResaleButton, itemRentalButton;
	
	//LAYOUTS
	VBox layout, electronicsHomeLayout, booksHomeLayout, clothesHomeLayout;
	VBox booksStockManagementLayout;
	TextField usernameField = new TextField("Username");
	PasswordField  passwordField = new PasswordField();// ("Password");
	ChoiceBox<String> shopTypeChoiceBox = new ChoiceBox<>();
	
	public static void main(String[] args)
	{
		launch(args);
		StockManager mg = new StockManager();
		mg.addData("mahir �zer");
		
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		window = primaryStage;
		primaryStage.setTitle("Retail Management System");
		
		Label welcomeLabel = new Label("Welcome to retail management system");
		//////////////////////////////////
		/// BUTTONS///////////////////////
		//////////////////////////////////
		button = new Button("Submit");
		button.setOnAction(this);
		//addStockButton = new Button("Add Stock");
		//button.setOnAction(this);
		stocksManagementToolButton = new Button("Stocks Management Tool");
		stocksManagementToolButton.setOnAction(this);
		takeCustomerFeedbackButton = new Button("Take Customer Feedback");
		takeCustomerFeedbackButton.setOnAction(this);
		billingManagementToolButton = new Button("Billing Management Tool");
		billingManagementToolButton.setOnAction(this);
		salesManagementToolButton = new Button("Sales Management Tool");
		salesManagementToolButton.setOnAction(this);
		itemRepairOrdersButton = new Button("Item Repair Order");
		itemRepairOrdersButton.setOnAction(this);
		promotionsManagementButton = new Button("Promotion Management");
		promotionsManagementButton.setOnAction(this);
		usedGoodsResaleButton = new Button("Used Goods Resale");
		usedGoodsResaleButton.setOnAction(this);
		itemRentalButton = new Button("Item Rental");
		itemRentalButton.setOnAction(this);
		///////////////////////
		///////////////////////
		shopTypeChoiceBox.getItems().add("Electronics");
		shopTypeChoiceBox.getItems().add("Books");
		shopTypeChoiceBox.getItems().add("Clothes");
		shopTypeChoiceBox.setValue("Electronics");
		///////////////////////
		layout = new VBox(10);
		layout.setPadding(new Insets(20,20,20,20));

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

			//window.show();
			System.out.println(shopTypeChoiceBox.getValue());
			if(shopTypeChoiceBox.getValue()=="Electronics")
			{
				electronicsHomeLayout = new VBox(10);
				electronicsHomeLayout.setPadding(new Insets(20,20,20,20));
				electronicsHomeLayout.getChildren().addAll(stocksManagementToolButton, takeCustomerFeedbackButton, billingManagementToolButton, salesManagementToolButton, itemRepairOrdersButton, promotionsManagementButton, usedGoodsResaleButton);
				electronicsHomeScene = new Scene(electronicsHomeLayout, 500, 500);
				window.setScene(electronicsHomeScene);
				storeType = "Electronics";
				//setMode
				genMngr.shop_mode = GeneralManager.ELECSHOP;
			}
			else if (shopTypeChoiceBox.getValue() == "Books")
			{
				booksHomeLayout = new VBox(10);
				booksHomeLayout.setPadding(new Insets(20,20,20,20));
				booksHomeLayout.getChildren().addAll(
						addStockButton, 
						stocksManagementToolButton, 
						takeCustomerFeedbackButton, 
						billingManagementToolButton, 
						salesManagementToolButton, 
						promotionsManagementButton, 
						usedGoodsResaleButton, 
						itemRentalButton);

				booksHomeLayout.getChildren().addAll(stocksManagementToolButton, takeCustomerFeedbackButton, billingManagementToolButton, salesManagementToolButton, promotionsManagementButton, usedGoodsResaleButton, itemRentalButton);

				booksHomeLayout.getChildren().addAll(stocksManagementToolButton, takeCustomerFeedbackButton, billingManagementToolButton, salesManagementToolButton, promotionsManagementButton, usedGoodsResaleButton, itemRentalButton);

				booksHomeScene = new Scene(booksHomeLayout, 500, 500);
				window.setScene(booksHomeScene);
				storeType = "Books";
				//setMode
				genMngr.shop_mode = GeneralManager.BOOKSHOP;
			}
			else if(shopTypeChoiceBox.getValue()=="Clothes")
			{
				clothesHomeLayout = new VBox(10);
				clothesHomeLayout.setPadding(new Insets(20,20,20,20));
				clothesHomeLayout.getChildren().addAll(stocksManagementToolButton, takeCustomerFeedbackButton, billingManagementToolButton, salesManagementToolButton, promotionsManagementButton, itemRentalButton);
				clothesHomeScene = new Scene(clothesHomeLayout, 500, 500);
				window.setScene(clothesHomeScene);
				storeType = "Clothes";
				//setMode
				genMngr.shop_mode = GeneralManager.CLOTHSHOP;
			}
		}
		
		if(event.getSource()==stocksManagementToolButton)
		{
			
		}
	}
	
}

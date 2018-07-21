import controller.GeneralManager;
import model.StockManager;
import model.*;

import javafx.scene.*;
import javafx.scene.control.cell.*;
import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.layout.StackPane;
import javafx.stage.*;
import model.StockManager;
import javafx.geometry.*;
import javafx.collections.*;
import java.util.*;

public class mainClass extends Application implements EventHandler<ActionEvent> {
	
	//ITEMS
	public ObservableList<Item> allItemsAvailable = FXCollections.observableArrayList();
	TableView<Item> table;
	
	GeneralManager genMngr = new GeneralManager();
	StockManager stockManager;
	Stage window;
	String storeType = "Electronics";
	String databaseName;
	//PAGES
	Scene scene, electronicsHomeScene, booksHomeScene, clothesHomeScene;
	Scene electronicsStocksManagementScene, booksStocksManagementScene, clothesStocksManagementScene;
	//COMMON PAGES AND LAYOUTS
	Scene stocksManagementScene;
	VBox stocksManagementLayout;
	//BUTTONS
	Button button, addStockButton, stocksManagementToolButton, takeCustomerFeedbackButton, billingManagementToolButton, salesManagementToolButton, itemRepairOrdersButton, promotionsManagementButton, usedGoodsResaleButton, itemRentalButton;
	//COMMON BUTTONS
	Button stockSubmitButton;
	//LAYOUTS
	VBox layout, electronicsHomeLayout, booksHomeLayout, clothesHomeLayout;
	VBox electronicsStocksManagementLayout, booksStocksManagementLayout, clothesStocksManagementLayout;
	//VBox booksStockManagementLayout;
	
	//TEXT FIELDS
	TextField usernameField = new TextField("Username");
	PasswordField  passwordField = new PasswordField();// ("Password");
	
	//COMMON TEXT FIELDS
	TextField nameField, property1Field, property2Field, property3Field, property4Field, property5Field;
	ChoiceBox<String> shopTypeChoiceBox = new ChoiceBox<>();
	
	public static void main(String[] args)
	{
		launch(args);
		//StockManager mg = new StockManager();
		//mg.addData("mahir özer");
		
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
		/////////////////////////
		///LOGIN AND SET UP HOMEPAGE/////////////////
		if(event.getSource()==button)
		{
			System.out.println("submitted");
			table = new TableView<>();
			
			//////////////////////////////////////////
			///////ALL ITEMS TABLE COMMON ATTRIBUTES
			TableColumn<Item, String> nameColumn = new TableColumn<>("Name");
			nameColumn.setMinWidth(200);
			nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
			TableColumn<Item, Integer> barcodeColumn = new TableColumn<>("Barcode");
			barcodeColumn.setMinWidth(200);
			barcodeColumn.setCellValueFactory(new PropertyValueFactory<>("barcode"));
			TableColumn<Item, Double> priceColumn = new TableColumn<>("Price");
			priceColumn.setMinWidth(200);
			priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
			
			///ALL ITEMS TABLE COMMON ATTRIBUTES
			///////////////////////////////////////////
			
			//window.show();
			System.out.println(shopTypeChoiceBox.getValue());
			fetchFromDatabase();
			/////////////////////////////////
			/////SET UP ELECTRONICS SHOP
			if(shopTypeChoiceBox.getValue()=="Electronics")
			{
				databaseName = "electronicStocks.txt";
				stockManager = new StockManager(databaseName);
				///////////////////////////
				//SET UP TABLE
				TableColumn<Item, String> brandColumn = new TableColumn<>("Brand");
				brandColumn.setMinWidth(200);
				brandColumn.setCellValueFactory(new PropertyValueFactory<>("brand"));
				
				table.setItems(allItemsAvailable);
				table.getColumns().addAll(nameColumn, barcodeColumn, priceColumn, brandColumn);
				
				//SET UP TABLE
				//////////////////////////
				electronicsHomeLayout = new VBox(10);
				electronicsHomeLayout.setPadding(new Insets(20,20,20,20));
				electronicsHomeLayout.getChildren().addAll(stocksManagementToolButton, takeCustomerFeedbackButton, billingManagementToolButton, salesManagementToolButton, itemRepairOrdersButton, promotionsManagementButton, usedGoodsResaleButton);
				electronicsHomeScene = new Scene(electronicsHomeLayout, 500, 500);
				window.setScene(electronicsHomeScene);
				storeType = "Electronics";
				//setMode
				genMngr.shop_mode = GeneralManager.ELECSHOP;
			}
			///SET UP ELECTRONICS SHOP
			/////////////////////////
			/////////////////////////
			///SET UP BOOK SHOP
			else if (shopTypeChoiceBox.getValue() == "Books")
			{
				databaseName = "bookStocks.txt";
				stockManager = new StockManager("bookStocks.txt");
				booksHomeLayout = new VBox(10);
				booksHomeLayout.setPadding(new Insets(20,20,20,20));

				booksHomeLayout.getChildren().addAll(
						stocksManagementToolButton, 
						takeCustomerFeedbackButton, 
						billingManagementToolButton, 
						salesManagementToolButton, 
						promotionsManagementButton, 
						usedGoodsResaleButton, 
						itemRentalButton);

				booksHomeScene = new Scene(booksHomeLayout, 500, 500);
				window.setScene(booksHomeScene);
				storeType = "Books";
				//setMode
				genMngr.shop_mode = GeneralManager.BOOKSHOP;
			}
			///SET UP BOOK SHOP
			//////////////////////////
			//////////////////////////
			///SET UP CLOTH SHOP
			else if(shopTypeChoiceBox.getValue()=="Clothes")
			{
				databaseName = "clothStocks.txt";
				stockManager = new StockManager(databaseName);
				clothesHomeLayout = new VBox(10);
				clothesHomeLayout.setPadding(new Insets(20,20,20,20));
				clothesHomeLayout.getChildren().addAll(stocksManagementToolButton, takeCustomerFeedbackButton, billingManagementToolButton, salesManagementToolButton, promotionsManagementButton, itemRentalButton);
				clothesHomeScene = new Scene(clothesHomeLayout, 500, 500);
				window.setScene(clothesHomeScene);
				//storeType = "Clothes";
				//setMode
				genMngr.shop_mode = GeneralManager.CLOTHSHOP;
			}
			////////////////////////////////////
			////////////////////////////////////
		}
		/////////////STOCKS MANAGEMENT////////////////
		//////////////////////////////////////////////
		if(event.getSource()==stocksManagementToolButton)
		{
			stocksManagementLayout = new VBox(10);
			stocksManagementLayout.setPadding(new Insets(20,20,20,20));
			stockSubmitButton = new Button("Add to Stock");
			stockSubmitButton.setOnAction(this);
			if(genMngr.shop_mode == genMngr.ELECSHOP)
			{
				nameField = new TextField("Electronic Name");
				property1Field = new TextField("Serial number");
				property2Field = new TextField("Product Brand");
				property3Field = new TextField("Discount");
				property4Field = new TextField("Category");
				property5Field = new TextField("Warranty In Months");
				stocksManagementLayout.getChildren().addAll(nameField, property1Field, property2Field, property3Field, property4Field, property5Field, stockSubmitButton, table);
				stocksManagementScene = new Scene(stocksManagementLayout,1000,1000);
				window.setScene(stocksManagementScene);
			}
			else if(genMngr.shop_mode == genMngr.BOOKSHOP)
			{
				nameField = new TextField("Book Title");
				property1Field = new TextField("ISBN");
				property2Field = new TextField("Author");
				property3Field = new TextField("Publisher");
				property4Field = new TextField("Copyrights");
				property5Field = new TextField("Age restriction");
				stocksManagementLayout.getChildren().addAll(nameField, property1Field, property2Field, property3Field, property4Field, property5Field, stockSubmitButton, table);
				stocksManagementScene = new Scene(stocksManagementLayout,750,750);
				window.setScene(stocksManagementScene);
			}
			else if(genMngr.shop_mode == genMngr.CLOTHSHOP)
			{
				nameField = new TextField("Cloth Name");
				property1Field = new TextField("Size");
				property2Field = new TextField("Color");
				property3Field = new TextField("Brand Name");
				property4Field = new TextField("Category");
				property5Field = new TextField("Gender");
				
				stocksManagementLayout.getChildren().addAll(nameField, property1Field, property2Field, property3Field, property4Field, property5Field, stockSubmitButton, table);
				stocksManagementScene = new Scene(stocksManagementLayout,500,500);
			}
			window.setScene(stocksManagementScene);
		}
		
		if(event.getSource() == stockSubmitButton)
		{
			String dataToAdd = nameField.getText() + " " + property1Field.getText() + " " + property2Field.getText() + " " + property3Field.getText() + " " + property4Field.getText() + " " + property5Field.getText();
			allItemsAvailable.add(new ElecItem());
			stockManager.addData(dataToAdd);
		}
		
	}
	/*
	public ObservableList<Item> getItems()
	{
		
	}
	*/
	
	public void fetchFromDatabase()
	{
		ArrayList<String> data = new ArrayList<>();
		//data = stockManager.returnData();
		//System.out.println(data);
		//allItemsAvailable.add(e);
	}
	
	public void setUpPages()
	{
		
	}
	
}

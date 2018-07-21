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

import java.io.PrintWriter;
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
	Button stockSubmitButton, removeStockButton;
	//LAYOUTS
	VBox layout, electronicsHomeLayout, booksHomeLayout, clothesHomeLayout;
	VBox electronicsStocksManagementLayout, booksStocksManagementLayout, clothesStocksManagementLayout;
	//VBox booksStockManagementLayout;
	
	//TEXT FIELDS
	TextField usernameField = new TextField("Username");
	PasswordField  passwordField = new PasswordField();// ("Password");
	
	//COMMON TEXT FIELDS
	TextField property0Field, property1Field, property2Field, property3Field, property4Field, property5Field, property6Field;
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
			/////////////////////////////////
			/////SET UP ELECTRONICS SHOP
			if(shopTypeChoiceBox.getValue()=="Electronics")
			{
				//setMode
				genMngr.shop_mode = GeneralManager.ELECSHOP;
				
				databaseName = "electronicStocks.txt";
				stockManager = new StockManager(databaseName);
				fetchFromDatabaseIntoItemList();
				
				///////////////////////////
				//SET UP TABLE
				TableColumn<Item, String> brandColumn = new TableColumn<>("Brand");
				brandColumn.setMinWidth(200);
				brandColumn.setCellValueFactory(new PropertyValueFactory<>("brand"));
				TableColumn<Item, String> categoryColumn = new TableColumn<>("Category");
				categoryColumn.setMinWidth(200);
				categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
				TableColumn<Item, Integer> discountColumn = new TableColumn<>("Discount");
				discountColumn.setMinWidth(100);
				discountColumn.setCellValueFactory(new PropertyValueFactory<>("discount"));
				TableColumn<Item, Integer> warrantyColumn = new TableColumn<>("Warranty");
				warrantyColumn.setMinWidth(100);
				warrantyColumn.setCellValueFactory(new PropertyValueFactory<>("warranty"));
				
				table.setItems(allItemsAvailable);
				table.getColumns().addAll(
						nameColumn, 
						barcodeColumn, 
						priceColumn, 
						brandColumn, 
						categoryColumn, 
						discountColumn, 
						warrantyColumn);
				//SET UP TABLE
				//////////////////////////
				
				electronicsHomeLayout = new VBox(10);
				electronicsHomeLayout.setPadding(new Insets(20,20,20,20));
				electronicsHomeLayout.getChildren().addAll(stocksManagementToolButton, takeCustomerFeedbackButton, billingManagementToolButton, salesManagementToolButton, itemRepairOrdersButton, promotionsManagementButton, usedGoodsResaleButton);
				electronicsHomeScene = new Scene(electronicsHomeLayout, 500, 500);
				window.setScene(electronicsHomeScene);
				storeType = "Electronics";

			}
			///SET UP ELECTRONICS SHOP
			/////////////////////////
			
			/////////////////////////
			///SET UP BOOK SHOP
			else if (shopTypeChoiceBox.getValue() == "Books")
			{
				//setMode
				genMngr.shop_mode = GeneralManager.BOOKSHOP;
				
				databaseName = "bookStocks.txt";
				stockManager = new StockManager("bookStocks.txt");
				fetchFromDatabaseIntoItemList();
				
				///////////////////////////
				//SET UP TABLE
				TableColumn<Item, String> authorColumn = new TableColumn<>("Author");
				authorColumn.setMinWidth(200);
				authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
				TableColumn<Item, Integer> isbnColumn = new TableColumn<>("ISBN");
				isbnColumn.setMinWidth(300);
				isbnColumn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
				TableColumn<Item, String> publisherColumn = new TableColumn<>("Publisher");
				publisherColumn.setMinWidth(200);
				publisherColumn.setCellValueFactory(new PropertyValueFactory<>("publisher"));
				TableColumn<Item, String> copyrightsColumn = new TableColumn<>("Copyrights");
				copyrightsColumn.setMinWidth(200);
				copyrightsColumn.setCellValueFactory(new PropertyValueFactory<>("copyrights"));
				
				table.setItems(allItemsAvailable);
				table.getColumns().addAll(
						nameColumn, 
						barcodeColumn, 
						priceColumn, 
						authorColumn, 
						isbnColumn, 
						publisherColumn, 
						copyrightsColumn);
				//SET UP TABLE
				//////////////////////////
				
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
			}
			///SET UP BOOK SHOP
			//////////////////////////

			//////////////////////////
			///SET UP CLOTH SHOP
			else if(shopTypeChoiceBox.getValue()=="Clothes")
			{
				//setMode
				genMngr.shop_mode = GeneralManager.CLOTHSHOP;
				
				databaseName = "clothStocks.txt";
				stockManager = new StockManager(databaseName);
				fetchFromDatabaseIntoItemList();
				
				///////////////////////////
				//SET UP TABLE
				TableColumn<Item, String> brandColumn = new TableColumn<>("Brand");
				brandColumn.setMinWidth(200);
				brandColumn.setCellValueFactory(new PropertyValueFactory<>("brand"));
				TableColumn<Item, String> categoryColumn = new TableColumn<>("Category");
				categoryColumn.setMinWidth(300);
				categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
				TableColumn<Item, String> colorColumn = new TableColumn<>("Color");
				colorColumn.setMinWidth(200);
				colorColumn.setCellValueFactory(new PropertyValueFactory<>("color"));
				TableColumn<Item, String> sizeColumn = new TableColumn<>("Size");
				sizeColumn.setMinWidth(200);
				sizeColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
				
				table.setItems(allItemsAvailable);
				table.getColumns().addAll(
						nameColumn, 
						barcodeColumn, 
						priceColumn, 
						brandColumn, 
						categoryColumn, 
						colorColumn, 
						sizeColumn);
				//SET UP TABLE
				//////////////////////////
				
				clothesHomeLayout = new VBox(10);
				clothesHomeLayout.setPadding(new Insets(20,20,20,20));
				clothesHomeLayout.getChildren().addAll(stocksManagementToolButton, takeCustomerFeedbackButton, billingManagementToolButton, salesManagementToolButton, promotionsManagementButton, itemRentalButton);
				clothesHomeScene = new Scene(clothesHomeLayout, 500, 500);
				window.setScene(clothesHomeScene);
				//storeType = "Clothes";
			}
			////////////////////////////////////
			////////////////////////////////////
		}
		/////////////STOCKS MANAGEMENT////////////////
		//////////////////////////////////////////////
		if(event.getSource()==stocksManagementToolButton)
		{
			removeStockButton = new Button("Remove Stock");
			removeStockButton.setOnAction(e -> removeStockButtonClicked());
			stocksManagementLayout = new VBox(10);
			stocksManagementLayout.setPadding(new Insets(20,20,20,20));
			stockSubmitButton = new Button("Add to Stock");
			stockSubmitButton.setOnAction(this);
			if(genMngr.shop_mode == genMngr.ELECSHOP)
			{
				property0Field = new TextField("Electronic Name");
				property1Field = new TextField("Barcode(Number)");
				property2Field = new TextField("Price(Double Number)");
				property3Field = new TextField("Brand");
				property4Field = new TextField("Category");
				property5Field = new TextField("Discount(Number)");
				property6Field = new TextField("Warranty(Number in months)");
				stocksManagementLayout.getChildren().addAll(property0Field, property1Field, property2Field, property3Field, property4Field, property5Field, property6Field, stockSubmitButton, table, removeStockButton);
				stocksManagementScene = new Scene(stocksManagementLayout,1250,1000);
				window.setScene(stocksManagementScene);
			}
			else if(genMngr.shop_mode == genMngr.BOOKSHOP)
			{
				property0Field = new TextField("Book Title");
				property1Field = new TextField("Barcode(Number)");
				property2Field = new TextField("Price(Double Number)");
				property3Field = new TextField("Author");
				property4Field = new TextField("ISBN(Number)");
				property5Field = new TextField("Publisher");
				property6Field = new TextField("Copyrights");
				stocksManagementLayout.getChildren().addAll(property0Field, property1Field, property2Field, property3Field, property4Field, property5Field, property6Field, stockSubmitButton, table, removeStockButton);
				stocksManagementScene = new Scene(stocksManagementLayout,1000,750);
				window.setScene(stocksManagementScene);
			}
			else if(genMngr.shop_mode == genMngr.CLOTHSHOP)
			{
				property0Field = new TextField("Cloth Name");
				property1Field = new TextField("Barcode(Number)");
				property2Field = new TextField("Price(Double Number)");
				property3Field = new TextField("Brand Name");
				property4Field = new TextField("Category");
				property5Field = new TextField("Color");
				property6Field = new TextField("Size");
				
				stocksManagementLayout.getChildren().addAll(property0Field, property1Field, property2Field, property3Field, property4Field, property5Field, property6Field, stockSubmitButton, table, removeStockButton);
				stocksManagementScene = new Scene(stocksManagementLayout,750,500);
			}
			window.setScene(stocksManagementScene);
		}
		
		//////////////////////
		///ADD TO STOCK
		if(event.getSource() == stockSubmitButton)
		{
			String dataToAdd = property0Field.getText() + "-" + property1Field.getText() + "-" + property2Field.getText() + "-" + property3Field.getText() + "-" + property4Field.getText() + "-" + property5Field.getText() + "-" + property6Field.getText();
			
			stockManager.addData(dataToAdd);
			fetchFromDatabaseIntoItemList();
		}
		///ADD TO STOCK
		//////////////////////
		
	}
	/*
	public ObservableList<Item> getItems()
	{
		
	}
	*/
	
	public void fetchFromDatabaseIntoItemList()
	{
		allItemsAvailable.clear();
		ArrayList<String> data = new ArrayList<>();
		data = stockManager.returnData();
		if(genMngr.shop_mode == GeneralManager.ELECSHOP)
		{
			for(int i=0; i<data.size(); i++)
			{
				List<String> list = new ArrayList<String>(Arrays.asList(data.get(i).split("-")));
				allItemsAvailable.add(new ElecItem(list.get(0),Integer.parseInt(list.get(1)),Double.parseDouble(list.get(2)),list.get(3),list.get(4),Integer.parseInt(list.get(5)),Integer.parseInt(list.get(6))));
				System.out.println(data.get(i));
			}
		}
		else if(genMngr.shop_mode == GeneralManager.BOOKSHOP)
		{
			for(int i=0; i<data.size(); i++)
			{
				List<String> list = new ArrayList<String>(Arrays.asList(data.get(i).split("-")));
				allItemsAvailable.add(new BookItem(list.get(0),Integer.parseInt(list.get(1)),Double.parseDouble(list.get(2)),list.get(3),Integer.parseInt(list.get(4)),list.get(5),list.get(6)));
				System.out.println(data.get(i));
			}
		}
		else if(genMngr.shop_mode == GeneralManager.CLOTHSHOP)
		{
			for(int i=0; i<data.size(); i++)
			{
				List<String> list = new ArrayList<String>(Arrays.asList(data.get(i).split("-")));
				allItemsAvailable.add(new ClothItem(list.get(0),Integer.parseInt(list.get(1)),Double.parseDouble(list.get(2)),list.get(3),list.get(4),list.get(5),list.get(6)));
				System.out.println(data.get(i));
			}
		}
		//else if
		//System.out.println(data);
		//allItemsAvailable.add(e);
	}
	
	public void removeStockButtonClicked()
	{
		stockManager.clearStockTable();
		ObservableList<Item> itemSelected;
		itemSelected = table.getSelectionModel().getSelectedItems();
		itemSelected.forEach(allItemsAvailable::remove);
		
		for(int i=0; i<allItemsAvailable.size(); i++)
		{
			stockManager.addData(allItemsAvailable.get(i).returnItemData());
		}
		//fetchFromDatabaseIntoItemList();
	}
	
	public void setUpCommonStocksManagementLayout()
	{
		
	}
	
}

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
	
	boolean stocksSetUp = false, itemRentalSetUp = false, usedGoodsResaleSetUp = false, itemRepairSetUp = false, salesSetUp = false;
	//ITEMS
	public ObservableList<Item> allItemsAvailable = FXCollections.observableArrayList();
	public ObservableList<Item> rentalItems = FXCollections.observableArrayList();
	public ObservableList<Item> usedGoods = FXCollections.observableArrayList();
	public ObservableList<Item> itemsForRepair = FXCollections.observableArrayList();
	public ObservableList<Invoice> invoices = FXCollections.observableArrayList();
	TableView<Item> stocksTable, rentalItemsTable, usedGoodsResaleTable, repairItemsTable;
	TableView<Invoice> salesTable;
	
	GeneralManager genMngr = new GeneralManager();
	SalesManager salesManager = new SalesManager(genMngr);
	StockManager stockManager;
	StockManager rentalItemsManager;
	StockManager usedGoodsManager;
	StockManager repairItemsManager;
	Stage window;
	String storeType = "Electronics";
	String databaseName;
	//PAGES
	Scene scene, electronicsHomeScene, booksHomeScene, clothesHomeScene;
	//COMMON PAGES AND LAYOUTS
	Scene stocksManagementScene, itemRentalScene, itemRepairScene, usedGoodsResaleScene, salesManagementScene;
	Scene takeCustomerFeedbackScene, billingManagementScene;
	VBox stocksManagementLayout, salesManagementLayout, itemRentalLayout, itemRepairLayout, usedGoodsResaleLayout, salesManagerLayout;
	//BUTTONS
	Button button, salesManagementButton, stocksManagementToolButton, takeCustomerFeedbackButton, billingManagementToolButton, salesManagementToolButton, itemRepairOrdersButton, promotionsManagementButton, usedGoodsResaleButton, itemRentalButton;
	Button rentAnItemButton;
	Button createInvoice, addSalesItem, generateReceipt;
	//COMMON BUTTONS
	Button stockSubmitButton, removeStockButton, returnToMenuButton;
	//LAYOUTS
	VBox layout, electronicsHomeLayout, booksHomeLayout, clothesHomeLayout;
	VBox takeCustomerFeedbackLayout, billingManagementLayout;
	//VBox booksStockManagementLayout;
	
	//TEXT FIELDS
	TextField usernameField = new TextField("Username");
	PasswordField  passwordField = new PasswordField();// ("Password");
	
	//COMMON TEXT FIELDS
	TextField property0Field, property1Field, property2Field, property3Field, property4Field, property5Field, property6Field;
	TextField invIDField, custIDField;
	ChoiceBox<String> shopTypeChoiceBox = new ChoiceBox<>();
	
	public static void main(String[] args)
	{
		launch(args);
		//StockManager mg = new StockManager();
		//mg.addData("mahir �zer");
		
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
		returnToMenuButton = new Button("Return to Menu");
		returnToMenuButton.setOnAction(e -> returnToMenu());
		//addStockButton = new Button("Add Stock");
		//button.setOnAction(this);
		salesManagementButton = new Button("Sales Management Tool");
		salesManagementButton.setOnAction(e -> salesManagementToolButtonClicked());
		createInvoice = new Button("Create Invoice");
		addSalesItem = new Button("Add Item");
		generateReceipt = new Button("Generate Reciept");
		stocksManagementToolButton = new Button("Stocks Management Tool");
		stocksManagementToolButton.setOnAction(e -> stocksManagementToolButtonClicked());
		takeCustomerFeedbackButton = new Button("Take Customer Feedback");
		takeCustomerFeedbackButton.setOnAction(e -> takeCustomerFeedbackButtonClicked());
		billingManagementToolButton = new Button("Billing Management Tool");
		billingManagementToolButton.setOnAction(e -> billingManagementToolButtonClicked());
		salesManagementToolButton = new Button("Sales Management Tool");
		salesManagementToolButton.setOnAction(this);
		itemRepairOrdersButton = new Button("Item Repair Order");
		itemRepairOrdersButton.setOnAction(e -> itemRepairButtonClicked());
		promotionsManagementButton = new Button("Promotion Management");
		promotionsManagementButton.setOnAction(this);
		usedGoodsResaleButton = new Button("Used Goods Resale");
		usedGoodsResaleButton.setOnAction(e -> usedGoodsResaleButtonClicked());
		itemRentalButton = new Button("Item Rental");
		itemRentalButton.setOnAction(e -> itemRentalButtonClicked());
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
			if(shopTypeChoiceBox.getValue()=="Electronics")
			{
				genMngr.shop_mode = GeneralManager.ELECSHOP;
			}
			else if(shopTypeChoiceBox.getValue()=="Books")
			{
				genMngr.shop_mode = GeneralManager.BOOKSHOP;
			}
			else if(shopTypeChoiceBox.getValue()=="Clothes")
			{
				genMngr.shop_mode = GeneralManager.CLOTHSHOP;
			}
			System.out.println("submitted");
			salesTable = new TableView<>();
			stocksTable = new TableView<>();
			rentalItemsTable = new TableView<>();
			usedGoodsResaleTable = new TableView<>();
			repairItemsTable = new TableView<>();
			setTextFields(); //Set up the pages
			

			//////////////////SET TABLES////////////////////////
			//////////////////////////////////////////
			///////ALL ITEMS stocksTable COMMON ATTRIBUTES
			TableColumn<Item, String> nameColumn = new TableColumn<>("Name");
			nameColumn.setMinWidth(200);
			nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
			TableColumn<Item, Integer> barcodeColumn = new TableColumn<>("Barcode");
			barcodeColumn.setMinWidth(200);
			barcodeColumn.setCellValueFactory(new PropertyValueFactory<>("barcode"));
			TableColumn<Item, Double> priceColumn = new TableColumn<>("Price");
			priceColumn.setMinWidth(200);
			priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
			TableColumn<Item, String> rentalNameColumn = new TableColumn<>("Name");
			rentalNameColumn.setMinWidth(200);
			rentalNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
			TableColumn<Item, String> rentalTimeColumn = new TableColumn<>("Rental Time");
			rentalTimeColumn.setMinWidth(200);
			//rentalTimeColumn.setUserData("3 weeks");
			///ALL ITEMS stocksTable COMMON ATTRIBUTES
			///////////////////////////////////////////
			
			/* SALES MANAGER TABLE PROPERTIES */
			TableColumn<Invoice, Integer> invIDColumn = new TableColumn<>("Invoice ID");
			invIDColumn.setMinWidth(100);
			invIDColumn.setCellValueFactory(new PropertyValueFactory<>("invoiceID"));
			TableColumn<Invoice, Integer> custIDColumn = new TableColumn<>("Customer ID");
			custIDColumn.setMinWidth(100);
			custIDColumn.setCellValueFactory(new PropertyValueFactory<>("custId"));
			TableColumn<Invoice, Integer> TotalColumn = new TableColumn<>("Total Price");
			TotalColumn.setMinWidth(100);
			TotalColumn.setCellValueFactory(new PropertyValueFactory<>("totalprice"));
			TableColumn<Invoice, String> itemsColumn = new TableColumn<>("Items");
			itemsColumn.setMinWidth(100);
			itemsColumn.setCellValueFactory(new PropertyValueFactory<>("stringOfItems"));
			
			ArrayList<Invoice> invList = salesManager.getInvoiceList();
			for(int ind = 0; ind < invList.size(); ind++) {
				invoices.add(invList.get(ind));
			}
			salesTable.setItems(invoices);
			salesTable.getColumns().addAll(invIDColumn, custIDColumn, TotalColumn, itemsColumn);
			
			
			if(GeneralManager.shop_mode == GeneralManager.ELECSHOP)
			{
				databaseName = "electronicStocks.txt";
				stockManager = new StockManager(databaseName);
				fetchFromDatabaseIntoItemList(stockManager, allItemsAvailable);
				///////////////////////////
				//SET UP stocksTable
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
				
				//fetchFromDatabaseIntoItemList(stockManager, allItemsAvailable);
				stocksTable.setItems(allItemsAvailable);
				stocksTable.getColumns().addAll(
						nameColumn, 
						barcodeColumn, 
						priceColumn, 
						brandColumn, 
						categoryColumn, 
						discountColumn, 
						warrantyColumn);
				//SET UP stocksTable
				//////////////////////////
			}
			
			else if(genMngr.shop_mode == GeneralManager.BOOKSHOP)
			{
				databaseName = "bookStocks.txt";
				stockManager = new StockManager(databaseName);
				fetchFromDatabaseIntoItemList(stockManager, allItemsAvailable);
				///////////////////////////
				//SET UP stocksTable
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
				
				//fetchFromDatabaseIntoItemList(stockManager, allItemsAvailable);
				stocksTable.setItems(allItemsAvailable);
				stocksTable.getColumns().addAll(
						nameColumn, 
						barcodeColumn, 
						priceColumn, 
						authorColumn, 
						isbnColumn, 
						publisherColumn, 
						copyrightsColumn);
				//SET UP stocksTable
				//////////////////////////
				
				rentalItemsTable.getColumns().addAll(rentalNameColumn, rentalTimeColumn);
			}
			else if(genMngr.shop_mode == GeneralManager.CLOTHSHOP)
			{
				databaseName = "clothStocks.txt";
				stockManager = new StockManager(databaseName);
				fetchFromDatabaseIntoItemList(stockManager, allItemsAvailable);
				///////////////////////////
				//SET UP stocksTable
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
				
				//fetchFromDatabaseIntoItemList(stockManager, allItemsAvailable);
				stocksTable.setItems(allItemsAvailable);
				stocksTable.getColumns().addAll(
						nameColumn, 
						barcodeColumn, 
						priceColumn, 
						brandColumn, 
						categoryColumn, 
						colorColumn, 
						sizeColumn);
				//SET UP stocksTable
				//////////////////////////
				rentalItemsTable.getColumns().addAll(rentalNameColumn, rentalTimeColumn);
			}
			//////////////SET TABLES/////////////
			/////////////////////////////////////
			//window.show();
			//System.out.println(shopTypeChoiceBox.getValue());
			/////////////////////////////////
			/////SET UP ELECTRONICS SHOP
			if(genMngr.shop_mode == GeneralManager.ELECSHOP)
			{
				

				
				electronicsHomeLayout = new VBox(10);
				electronicsHomeLayout.setPadding(new Insets(20,20,20,20));
				electronicsHomeLayout.setStyle("-fx-background-color: red");
				
				electronicsHomeLayout.getChildren().addAll(stocksManagementToolButton, salesManagementButton, takeCustomerFeedbackButton, billingManagementToolButton, itemRepairOrdersButton, promotionsManagementButton, usedGoodsResaleButton);
				electronicsHomeScene = new Scene(electronicsHomeLayout, 500, 500);
				window.setScene(electronicsHomeScene);
				storeType = "Electronics";

			}
			///SET UP ELECTRONICS SHOP
			/////////////////////////
			
			/////////////////////////
			///SET UP BOOK SHOP
			else if (genMngr.shop_mode == GeneralManager.BOOKSHOP)
			{
				booksHomeLayout = new VBox(10);
				booksHomeLayout.setPadding(new Insets(20,20,20,20));
				booksHomeLayout.setStyle("-fx-background-color: blue");
				
				booksHomeLayout.getChildren().addAll(
						stocksManagementToolButton,
						salesManagementButton,
						takeCustomerFeedbackButton, 
						billingManagementToolButton, 
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
			else if(genMngr.shop_mode == GeneralManager.CLOTHSHOP)
			{
				//setMode
				genMngr.shop_mode = GeneralManager.CLOTHSHOP;
				

				
				clothesHomeLayout = new VBox(10);
				clothesHomeLayout.setPadding(new Insets(20,20,20,20));
				clothesHomeLayout.setStyle("-fx-background-color: green");
				
				clothesHomeLayout.getChildren().addAll(stocksManagementToolButton, salesManagementButton, takeCustomerFeedbackButton, billingManagementToolButton, promotionsManagementButton, itemRentalButton);
				clothesHomeScene = new Scene(clothesHomeLayout, 500, 500);
				window.setScene(clothesHomeScene);
				//storeType = "Clothes";
			}
			////////////////////////////////////
			////////////////////////////////////
		}
		

		
	}

	public void setTextFields()
	{
		removeStockButton = new Button("Remove Stock");
		removeStockButton.setOnAction(e -> removeStockButtonClicked());
		
		salesManagementLayout = new VBox(10);
		salesManagementLayout.setPadding(new Insets(20,20,20,20));
		stocksManagementLayout = new VBox(10);
		stocksManagementLayout.setPadding(new Insets(20,20,20,20));
		itemRentalLayout = new VBox(10);
		itemRentalLayout.setPadding(new Insets(20,20,20,20));
		itemRepairLayout = new VBox(10);
		itemRepairLayout.setPadding(new Insets(20,20,20,20));
		usedGoodsResaleLayout = new VBox(10);
		usedGoodsResaleLayout.setPadding(new Insets(20,20,20,20));
		
		Label takeCustomerFeedbackLabel = new Label("Take customer feedback, same for all shops");
		Label billingManagementLabel = new Label("Billing management, same for all shops");
		takeCustomerFeedbackLayout = new VBox(10);
		takeCustomerFeedbackLayout.setPadding(new Insets(20,20,20,20));
		takeCustomerFeedbackLayout.getChildren().addAll(takeCustomerFeedbackLabel, returnToMenuButton);
		billingManagementLayout = new VBox(10);
		billingManagementLayout.setPadding(new Insets(20,20,20,20));
		billingManagementLayout.getChildren().addAll(billingManagementLabel, returnToMenuButton);
		stockSubmitButton = new Button("Add to Stock");
		stockSubmitButton.setOnAction(e -> addStockButtonClicked());
		
		takeCustomerFeedbackScene = new Scene(takeCustomerFeedbackLayout, 600, 600);
		billingManagementScene = new Scene(billingManagementLayout, 600, 600);
		if(genMngr.shop_mode == genMngr.ELECSHOP)
		{
			property0Field = new TextField("Electronic Name");
			property1Field = new TextField("Barcode(Number)");
			property2Field = new TextField("Price(Double Number)");
			property3Field = new TextField("Brand");
			property4Field = new TextField("Category");
			property5Field = new TextField("Discount(Number)");
			property6Field = new TextField("Warranty(Number in months)");
			//stocksManagementLayout.getChildren().addAll(property0Field, property1Field, property2Field, property3Field, property4Field, property5Field, property6Field, stockSubmitButton, stocksTable, removeStockButton, returnToMenuButton);
			//stocksManagementScene = new Scene(stocksManagementLayout,1250,1000);
			
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
			//stocksManagementLayout.getChildren().addAll(property0Field, property1Field, property2Field, property3Field, property4Field, property5Field, property6Field, stockSubmitButton, stocksTable, removeStockButton, returnToMenuButton);
			//stocksManagementScene = new Scene(stocksManagementLayout,1000,750);
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
		}
		invIDField = new TextField("Invoice ID");
		custIDField = new TextField("Customer ID");
	}
	////////////////////////////////////////////////////
	///SET UP SCENES
	public void setUpStocksManagementScene()
	{
		stocksManagementLayout.getChildren().addAll(property0Field, property1Field, property2Field, property3Field, property4Field, property5Field, property6Field, stockSubmitButton, stocksTable, removeStockButton, returnToMenuButton);
		stocksManagementScene = new Scene(stocksManagementLayout,900,500);
	}
	public void setUpSalesManagementScene()
	{
		salesManagementLayout.getChildren().addAll(returnToMenuButton, invIDField, custIDField, salesTable, createInvoice, addSalesItem, generateReceipt);
		salesManagementScene = new Scene(salesManagementLayout,900,500);
	}
	public void setUpItemRentalScene()
	{
		String database2 = "";
		rentAnItemButton = new Button("Rent this item");
		rentAnItemButton.setOnAction(e -> rentAnItemButtonClicked());
		if(genMngr.shop_mode == GeneralManager.BOOKSHOP)
		{
			databaseName = "bookStocks.txt";
			stocksTable.setItems(allItemsAvailable);
			database2 = "bookRental.txt";
		}
		else if(genMngr.shop_mode == GeneralManager.CLOTHSHOP)
		{
			databaseName = "clothStocks.txt";
			stocksTable.setItems(allItemsAvailable);
			database2 = "clothRental.txt";
		}
		//stockManager = new StockManager(databaseName);
		fetchFromDatabaseIntoItemList(stockManager, allItemsAvailable);
		
		rentalItemsManager = new StockManager(database2);
		fetchFromDatabaseIntoItemList(rentalItemsManager, rentalItems);
		rentalItemsTable.setItems(rentalItems);
		
		itemRentalLayout.getChildren().addAll(stocksTable, rentAnItemButton, rentalItemsTable, returnToMenuButton);
		itemRentalScene = new Scene(itemRentalLayout, 900,900);
		//*/
	}
	public void setUpItemRepairScene()
	{
		itemRepairLayout.getChildren().addAll(property0Field, property1Field, property2Field, property3Field, property4Field, property5Field, property6Field, stockSubmitButton, stocksTable, removeStockButton, returnToMenuButton);
		itemRepairScene = new Scene(itemRepairLayout, 1100,1100);
	}
	public void setUpUsedGoodsResaleScene()
	{
		usedGoodsResaleLayout.getChildren().addAll(property0Field, property1Field, property2Field, property3Field, property4Field, property5Field, property6Field, stockSubmitButton, stocksTable, removeStockButton, returnToMenuButton);
		usedGoodsResaleScene = new Scene(usedGoodsResaleLayout, 1250,750);
	}
	
	public void stocksManagementToolButtonClicked()
	{
		if(stocksSetUp==false)
		setUpStocksManagementScene();
		stocksSetUp=true;
		window.setScene(stocksManagementScene);
	}
	public void salesManagementToolButtonClicked()
	{
		if(salesSetUp==false)
		setUpSalesManagementScene();
		salesSetUp=true;
		window.setScene(salesManagementScene);
	}
	public void itemRentalButtonClicked()
	{
		if(itemRentalSetUp==false)
		setUpItemRentalScene();
		itemRentalSetUp=true;
		window.setScene(itemRentalScene);
	}
	public void itemRepairButtonClicked()
	{
		if(itemRepairSetUp==false)
		setUpItemRepairScene();
		itemRepairSetUp=true;
		window.setScene(itemRepairScene);
	}
	public void usedGoodsResaleButtonClicked()
	{
		if(usedGoodsResaleSetUp==false)
		setUpUsedGoodsResaleScene();
		usedGoodsResaleSetUp=true;
		window.setScene(usedGoodsResaleScene);
	}
	public void takeCustomerFeedbackButtonClicked()
	{
		if(!takeCustomerFeedbackLayout.getChildren().contains(returnToMenuButton))
			takeCustomerFeedbackLayout.getChildren().add(returnToMenuButton);
		window.setScene(takeCustomerFeedbackScene);
	}
	public void billingManagementToolButtonClicked()
	{
		if(!billingManagementLayout.getChildren().contains(returnToMenuButton))
			billingManagementLayout.getChildren().add(returnToMenuButton);
		window.setScene(billingManagementScene);
	}
	///SET UP SCENES
	////////////////////////////////////////////
	
	public void fetchFromDatabaseIntoItemList(StockManager myManager, ObservableList<Item> myList)
	{
		myList.clear();
		ArrayList<String> data = new ArrayList<>();
		data = myManager.returnData();
		if(genMngr.shop_mode == GeneralManager.ELECSHOP)
		{
			for(int i=0; i<data.size(); i++)
			{
				List<String> list = new ArrayList<String>(Arrays.asList(data.get(i).split("-")));
				myList.add(new ElecItem(list.get(0),Integer.parseInt(list.get(1)),Double.parseDouble(list.get(2)),list.get(3),list.get(4),Integer.parseInt(list.get(5)),Integer.parseInt("0")));
				System.out.println(data.get(i));
			}
		}
		else if(genMngr.shop_mode == GeneralManager.BOOKSHOP)
		{
			for(int i=0; i<data.size(); i++)
			{
				List<String> list = new ArrayList<String>(Arrays.asList(data.get(i).split("-")));
				myList.add(new BookItem(list.get(0),Integer.parseInt(list.get(1)),Double.parseDouble(list.get(2)),list.get(3),Integer.parseInt(list.get(4)),list.get(5),list.get(6), Integer.parseInt("0")));
				System.out.println(data.get(i));
			}
		}
		else if(genMngr.shop_mode == GeneralManager.CLOTHSHOP)
		{
			for(int i=0; i<data.size(); i++)
			{
				List<String> list = new ArrayList<String>(Arrays.asList(data.get(i).split("-")));
				myList.add(new ClothItem(list.get(0),Integer.parseInt(list.get(1)),Double.parseDouble(list.get(2)),list.get(3),list.get(4),list.get(5),list.get(6), Integer.parseInt("0")));
				System.out.println(data.get(i));
			}
		}
		//else if
		//System.out.println(data);
		//allItemsAvailable.add(e);
	}

	public void rentAnItemButtonClicked()
	{
		//String dataToAdd = property0Field.getText() + "-" + property1Field.getText() + "-" + property2Field.getText() + "-" + property3Field.getText() + "-" + property4Field.getText() + "-" + property5Field.getText() + "-" + property6Field.getText();
		ObservableList<Item> itemSelected;
		itemSelected = stocksTable.getSelectionModel().getSelectedItems();
		for(int i=0; i<itemSelected.size(); i++)
		{
			String dataToAdd;
			dataToAdd = itemSelected.get(i).returnItemData();
			rentalItemsManager.addData(dataToAdd);
		}
		removeStockButtonClicked();
		//rentalItemsManager.addData(dataToAdd);
		//rentalItems
		fetchFromDatabaseIntoItemList(rentalItemsManager, rentalItems);
		rentalItemsTable.setItems(rentalItems);
	}
	
	public void addStockButtonClicked()
	{
			String dataToAdd = property0Field.getText() + "-" + property1Field.getText() + "-" + property2Field.getText() + "-" + property3Field.getText() + "-" + property4Field.getText() + "-" + property5Field.getText() + "-" + property6Field.getText();
			
			stockManager.addData(dataToAdd);
			fetchFromDatabaseIntoItemList(stockManager, allItemsAvailable);
		///ADD TO STOCK
		//////////////////////
	}
	
	public void removeStockButtonClicked()
	{
		stockManager.clearStockTable();
		ObservableList<Item> itemSelected;
		itemSelected = stocksTable.getSelectionModel().getSelectedItems();
		itemSelected.forEach(allItemsAvailable::remove);
		
		for(int i=0; i<allItemsAvailable.size(); i++)
		{
			stockManager.addData(allItemsAvailable.get(i).returnItemData());
		}
		//fetchFromDatabaseIntoItemList();
	}
	
	public void returnToMenu()
	{
		if(genMngr.shop_mode == GeneralManager.ELECSHOP)
		{
			//itemRentalLayout.getChildren().clear();
			//stocksManagementLayout.getChildren().clear();
			window.setScene(electronicsHomeScene);
		}
		else if(genMngr.shop_mode == GeneralManager.BOOKSHOP)
		{
			//itemRentalLayout.getChildren().clear();
			//stocksManagementLayout.getChildren().clear();
			window.setScene(booksHomeScene);
		}
		else if(genMngr.shop_mode == GeneralManager.CLOTHSHOP)
		{
			//itemRentalLayout.getChildren().clear();
			//stocksManagementLayout.getChildren().clear();
			window.setScene(clothesHomeScene);
		}
	}
	public void setUpRentalTable()
	{
		TableColumn<Item, String> nameColumn = new TableColumn<>("Name");
		nameColumn.setMinWidth(200);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		TableColumn<Item, Integer> barcodeColumn = new TableColumn<>("Barcode");
		barcodeColumn.setMinWidth(200);
		barcodeColumn.setCellValueFactory(new PropertyValueFactory<>("barcode"));
		TableColumn<Item, Double> priceColumn = new TableColumn<>("Price");
		priceColumn.setMinWidth(200);
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
	}
	
}

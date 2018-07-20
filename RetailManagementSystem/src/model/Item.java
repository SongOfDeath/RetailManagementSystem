package model;

public class Item {
	
	String name;
	int barcode;
	double price;
	
	//CONSTRUCTORS
	public Item() {
		barcode = -1;
		price = -1;
	}
	public Item (String name, int barcode, double price){
		this.name = name;
		this.barcode = barcode;
		this.price = price;
	}
	//GETTERS
	public String getName() {
		return this.name;
	}
	public double getPrice() {
		return this.price;
	}
	public int getBarcode() {
		return this.barcode;
	}
	//SETTERS
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice( double price ) {
		this.price = price;
	}
	public void setBarcode( int barcode) {
		this.barcode = barcode;
	}
}

package model;

public class Item {
	
	String name;
	int barcode;
	double price;
	int discount;
	
	//CONSTRUCTORS
	public Item() {
		name = "";
		barcode = -1;
		price = -1;
		discount = 0;
	}
	public Item (String name, int barcode, double price, int discount){
		this.name = name;
		this.barcode = barcode;
		this.price = price;
		this.discount = discount;
	}

	public String returnItemData()
	{
		String s = name + "-" + barcode + "-" + price + "-" + discount;
		return s;
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
	public int getDiscount() {
		return discount;
	}

	
	//SETTERS
	public void setName(String name) {
		this.name = name;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public void setPrice( double price ) {
		this.price = price;
	}
	public void setBarcode( int barcode) {
		this.barcode = barcode;
	}
}

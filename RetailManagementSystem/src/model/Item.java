package model;

public class Item {
	
	int barcode;
	double price;
	
	public Item() {
		barcode = -1;
		price = -1;
	}
	public Item (int barcode, double price){
		this.barcode = barcode;
		this.price = price;
	}
	
	public double getPrice() {
		return this.price;
	}
	public int getBarcode() {
		return this.barcode;
	}
	public void setPrice( double price ) {
		this.price = price;
	}
	public void setBarcode( int barcode) {
		this.barcode = barcode;
	}
}

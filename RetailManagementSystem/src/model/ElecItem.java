package model;

public class ElecItem extends Item{
	
	String brand;
	String category;
	int discount;
	int warrantyInMonths;
	
	
	public ElecItem()
	{
		brand = "Siemens";
		category = "Computer";
		discount = 0;
		warrantyInMonths = 3;
	}
	// Constructor
	public ElecItem(String name, int barcode, double price, String brand, String category, int discount, int warranty) {
		super(name, barcode, price);
		this.brand = brand;
		this.category = category;
		this.discount = discount;
		this.warrantyInMonths = warranty;
	}
	
	@Override
	public String toString() {
		return "ElecItem [brand=" + brand + ", category=" + category + ", discount=" + discount + ", warrantyInMonths="
				+ warrantyInMonths + ", name=" + name + ", barcode=" + barcode + ", price=" + price + "]";
	}

	//GETTERS
	public String getBrand() {
		return brand;
	}
	public String getCategory() {
		return category;
	}
	public int getDiscount() {
		return discount;
	}
	public int getWarranty() {
		return warrantyInMonths;
	}
	//SETTERS
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public void setWarranty(int warranty) {
		this.warrantyInMonths = warranty;
	}
}

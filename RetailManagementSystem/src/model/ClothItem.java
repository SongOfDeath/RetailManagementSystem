package model;

public class ClothItem extends Item {
	
	String brand;
	String category;
	String color;
	String size;
	String gender;
	
	public ClothItem(String name, int barcode, double price, String brand, String category, String color,
			String size, String gender) {
		
		super(name, barcode, price);
		this.brand = brand;
		this.category = category;
		this.color = color;
		this.size = size;
		this.gender = gender;
	}
	
	public String getBrand() {
		return brand;
	}
	public String getCategory() {
		return color;
	}
	public String getSize() {
		return size;
	}
	public String getGender() {
		return gender;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}

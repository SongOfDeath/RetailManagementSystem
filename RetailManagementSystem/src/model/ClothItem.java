package model;

public class ClothItem extends Item {
	
	String brand;
	String category;
	String color;
	String size;
	String gender;
	int discount;
	
	public ClothItem(String name, int barcode, double price, String brand, String category, String color,
			String size, String gender, int discount) {
		
		super(name, barcode, price);
		this.brand = brand;
		this.category = category;
		this.color = color;
		this.size = size;
		this.gender = gender;
		this.discount = discount;
	}
	
	public ClothItem(String name, int barcode, double price, String brand, String category, String color,
			String size) {
		
		super(name, barcode, price);
		this.brand = brand;
		this.category = category;
		this.color = color;
		this.size = size;
	}

	@Override
	public String returnItemData()
	{
		String s = name + "-" + barcode + "-" + price + "-" + brand + "-" + category + "-" + color + "-" + size;
		return s;
	}
	
	@Override
	public String toString() {
		return "ClothItem [brand=" + brand + ", category=" + category + ", color=" + color + ", size=" + size
				+ ", gender=" + gender + ", discount=" + discount + ", name=" + name + ", barcode=" + barcode
				+ ", price=" + price + "]";
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
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

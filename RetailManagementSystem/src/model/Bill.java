package model;

public class Bill {
	int amount;
	String description;
	String name;
	//Constructor
	public Bill(){
		amount = -1;
		name = "";
		description = "";
	}
	//Getter
	public int getAmount() {
		return amount;
	}

	public String getDescription() {
		return description;
	}
	public String getName() {
		return name;
	}
	//Setter
	public void setDescription(String description) {
		this.description = description;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setName(String name) {
		this.name = name;
	}
}

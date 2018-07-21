package model;

public class Bill {
	int amount;
	String description;
	String name;
	String dueDate;
	String issueDate;
	//Constructor
	public Bill() {
		amount = -1;
		name = "";
		description = "";
		dueDate = " ";
		issueDate ="";
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
	
	public String toString() {
		return name + "-" + amount + "-" + issueDate + "-" + dueDate + "-" + description;
	}
	
	public boolean equals(Object bill) {
		if (bill == null) {
			return false;
		}
		if (bill == this) {
			return true;
		}
		if (!(bill instanceof Bill)) {
			return false;
		}
		Bill b = (Bill) bill;
		boolean b1 = b.amount == this.amount;
		boolean b2 = b.name.equals(this.name);
		boolean b3 = b.dueDate.equals(this.dueDate);
		boolean b4 = b.issueDate.equals(this.issueDate);
		boolean b5 = b.description.equals(this.description);
		return b1 && b2 && b3 && b4 && b5;
	}
}

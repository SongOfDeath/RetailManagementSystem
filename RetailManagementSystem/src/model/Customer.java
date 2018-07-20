package model;

public class Customer {
	int ID;
	String address;
	Invoice invoice;
	int contactNum;
	int orderNum;
	int []orderHistory;
	//Constructor
	public Customer() {
		ID = -1;
		orderNum = 0;
		contactNum = -1;
		address = "";
		orderHistory = new int[orderNum];
	}
	//Setter
	public void setOrderhistory(int orderNum) {
		this.orderNum = orderNum;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	public void address(String address) {
		this.address = address;
	}
	public void setContactnum(int contactNum) {
		this.contactNum = contactNum;
	}
	//Getter
	public int getID() {
		return ID;
	}
	public String getAddress() {
		return address;
	}
	public int getContactnum() {
		return contactNum;
	}
	public Invoice getInvoice() {
		return invoice;
	}


}


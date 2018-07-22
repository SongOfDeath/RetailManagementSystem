package model;

import java.util.ArrayList;

public class Customer {
	int ID;
	String address;
	int contactNum;
	ArrayList<Integer> orderHistory;
	
	//Constructor
	public Customer() {
		ID = -1;
		contactNum = -1;
		address = "";
		orderHistory = new ArrayList<>();
	}
	
	public Customer(int ID, String address, int contactNum) {
		this.ID = ID;
		this.address = address;
		this.contactNum = contactNum;
	}
	
	//Setter
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
	
	public void addOrderNo(int num) {
		this.orderHistory.add(num);
	}
	
	public boolean searchOrder(int num) {
		for(int i = 0; i < orderHistory.size(); i++) {
			if(orderHistory.get(i) == num)
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Customer [ID=" + ID + ", address=" + address + ", contactNum=" + contactNum + ", orderHistory="
				+ orderHistory + "]";
	}

}


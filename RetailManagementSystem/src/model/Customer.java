package model;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Customer {
	int ID;
	String address;
	int contactNum;
	String orderHistory;
	
	//Constructor
	public Customer() {
		ID = -1;
		contactNum = -1;
		address = "-1";
		orderHistory = "-1";
	}
	
	public Customer(int ID, String address, int contactNum, String orderHistory) {
		this.ID = ID;
		this.address = address;
		this.contactNum = contactNum;
		this.orderHistory = orderHistory;
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
	public String getOrderHistory() {
		return this.orderHistory;
	}
	
	//Adding to orderHistory and searching orders
	public void addOrderNo(int num) {
		this.orderHistory = this.orderHistory + "," + num;
	}
	public boolean searchOrder(int invoiceID) {
		StringTokenizer tok = new StringTokenizer(orderHistory, ",");
		while(tok.hasMoreTokens()) {
			if(Integer.parseInt(tok.nextToken()) == invoiceID) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Customer [ID=" + ID + ", address=" + address + ", contactNum=" + contactNum + ", orderHistory="
				+ orderHistory + "]";
	}

}


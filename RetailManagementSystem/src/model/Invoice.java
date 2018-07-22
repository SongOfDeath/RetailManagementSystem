package model;

import java.util.ArrayList;

public class Invoice {
	int invoiceID;
	int custId;
	double totalprice;
	ArrayList<Item> items;
	
	
	public Invoice(int invID, int custID) {
		items = new ArrayList<>();
		this.invoiceID = invID;
		this.custId = custID;
		totalprice = 0;
	}
	
	public void addItem(Item item) {
		items.add(item);
	}
	
	public double generateTotal(){
		this.totalprice = 0;
		for(int i = 0; i < items.size(); i++) {
			this.totalprice = totalprice + items.get(i).getPrice();
		}
		return totalprice;
	}
	
	public void printItemList() {
		for(int i=0; i < items.size(); i++) {
			System.out.println(items.get(i).returnItemData());
		}
	}
	public int getInvoiceID() {
		return invoiceID;
	}

	public void setInvoiceID(int invoiceID) {
		this.invoiceID = invoiceID;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

	@Override
	public String toString() {
		return "Invoice [invoiceID=" + invoiceID + ", custId=" + custId + ", totalprice=" + totalprice + ", items="
				+ items + "]";
	}
	
	
}

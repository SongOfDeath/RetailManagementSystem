package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import model.Customer;

public class CustomerControl {
	
	String filename;
	ArrayList<Customer> customerList;
	
	public CustomerControl() {
		filename = "customers.txt";
		customerList = new ArrayList<>();
		try {
			Scanner sc = new Scanner(new File("customers.txt"));
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				StringTokenizer tok = new StringTokenizer(line);
				customerList.add(new Customer(Integer.parseInt(tok.nextToken()), tok.nextToken(), Integer.parseInt(tok.nextToken()), tok.nextToken()));
			}	
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void addCustomer(int ID, String address, int contact, String invoiceID) {
		//add customer to list
		Customer cust = new Customer(ID, address, contact, invoiceID);
		customerList.add(cust);
		//update txt file
		try {
			updateTextFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addCustomerOrder(int custID, int num) {
		int custIndex = findCustomerIndex(custID);
		Customer temp = customerList.get(custIndex);
		temp.addOrderNo(num);
		customerList.set(custIndex, temp);
		try {
			updateTextFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int findCustomerIndex(int ID) {
		for(int i = 0; i < customerList.size(); i++) {
			if(customerList.get(i).getID() == ID) {
				return i;
			}
		}
		return -1;
	}
	
	public void printList() {
		for(int i = 0; i < customerList.size(); i++) {
			System.out.println(customerList.get(i).toString());
		}
	}
	
	public void updateTextFile() throws IOException {
		PrintWriter pwriter = new PrintWriter("customers.txt");
		pwriter.print("");
		pwriter.close();
		
		FileWriter writer = new FileWriter("customers.txt", true);
		BufferedWriter bufferedWriter = new BufferedWriter(writer);
		bufferedWriter.write(customerList.get(0).getID() + " " + customerList.get(0).getAddress() + " " + customerList.get(0).getContactnum() + " " + customerList.get(0).getOrderHistory());
		for(int i=1; i < customerList.size(); i++) {
			String str = "\n" + customerList.get(i).getID() + " " + customerList.get(i).getAddress() + " " + customerList.get(i).getContactnum() + " " + customerList.get(i).getOrderHistory();
			bufferedWriter.write(str);
		}
		bufferedWriter.close();
	}
}

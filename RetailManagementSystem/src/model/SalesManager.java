package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import controller.GeneralManager;

public class SalesManager {
	
	ArrayList<Invoice> invoicelist;
	String filename;
	int count = 0;
	
	public SalesManager(GeneralManager genMngr) {
		Invoice temp;
		Item tempItem;
		invoicelist = new ArrayList<>();
		filename = genMngr.getSalesFile();
		//read the sales file
		try {
			Scanner sc = new Scanner(new File(filename));
			System.out.println(filename);
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				StringTokenizer tok = new StringTokenizer(line);
				temp = new Invoice(Integer.parseInt(tok.nextToken()), Integer.parseInt(tok.nextToken()));
				tok.nextToken();
				while(tok.hasMoreTokens()) {
					StringTokenizer itemtokenizor = new StringTokenizer(tok.nextToken());
					tempItem = new Item();
					tempItem.setName(itemtokenizor.nextToken("-"));
					tempItem.setBarcode(Integer.parseInt(itemtokenizor.nextToken("-")));
					tempItem.setPrice(Double.parseDouble(itemtokenizor.nextToken("-")));
					temp.addItem(tempItem);
				}
				temp.generateTotal();
				invoicelist.add(temp);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public int makeNewInvoice(int custID) {
		Invoice invoice = new Invoice(this.count, custID);
		invoicelist.add(invoice);
		count++;
		return (count-1);
	}
	
	public void addItemToInvoice(int invoiceID, Item item) throws IOException {
		Invoice invoice;
		int ind, ID = -1;
		for(ind = 0; ind<invoicelist.size(); ind++) {
			if(invoicelist.get(ind).getInvoiceID() == invoiceID)
				ID = invoicelist.get(ind).getInvoiceID();
				break;
		}
		if(ID == -1)
			System.out.println("Invoice not found!");
		else {
			invoicelist.get(ind).items.add(item);
			updateTextFile();
		}
	}
	
	
	
	
	public void updateTextFile() throws IOException {
		PrintWriter pwriter = new PrintWriter(filename);
		pwriter.print("");
		pwriter.close();
		
		FileWriter writer = new FileWriter(filename, true);
		BufferedWriter bufferedWriter = new BufferedWriter(writer);
		bufferedWriter.write(invoicelist.get(0).getInvoiceID() + " " + invoicelist.get(0).getCustId() + " " + invoicelist.get(0).getTotalprice());
		for(int j = 0; j<invoicelist.get(0).items.size(); j++) {
			bufferedWriter.write(invoicelist.get(0).items.get(j).name + "-" + invoicelist.get(0).items.get(j).barcode + invoicelist.get(0).items.get(j).price);
		}
		for(int i=1; i < invoicelist.size(); i++) {
			bufferedWriter.write("\n" + invoicelist.get(i).getInvoiceID() + " " + invoicelist.get(i).getCustId() + " " + invoicelist.get(i).getTotalprice());
			for(int k = 0; k<invoicelist.get(0).items.size(); k++) {
				bufferedWriter.write(invoicelist.get(i).items.get(k).name + "-" + invoicelist.get(i).items.get(k).barcode + invoicelist.get(i).items.get(k).price);
			}
		}
		bufferedWriter.close();
	}
	
	
	public void printList() {
		for(int i=0; i<invoicelist.size(); i++) {
			System.out.println(invoicelist.get(i).invoiceID);
			invoicelist.get(i).printItemList();
		}
	}
}

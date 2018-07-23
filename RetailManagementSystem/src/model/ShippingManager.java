package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ShippingManager {
	Item item;
	String status;
	//Constructor
	public ShippingManager(Item item, String status) {
		this.item = item;
		this.status = status;
	}
	public void addShipment() {
		try {
			FileWriter fileWriter;
			fileWriter = new FileWriter("shipment", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(item.returnItemData() + "-" + status);
            bufferedWriter.close();
		} catch (IOException e) {
            throw new RuntimeException(e);
        }
	}
	public void listShipments() {
		try {
			File file = new File("shipment");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				stringBuffer.append(line);
				stringBuffer.append("\n");
			}
			fileReader.close();
			System.out.println("Shipments of customers are:");
			System.out.println("- " + stringBuffer.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

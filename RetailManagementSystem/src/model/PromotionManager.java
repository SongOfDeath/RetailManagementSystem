package model;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PromotionManager {
	double newP; 
	Item item;
	String filename;
	String[] words;
	String word;
	//Constructor
	public PromotionManager(Item item, String filename) {
		this.item = item;
		this.filename = filename;
		words = new String[100];
		words[0] = " ";
	}
	public void addPromotion(int promo) {
		newP = item.price - item.discount;
		item.price = newP;
		if(filename.substring(0,1) == "b") {
			try {
				FileWriter fileWriter = new FileWriter("book_stocks");
				File file = new File(filename);
				FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				String line;
				
				boolean found = false;
				while ((line = bufferedReader.readLine()) != null) {
					words = line.split(" ");
					if(words[0].equals(item.getName())) {
						words[2].equals(String.valueOf(newP));
						fileWriter.write(words[0] + words[1] + words[2] + words[3] + words[4] + words[5] + words[6]);
						found = true;
						
					}
					for(int i = 7; i < 100; i = i + 7) {
						if(words[i].equals(item.getName())) {
							words[i+2].equals(String.valueOf(newP));
							fileWriter.write(words[i] + words[i+1] + words[i+2] + words[i+3] + words[i+4] + words[i+5] + words[i+6]);
							found = true;
							
						}
					}
						
					
				}
				fileReader.close();
	
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(filename.substring(0,1) == "c") {
			try {
				FileWriter fileWriter = new FileWriter("cloth_stocks");
				File file = new File(filename);
				FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				String line;
				
				boolean found = false;
				while ((line = bufferedReader.readLine()) != null) {
					words = line.split(" ");
					if(words[0].equals(item.getName())) {
						words[2].equals(String.valueOf(newP));
						fileWriter.write(words[0] + words[1] + words[2] + words[3] + words[4] + words[5] + words[6]);
						found = true;
						
					}
					for(int i = 9; i < 100; i = i + 9) {
						if(words[i].equals(item.getName())) {
							fileWriter.write(words[i] + words[i+1] + words[i+2] + words[i+3] + words[i+4] + words[i+5] + words[i+6] + words[i+7]);
							words[i+2].equals(String.valueOf(newP));
							found = true;
							
						}
					}
						
					
				}
				fileReader.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(filename.substring(0,1) == "e") {
			try {
				FileWriter fileWriter = new FileWriter("elec_stocks");
				File file = new File(filename);
				FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				String line;
				
				boolean found = false;
				while ((line = bufferedReader.readLine()) != null) {
					words = line.split(" ");
					if(words[0].equals(item.getName())) {
						words[2].equals(String.valueOf(newP));
						fileWriter.write(words[0] + words[1] + words[2] + words[3] + words[4] + words[5] + words[6]);
						found = true;
						
					}
					for(int i = 7; i < 100; i = i + 7) {
						if(words[i].equals(item.getName())) {
							fileWriter.write(words[i] + words[i+1] + words[i+2] + words[i+3] + words[i+4] + words[i+5] + words[i+6]);
							words[i+2].equals(String.valueOf(newP));
							found = true;
							
						}
					}
						
					
				}
				fileReader.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
		

		
	}
	public void removePromotion() {
		newP = item.price + item.discount;
		item.price = newP;
		item.setDiscount(0);
		
		if(filename.substring(0,1) == "b") {

			try {
				FileWriter fileWriter = new FileWriter("book_stocks", true);
				File file = new File(filename);
				FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				String line;
				
				boolean found = false;
				while ((line = bufferedReader.readLine()) != null) {
					words = line.split(" ");
					if(words[0].equals(item.getName())) {
						words[2].equals(String.valueOf(newP));
						fileWriter.write(words[0] + words[1] + words[2] + words[3] + words[4] + words[5] + words[6]);
						found = true;
						
					}
					for(int i = 7; i < 100; i = i + 7) {
						if(words[i].equals(item.getName())) {
							words[i+2].equals(String.valueOf(newP));
							fileWriter.write(words[i] + words[i+1] + words[i+2] + words[i+3] + words[i+4] + words[i+5] + words[i+6]);
							found = true;
							
						}
					}
						
					
				}
				fileReader.close();
				if(found)
					System.out.println("Promotion deleted.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(filename.substring(0,1) == "c") {
	
			try {
				FileWriter fileWriter = new FileWriter("cloth_stocks", true);
				File file = new File(filename);
				FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				String line;
				
				boolean found = false;
				while ((line = bufferedReader.readLine()) != null) {
					words = line.split(" ");
					if(words[0].equals(item.getName())) {
						words[2].equals(String.valueOf(newP));
						fileWriter.write(words[0] + words[1] + words[2] + words[3] + words[4] + words[5] + words[6] + words[7]);
						found = true;
						
					}
					for(int i = 9; i < 100; i = i + 9) {
						if(words[i].equals(item.getName())) {
							words[i+2].equals(String.valueOf(newP));
							fileWriter.write(words[i] + words[i+1] + words[i+2] + words[i+3] + words[i+4] + words[i+5] + words[i+6] + words[i+7]);
							found = true;
							
						}
					}
						
					
				}
				fileReader.close();
				if(found)
					System.out.println("Promotion deleted.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(filename.substring(0,1) == "e") {
			
			try {
				FileWriter fileWriter = new FileWriter("elec_stocks", true);
				File file = new File(filename);
				FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				String line;
				
				boolean found = false;
				while ((line = bufferedReader.readLine()) != null) {
					words = line.split(" ");
					if(words[0].equals(item.getName())) {
						words[2].equals(String.valueOf(newP));
						fileWriter.write(words[0] + words[1] + words[2] + words[3] + words[4] + words[5] + words[6]);
						found = true;
						
					}
					for(int i = 7; i < 100; i = i + 7) {
						if(words[i].equals(item.getName())) {
							words[i+2].equals(String.valueOf(newP));
							fileWriter.write(words[i] + words[i+1] + words[i+2] + words[i+3] + words[i+4] + words[i+5] + words[i+6]);
							found = true;
							
						}
					}
						
					
				}
				fileReader.close();
				if(found)
					System.out.println("Promotion deleted.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}
}

package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ReadClothStock implements ReadStockStrategy {
	
	public ReadClothStock() {
		
	}
	
	@Override
	public ArrayList<Item> readStockFile() {
		ArrayList<Item> items = new ArrayList<Item>();
		
		try {
			Scanner sc = new Scanner(new File("data/Cloth_stocks.txt"));
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				StringTokenizer tok = new StringTokenizer(line);
				items.add(new ClothItem(tok.nextToken(), Integer.parseInt(tok.nextToken()), Double.parseDouble(tok.nextToken()), tok.nextToken(), tok.nextToken(), tok.nextToken(), tok.nextToken(), tok.nextToken(), Integer.parseInt(tok.nextToken())));
				System.out.println(items.get(0));
			}	
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return items;
	}

}

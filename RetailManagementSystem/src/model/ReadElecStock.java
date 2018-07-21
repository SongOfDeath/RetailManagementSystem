package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ReadElecStock implements ReadStockStrategy{
	
	public ReadElecStock() {
		
	}
	
	@Override
	public ArrayList<Item> readStockFile() {
		ArrayList<Item> items = new ArrayList<Item>();
		try {
			
			Scanner sc = new Scanner(new File("data/elec_stocks.txt"));
			while(sc.hasNextLine()) {

				String line = sc.nextLine();
				StringTokenizer tok = new StringTokenizer(line);
				items.add(new ElecItem(tok.nextToken(), Integer.parseInt(tok.nextToken()), Double.parseDouble(tok.nextToken()), tok.nextToken(), tok.nextToken(), Integer.parseInt(tok.nextToken()), Integer.parseInt(tok.nextToken())));
				System.out.println(items.get(0));
			}
			
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return items;
	}

}

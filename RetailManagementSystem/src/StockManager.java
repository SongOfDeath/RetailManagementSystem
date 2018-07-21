import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class StockManager {
		
		public StockManager()
		{
			
		}
		
		public void addData(String dataString)
		{
			try {
				FileWriter writer = new FileWriter("stocks.txt", true);
				BufferedWriter bufferedWriter = new BufferedWriter(writer);

				//bufferedWriter.write("sülo");
				//bufferedWriter.append("asdas");
				bufferedWriter.write("Name: BookName, BookISBN: 432543");
				bufferedWriter.newLine();
				bufferedWriter.write("" + dataString);
				bufferedWriter.newLine();
				bufferedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
		
		public void putDataOnTable(String dataString)
		{
			addData(dataString);
			
			try {
				///READ/////////////////////////
				ArrayList<Integer> allScores = new ArrayList<Integer>();
				ArrayList<String> allBooks = new ArrayList<String>();
				BufferedReader br = new BufferedReader(new FileReader("stocks.txt"));
				String line = br.readLine();
				line = br.readLine();
				allScores.add(Integer.parseInt(line));
				line = br.readLine();
				//System.out.println(line);
				while(line!=null)
				{
					line = br.readLine();
					//System.out.println(line);
					allScores.add(Integer.parseInt(line));
					//int nextScore = Integer.parseInt(line);
					line = br.readLine();
					System.out.println(line);
				}
				
				
				br.close();
				//SORT THE LIST
				Collections.sort(allScores);
				/// CLEAR THE FILE
				PrintWriter pw = new PrintWriter("stocks.txt");
				
				
		/*OLDOLDOLD		
				/// WRITE THE SORTED SCORES TO THE TXT FILE
				for(int i=allScores.size() - 1; i>=0; i--)
				{
					addData(allScores.get(i));
					//System.out.println("ALL SCORES " + allScores.get(i));
				}
				*/
			} catch (IOException e) {
				e.printStackTrace();
			}
		
			
		}
		
		public String getHighScoreContents()
		{
			String s = "";
			try {
				BufferedReader br = new BufferedReader(new FileReader("stocks.txt"));
				String line = br.readLine();
				if(line!=null)
				{
					s = s+line;
					s = s+ "\n";
				}
				while(line!=null)
				{
					line = br.readLine();
					s = s+ "\n";
					s = s+line;
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			return s;
		}
		
		public void givenUsingJava7_whenWritingToFile_thenCorrect() 
				  throws IOException {
				    String str = "Hello";
				 
				    Path path = Paths.get("stocks.txt");
				    byte[] strToBytes = str.getBytes();
				 
				    Files.write(path, strToBytes);
				 
				    String read = Files.readAllLines(path).get(0);
				    //assertEquals(str, read);
				}
		private String scoreFile = "stocks.txt";

}

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


public class ComplaintManager {
	String complaint;
	FileWriter fileWriter;
	//Constructor
	public ComplaintManager(String complaint) {
		this.complaint = complaint;
	}
	public void createComplaint(String comp) {
		try {
			fileWriter = new FileWriter("complaints", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(complaint);
            bufferedWriter.close();
            System.out.println("Complaint saved");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
		
 	}
	public void reviewComplaint() {
		try {
			File file = new File("complaints");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				stringBuffer.append(line);
				stringBuffer.append("\n");
			}
			fileReader.close();
			System.out.println("Complaints of customers are:");
			System.out.println("- " + stringBuffer.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

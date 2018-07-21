package model;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public class BillingManager {
    ArrayList<Bill> bills;
    public BillingManager(String fileName) {
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("");
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        bills = new ArrayList<>();
    }
     public void addBill(Bill bill) {
         try {
             FileWriter fileWriter = new FileWriter(fileName, true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer);
             bufferedWriter.write("");
             bufferedWriter.write("" + bill);
             bufferedWriter.newLine();
             bills.add(bill);
             bufferedWriter.close();
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
	 }
    
    public void removeBill(Bill bill) {
        bills.remove(bill);
    }
    
    public void listBill() {
        
    }
    
    public void paymentAlert() {
        
    }
}  

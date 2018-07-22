package test;
import java.io.File;

import controller.CustomerControl;
import model.Customer;
import model.ReadElecStock;

public class test1 {
	public static void main(String args[]) {
		CustomerControl cntrl = new CustomerControl();
//		cntrl.addCustomer(98, "addr", 73485, "45");
		System.out.println("exit");
		cntrl.addCustomerOrder(98, 88);
		cntrl.printList();
	}

}

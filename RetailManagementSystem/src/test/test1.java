package test;
import java.io.File;

import controller.CustomerControl;
import controller.GeneralManager;
import model.Customer;
import model.ReadElecStock;
import model.SalesManager;

public class test1 {
	public static void main(String args[]) {
		SalesManager sMngr = new SalesManager(new GeneralManager());
		sMngr.printList();
	}

}

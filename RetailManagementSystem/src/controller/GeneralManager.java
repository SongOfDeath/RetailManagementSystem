package controller;
import model.*;
public class GeneralManager {
	public static final int ELECSHOP = 0;
	public static final int BOOKSHOP = 1;
	public static final int CLOTHSHOP = 2;
	public static int shop_mode;
	
	private static AccountManager accmanager;
	private static BillingManager billmanager;
	private static ComplaintManager compManager;
	private static NotificationManager notifManager;
	private static PromotionManager promoManager;
	private static SalesManager saleManager;
	private static ShippingManager shippingManager;

	CustomerControl custControl;
	String salesfile;
	
	public GeneralManager() {
		custControl = new CustomerControl();
		if(GeneralManager.shop_mode == GeneralManager.ELECSHOP) {
			salesfile = "electronicSales.txt";
		}
		else if(GeneralManager.shop_mode == GeneralManager.BOOKSHOP) {
			salesfile = "bookSales.txt";
		}
		else {
			salesfile = "clothSales.txt";
		}
	}
	
	public String getSalesFile() {
		return salesfile;
	}
}

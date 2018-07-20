package controller;
import model.*;
public class GeneralManager {
	public static final int BOOKSHOP = 0;
	public static final int ELECSHOP = 1;
	public static final int CLOTHSHOP = 2;
	private static AccountManager accmanager;
	private static BillingManager billmanager;
	private static ComplaintManager compManager;
	private static NotificationManager notifManager;
	private static PromotionManager promoManager;
	private static SalesManager saleManager;
	private static ShippingManager shippingManager;
	public int shop_mode;
	
	public GeneralManager() {
		
	}
}

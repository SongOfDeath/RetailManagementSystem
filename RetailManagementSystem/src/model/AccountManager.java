package model;

public class AccountManager {
	User []staff;
	User manager;
	int staffNum;
	//Constructor
	public AccountManager() {
		staffNum = 0;
		staff = new User[staffNum];
	}
	//Getter
	public int getStaffNum() {
		return staffNum;
	}
	public User[] getStaff() {
		return staff;
	}
	public User getManager() {
		return manager;
	}
	//Setter
	public void setStaff(User[] staff) {
		this.staff = staff;
	}
	public void setManager(User manager) {
		this.manager = manager;
	}

	public void setStaffNum(int staffNum) {
		this.staffNum = staffNum;
	}
	
}

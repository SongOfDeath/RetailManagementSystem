package model;

import java.util.ArrayList;

public class AccountManager {
	ArrayList<User> staff;
	
	public AccountManager() {
		staff = new ArrayList<User>();
	}
	public void addAccount(String name, int password, boolean manager) {
		User nuser = new User();
		nuser.setName(name);
		nuser.setPassword(password);
		nuser.setManager(manager);
		staff.add(nuser);
	}
	public void removeAccount(String name) {
		for(int i = 0; i < staff.size(); i++) {
			if(staff.get(i).getName().equals(name)) {
				staff.remove(i);
			}else {
				System.out.println("User not found!");
			}
		}
	}
	
	//Getter
	public ArrayList<User> getStaff() {
		return staff;
	}

	//Setter
	public void setStaff(ArrayList<User> staff) {
		this.staff = staff;
	}


	
}

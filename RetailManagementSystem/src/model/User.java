package model;

public class User {
	String name;
	int password;
	boolean manager;
	//Constructor
	public User(){
		name = "";
		password = -1;
		manager = false;
	}
	public User(String name, int password, boolean manager) {
		this.name = name;
		this.password = password;
		this.manager = manager;
	}
	//Getter
	public int getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public boolean getManager() {
		return manager;
	}
	//Setter
	public void setPassword(int password) {
		this.password = password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setManager(boolean manager) {
		this.manager = manager;
	}
}

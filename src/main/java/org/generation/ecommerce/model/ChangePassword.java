package org.generation.ecommerce.model;

public class ChangePassword {

	private String password;
	private String newpassword;
	public ChangePassword(String password, String newpassword) {
		super();
		this.password = password;
		this.newpassword = newpassword;
	}//constructor 
	
	public ChangePassword() {}//constructor default

	public String getPassword() {
		return password;
	}//getPassword

	public void setPassword(String password) {
		this.password = password;
	}//setPassword

	public String getNewpassword() {
		return newpassword;
	}//getNewpassword

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}//setNewpassword

	@Override
	public String toString() {
		return "ChangePassword [password=" + password + ", newpassword=" + newpassword + "]";
	}//toString
	
	
	
}//class ChangePassword

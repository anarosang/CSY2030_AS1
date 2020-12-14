package assignment;

import java.io.Serializable;

public class Department implements Serializable{
	private String name, type, web_address, username, password;
	
	public Department(String name, String type, String web_address, String username, String password){
		this.name = name;
		this.type = type;
		this.web_address = web_address;
		this.username = username;
		this.password = password;
	}
	
	public String getDepartment(){		
		return "Name: " + name + "\nType: " + type + "\nWeb Address: " + web_address + "\nUsername: " + username + "\nPassword: " + password + "\n\n"; 		
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	public String getType(){
		return type;
	}
	
	public String getWebAddress(){
		return web_address;
	}
	
	public String getUsername(){
		return username;
	}
	
	public String getPassword(){
		return password;
	}
}

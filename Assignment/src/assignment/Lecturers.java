package assignment;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Lecturers implements Serializable {
	protected int staff_id;
	protected String lecturerType, name, address, phone, email, start_date, department;
	
	public Lecturers(int staff_id, String lecturerType, String name, String address, String phone, String email, String start_date, String department){
		this.staff_id = staff_id;
		this.lecturerType = lecturerType;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.start_date = start_date;
		this.department = department;
	}
	
	public String getLecturer(){		
		return "ID: " + staff_id + "\nContract type: " + lecturerType + "\nName: " + name + "\nAddress: " + address + "\nPhone: " + phone + "\nEmail: " + email + "\n Start date: " + start_date + "\nDepartment: " + department + "\n"; 		
	}
	
	public void setDepartment(String Department) {
		System.out.println("Department set to " + Department);
		department = Department;
	}

	public int getID() {
		return staff_id;
	}
	
	public String getLecturerType(){
		return lecturerType;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getStartDate() {
		return start_date;
	}
	
	public String getDepartment() {
		return department;
	}
		
}

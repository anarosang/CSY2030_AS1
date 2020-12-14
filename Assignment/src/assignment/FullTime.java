package assignment;

import java.io.*;

public class FullTime extends Lecturers implements Serializable{
	private double salary;
	
	public FullTime(int staff_id, String lecturerType, String name, String address, String phone, String email, String start_date, String department, double salary){
		super(staff_id, lecturerType, name, address, phone, email, start_date, department);
		this.salary = salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

}

package assignment;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

public class Contract extends Lecturers implements Serializable{
	private double salary;
	private String finish_date;
	
	public Contract(int staff_id, String lecturerType, String name, String address, String phone, String email, String start_date, String department, double salary, String finish_date){
		super(staff_id, lecturerType, name, address, phone, email, start_date, department);
		this.salary = salary;
		this.finish_date = finish_date;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}
	
	public void setFinishDate(String finish_date) {
		this.finish_date = finish_date;
	}

	public String getFinishDate() {
		return finish_date;
	}

}

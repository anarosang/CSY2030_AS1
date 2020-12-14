package assignment;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

public class PartTime extends Lecturers implements Serializable{
	private double hourly_rate;
	
	public PartTime(int staff_id, String lecturerType, String name, String address, String phone, String email, String start_date, String department, double hourly_rate){
		super(staff_id, lecturerType, name, address, phone, email, start_date, department);
		this.hourly_rate = hourly_rate;
	}
	
	public void setHourlyRate(double hourly_rate) {
		this.hourly_rate = hourly_rate;
	}
	
	public double getHourlyRate() {
		return hourly_rate;
	}
}

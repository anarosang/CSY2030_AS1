package controllers;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;

import assignment.Contract;
import assignment.Department;
import assignment.FullTime;
import assignment.Lecturers;
import assignment.PartTime;
import models.Model;
import views.View;

public class Controller implements ActionListener, WindowListener {
	private View view;
	private Model model;
	
	public Controller(Model model){
		System.out.println("Instance of Controller created.");
		this.model = model;
	}
	
	public void addView(View view){
		System.out.println("View set in Controller.");
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand() == "Login"){
			login();
		}
		else
			if(e.getActionCommand() == "jBSearch"){
				search();
			}
		else
		if(e.getActionCommand() == "displayDepartment"){
			view.setCardLayout("File Display");
			String toDisplay = "";
			for(int i=0; i < model.getDepartments().size(); i++){
				toDisplay += model.getDepartments().get(i).getDepartment();
			}
			view.setjTFileDisplay(toDisplay);
		}
		else
		if(e.getActionCommand() == "addDepartment"){
			view.setCardLayout("Add Department");
		}
		else
		if(e.getActionCommand() == "jBAddDepartment"){
			String name = view.getjTName();
			String type = view.getjTType();
			String web_address = view.getjTWeb();
			String username = view.getjTUsername();
			String password = view.getjTPassword();
			
			Department dep = new Department(name, type, web_address, username, password);
			
			model.addObject(dep, model.getDepartments());
			view.refreshAddDepartment();
		}
		else
		if(e.getActionCommand() == "editDepartment"){
			departmentsEditJComboBox();
			view.setCardLayout("Edit Department");
		}
		else
		if(e.getActionCommand() == "toEditDepartment"){
			String tofind = (String) view.getjCBEditDepartment().getSelectedItem();
			Department department = model.findObject(tofind, model.getDepartments());
			view.editDepartment(department.getName(), department.getType(), department.getWebAddress(), department.getUsername(), department.getPassword());
		}
		else
		if(e.getActionCommand() == "jBEditDepartment"){
			String name = view.getjTName2();
			String type = view.getjTType2();
			String web_address = view.getjTWeb2();
			String username = view.getjTUsername2();
			String password = view.getjTPassword2();
			
			Department dep = new Department(name, type, web_address, username, password);
			
			String department = (String) view.getjCBEditDepartment().getSelectedItem();
			for(int i = 0; i < model.getDepartments().size(); i++){
				if(model.getDepartments().get(i).getName().equals(department)){
					this.model.editObject(i, dep, model.getDepartments());
				}
			}
			view.refreshEditDepartment();
		}
		else
			if(e.getActionCommand() == "jBRemoveDepartment"){
				String toRemove = (String) view.getjCBEditDepartment().getSelectedItem();
				Department department = model.findObject(toRemove, model.getDepartments());
				this.model.removeObject(department, model.getDepartments());
			}
		else
		if(e.getActionCommand() == "displayLecturer"){
			view.setCardLayout("File Display");
			String toDisplay = "";
			
			if(model.getSecretaryLogin() == true){
				String currentDepartment = model.getUser().getName();
				
				for(int i=0; i < model.getLecturers().size(); i++){
					if(model.getLecturers().get(i).getDepartment().equals(currentDepartment)){
						Lecturers l = model.getLecturers().get(i);
						if(l instanceof PartTime){
							toDisplay += model.getLecturers().get(i).getLecturer() + "Hourly rate: " + ((PartTime) model.getLecturers().get(i)).getHourlyRate() + "\n\n";
						}
						else if (l instanceof FullTime){
							toDisplay += model.getLecturers().get(i).getLecturer() + "Salary: " + ((FullTime) model.getLecturers().get(i)).getSalary() + "\n\n";
						}
						else if (l instanceof Contract){
							toDisplay += model.getLecturers().get(i).getLecturer() + "Salary: " + ((Contract) model.getLecturers().get(i)).getSalary() + "\nFinish date: " + ((Contract) model.getLecturers().get(i)).getFinishDate() + "\n\n";
						}
					}
					
				}
			}
			else {
				for(int i=0; i < model.getLecturers().size(); i++){
					Lecturers l = model.getLecturers().get(i);
					if(l instanceof PartTime){
						toDisplay += model.getLecturers().get(i).getLecturer() + "Hourly rate: " + ((PartTime) model.getLecturers().get(i)).getHourlyRate() + "\n\n";
					}
					else if (l instanceof FullTime){
						toDisplay += model.getLecturers().get(i).getLecturer() + "Salary: " + ((FullTime) model.getLecturers().get(i)).getSalary() + "\n\n";
					}
					else if (l instanceof Contract){
						toDisplay += model.getLecturers().get(i).getLecturer() + "Salary: " + ((Contract) model.getLecturers().get(i)).getSalary() + "\nFinish date: " + ((Contract) model.getLecturers().get(i)).getFinishDate() + "\n\n";
					}
				}
			}
			view.setjTFileDisplay(toDisplay);
		}
		else
		if(e.getActionCommand() == "addLecturer"){
			view.setCardLayout("Add Lecturer");
			departmentsJComboBox();
		}
		else
		if(e.getActionCommand() == "Submit Lecturer"){
			int staff_id = view.getjTId();
			String name = view.getjTLecturerName();
			String address = view.getjTAddress();
			String phone = view.getjTPhone();
			String email = view.getjTEmail();
			String start_date = view.getjTStartDate();
			String department = (String) view.getjCBDepartment().getSelectedItem();
			
			String type = view.getLecturerType();
			if(type == "Part-Time"){
				double hourly_rate = view.getjTSalary();
				PartTime partT = new PartTime(staff_id, type, name, address, phone, email, start_date, department, hourly_rate);
				this.model.addObject(partT, this.model.getLecturers());
			}
			else if(type == "Full-Time"){
				double salary = view.getjTSalary();
				FullTime fullT = new FullTime(staff_id, type, name, address, phone, email, start_date, department, salary);
				this.model.addObject(fullT, this.model.getLecturers());				
			}
			else if(type == "Contract"){
				double salary = view.getjTSalary();
				String finish_date = view.getjTEndDate();
				Contract contract = new Contract(staff_id, type, name, address, phone, email, start_date, department, salary, finish_date);
				this.model.addObject(contract, this.model.getLecturers());
			}
			view.refreshAddLecturer();
		}
		if(e.getActionCommand() == "editLecturer"){
			view.setCardLayout("Edit Lecturer");
			lecturersJComboBox();
			lecturerDepartment();
		}
		else
		if(e.getActionCommand() == "toEditLecturer"){
			String tofind = (String) view.getjCBLectureId().getSelectedItem();
			Lecturers lecturer = model.findObject(tofind, model.getLecturers());
			
			if(lecturer instanceof PartTime){
				view.editLecturer(lecturer.getName(), lecturer.getAddress(), lecturer.getPhone(), lecturer.getEmail(), lecturer.getStartDate(), ((PartTime) lecturer).getHourlyRate(), "", lecturer.getDepartment());
			}
			else if(lecturer instanceof FullTime){
				view.editLecturer(lecturer.getName(), lecturer.getAddress(), lecturer.getPhone(), lecturer.getEmail(), lecturer.getStartDate(), ((FullTime) lecturer).getSalary(), "", lecturer.getDepartment());
			}
			else if(lecturer instanceof Contract){
				view.editLecturer(lecturer.getName(), lecturer.getAddress(), lecturer.getPhone(), lecturer.getEmail(), lecturer.getStartDate(), ((Contract) lecturer).getSalary(), ((Contract) lecturer).getFinishDate(), lecturer.getDepartment());
			}					
		}
		else
		if(e.getActionCommand() == "jBEditLecturer"){
			String name = view.getjTLecturerName2();
			String address = view.getjTAddress2();
			String phone = view.getjTPhone2();
			String email = view.getjTEmail2();
			String start_date = view.getjTStartDate2();
			String department = (String) view.getjCBDepartmentEditL().getSelectedItem();
			
			String lecturer = (String) view.getjCBLectureId().getSelectedItem();
			int staff_id = Integer.parseInt(lecturer);
			for(int i = 0; i < model.getLecturers().size(); i++){
				if(model.getLecturers().get(i).getID() == Integer.parseInt(lecturer)){
					if(model.getLecturers().get(i).getLecturerType().equals("Part-Time")){
						double hourly_rate = view.getjTSalary2();
						PartTime partT = new PartTime(model.getLecturers().get(i).getID(), "Part-Time", name, address, phone, email, start_date, department, hourly_rate);
						this.model.editObject(i, partT, model.getLecturers());
					}
					else if(model.getLecturers().get(i).getLecturerType().equals("Full-Time")){
						double salary = view.getjTSalary2();
						FullTime fullT = new FullTime(model.getLecturers().get(i).getID(), "Full-Time", name, address, phone, email, start_date, department, salary);
						this.model.editObject(i, fullT, model.getLecturers());
					}
					else if(model.getLecturers().get(i).getLecturerType().equals("Contract")){
						double salary = view.getjTSalary2();
						String finish_date = view.getjTEndDate2();
						Contract contract = new Contract(model.getLecturers().get(i).getID(), "Contract", name, address, phone, email, start_date, department, salary, finish_date);
						this.model.editObject(i, contract, model.getLecturers());
					}
				}
			}
		}
		else
		if(e.getActionCommand() == "jBRemoveLecturer"){
			String toRemove = (String) view.getjCBLectureId().getSelectedItem();
			Lecturers lecturer = model.findObject(toRemove, model.getLecturers());
			this.model.removeObject(lecturer, model.getLecturers());
		}
		else
		if(e.getActionCommand() == "Exit"){
			model.writeObjects("Departments.dat", model.getDepartments());
			model.writeObjects("Lecturers.dat", model.getLecturers());
			System.out.println("logout");
			System.exit(0);
		}
		
	}
	
	public void departmentsJComboBox(){
		view.getjCBDepartment().removeAllItems();
		for(int i = 0; i < model.getDepartments().size(); i++){
			view.getjCBDepartment().addItem(model.getDepartments().get(i).getName());
		}
	}
	
	public void departmentsEditJComboBox(){
		//view.getjCBEditDepartment().removeAllItems();
		for(int i = 0; i < model.getDepartments().size(); i++){
			view.getjCBEditDepartment().addItem(model.getDepartments().get(i).getName());
		}
	}
	
	public void lecturersJComboBox(){
		//view.getjCBLectureId().removeAllItems();
		for(int i = 0; i < model.getLecturers().size(); i++){
			view.getjCBLectureId().addItem(String.valueOf(model.getLecturers().get(i).getID()));
		}
	}
	
	public void lecturerDepartment(){
		view.getjCBDepartmentEditL().removeAllItems();
		for(int i = 0; i < model.getDepartments().size(); i++){
			view.getjCBDepartmentEditL().addItem(String.valueOf(model.getDepartments().get(i).getName()));
		}
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Window Closed.");
		model.writeObjects("Departments.dat", model.getDepartments());
		model.writeObjects("Lecturers.dat", model.getLecturers());
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Window Opened.");
		model.readObjects("Departments.dat", model.getDepartments());
		model.readObjects("Lecturers.dat", model.getLecturers());
	}
	
	public void login() {
		boolean validLogin = model.validateLogin(view.getjTUser(), view.getjTUserPassword());
		if (validLogin) {
			if (!model.getSecretaryLogin()) {
				view.setjMenuBarStaff(this);
				view.openFrame();
			}
			else {
				view.setjMenuBarSecretaries(this);
				view.openFrame();
			}
		}
		else {
			System.out.println("Error: Invalid Login.");
		}
	}
	
	public void search(){
		Object jTFileDisplay = view.getjTFileDisplay();
		((JTextComponent) jTFileDisplay).getHighlighter().removeAllHighlights();
		
		String find = view.getjTFSearch().getText();
        Document document = ((JTextComponent) jTFileDisplay).getDocument();
        try {
            for (int index = 0; index + find.length() < document.getLength(); index++) {
                String match = document.getText(index, find.length());
                if (find.equalsIgnoreCase(match)) {
                    javax.swing.text.DefaultHighlighter.DefaultHighlightPainter highlightPainter = new javax.swing.text.DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);
                    ((JTextComponent) jTFileDisplay).getHighlighter().addHighlight(index, index + find.length(), highlightPainter);
                }
            }
        } catch (BadLocationException exp) {
            exp.printStackTrace();
        }
	}
}

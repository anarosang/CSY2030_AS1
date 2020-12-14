package models;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import assignment.Department;
import assignment.Lecturers;

public class Model {
	//add remove view find get department
	protected ArrayList<Department> departments = new ArrayList<Department>();
	protected ArrayList<Lecturers> lecturers = new ArrayList<Lecturers>();
	
	protected Department department = null;
	protected boolean secretaryLogin = false;
	
	public <T> void writeObjects(String filename, ArrayList<T> arrayList) {
		System.out.println("Writing Objects to " + filename + ".");
			ObjectOutputStream objectOutputStream;
			try {
				objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename));
				
				for (int i = 0; i < arrayList.size(); i++) {
					System.out.println("Object " + arrayList.get(i) + " written to file.");
					objectOutputStream.writeObject(arrayList.get(i));
				}

				objectOutputStream.close();
				System.out.println("Finished writing objects to " + filename + ".");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public <T> void readObjects(String filename,  ArrayList<T> arrayList) {
		System.out.println("Reading Objects from " + filename + ".");
		try {
			ObjectInputStream outputInputStream = new ObjectInputStream(new FileInputStream(filename));
			T object = null;

			while ((object=(T)outputInputStream.readObject())!=null) {
				arrayList.add(object);
			}

			outputInputStream.close();
		}

		catch (EOFException ex) { //This exception will be caught when EOF is reached
			System.out.println("End of file reached.");
			for(int i = 0; i < arrayList.size(); i++)
				System.out.println("Object from file stored in position " + i + " in ArrayList: " + arrayList.get(i));
		} 

		catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} 

		catch (FileNotFoundException ex) {
			System.out.println("File Not Found.");
			writeObjects(filename, arrayList);
			readObjects(filename, arrayList);
		} 

		catch (IOException ex) {
			ex.printStackTrace();
		}

	}
	
	public <T> void addObject(T object, ArrayList<T> arrayList) {
		System.out.println("Adding Object.");
		arrayList.add(object);
		System.out.println("Added " + object + " to arrayList postion " + arrayList.indexOf(object));
	}
	
	public <T> void editObject(int index, T object, ArrayList<T> arrayList) {
		System.out.println("Edit Object.");
		arrayList.set(index, object);
		System.out.println("Edited " + object + " on arrayList postion " + arrayList.indexOf(object));
	}

	public <T> void removeObject(T object, ArrayList<T> arrayList) {
		System.out.println("Removing Object.");
		arrayList.remove(object);
		System.out.println("Removed " + object + " from arrayList " + arrayList.getClass().getName());
	}

	public <T> T findObject(String identifier, ArrayList<T> arrayList) {
		System.out.println("Finding Object.");
		for (T t : arrayList) {
			if (t instanceof Department) {
				if (identifier.equals(((Department)t).getName())) {
					System.out.println("Returning Department Object.");
					return t;
				}
			}
			else if (t instanceof Lecturers) {
				int id = Integer.parseInt(identifier);
				if (id == ((Lecturers) t).getID()) {
					System.out.println("Returning Lecturer Object.");
					return t;
				}
			}
		}
		return null;
	}

	public ArrayList<Department> getDepartments() {
		System.out.println("Returning department ArrayList.");
		return departments;
	}

	public ArrayList<Lecturers> getLecturers() {
		System.out.println("Returning lecturers ArrayList.");
		return lecturers;
	}
	
	public boolean getSecretaryLogin() {
		return secretaryLogin;
	}

	public Department getUser() {
		System.out.println("Get current department");
		return department;
	}
	
	public boolean validateLogin(String username, String password) {
		System.out.println("Validating Login." + username);
		if (username.equals("staff") && password.equals("staff")) {
			System.out.println("Login valid.");
			return true;
		}
		else {
			for (int i = 0; i < departments.size(); i++) {
				if(departments.get(i).getUsername().equals(username) && departments.get(i).getPassword().equals(password)){
					System.out.println("Login valid.");
					System.out.println("validUser stored.");
					department = departments.get(i);
					secretaryLogin = true;
					return true;
				}
			}
		}
		System.out.println("Login invalid.");
		return false;
	}

}

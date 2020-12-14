package views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controllers.Controller;
import models.Model;

public class View extends JFrame{
	private Model model;
	private static CardLayout cardLayout;
	private static JPanel cardPanel, jPHome;
	private static JFrame frame;
	
	//Login panel
		private JPanel jPLogin;
		private JTextField jTUser;
		private JPasswordField jTUserPassword;
		
	
	//Menu
	private static JMenuBar menuBar;
	private static JMenuItem jMIExit, jMIViewD, jMIAddD, jMIEditD, jMIEditL, jMIAddL, jMIViewL;
	
	//Display file panels
		private static JPanel jPDisplay, jPMain, jPSearch, jPLines;
		private static JTextArea jTFileDisplay;
		private static JScrollPane scrollPane;
		private static JTextField jTFSearch;
		private static JButton jBSearch;
		
		//Add Department panel
		private static JPanel jPAddDepartment;
		private static JTextField jTName, jTType, jTWeb, jTUsername, jTPassword;
		private static JButton jBAddDepartment;
		
		//Edit Department panel
				private static JPanel jPEditDepartment;
				private JComboBox jCBEditDepartment;
				private static JTextField jTName2, jTType2, jTWeb2, jTUsername2, jTPassword2;
				private static JButton jBEditDepartment, jBRemoveDepartment;
		
		//Add Lecturers panel
		private static JPanel jPAddLecture,jPElements, jPContract;
		private static JTextField jTId, jTLecturerName, jTAddress, jTPhone, jTEmail, jTStartDate, jTSalary, jTEndDate;
		private static JRadioButton jRBPartTime, jRBFullTime, jRBContract;
		private static JComboBox jCBDepartment;
		private static JLabel jLSalary, jLEndDate;
		private static JButton jBAddLecturer;
		private static String lecturerType;
		
		//Edit Lecturer panel
		private static JPanel jPEditLecture;
		private static JTextField jTLecturerName2, jTAddress2, jTPhone2, jTEmail2, jTStartDate2, jTSalary2, jTEndDate2;
		private static JComboBox jCBLectureId, jCBDepartmentEditL;
		private static JButton jBEditLecturer, jBRemoveLecturer;
		
	public void openFrame(){
		frame.setJMenuBar(this.getjMenuBar());
		frame.setSize(900, 700);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		this.setVisible(false);
	}
		
	public View(Model model, Controller controller){
		this.model = model;
		
		addWindowListener(controller);
		controller.addView(this);
		
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 371, 245);
		setResizable(false);
		setLocationRelativeTo(null);
		
		jPLogin = new JPanel();
	    jPLogin.setBorder(new EmptyBorder(5, 5, 5, 5));
	    setContentPane(jPLogin);
	    jPLogin.setLayout(null);
	    
	    JLabel jLUser = new JLabel("Username");
		jLUser.setBounds(65, 23, 73, 72);
		jPLogin.add(jLUser);
		
		JLabel jLUserPassword = new JLabel("Password");
		jLUserPassword.setBounds(65, 84, 73, 72);
		jPLogin.add(jLUserPassword);
		
		jTUser = new JTextField();
		jTUser.setBounds(148, 49, 136, 20);
		jPLogin.add(jTUser);
		jTUser.setColumns(10);
		
		jTUserPassword = new JPasswordField();
		jTUserPassword.setColumns(10);
		jTUserPassword.setBounds(148, 110, 136, 20);
		jPLogin.add(jTUserPassword);
		
		JButton jBLogin = new JButton("Login");
		jBLogin.setBounds(239, 150, 89, 23);
		jPLogin.add(jBLogin);
		jBLogin.setActionCommand("Login");
		jBLogin.addActionListener(controller);
		
		setVisible(true);
		
		//Frame
		frame = new JFrame();
		frame.setTitle("Northampton Metropolitan University HR");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		// frame.addWindowListener(controller);
		// frame.setJMenuBar(this.getjMenuBar());

		cardLayout = new CardLayout();
		cardPanel = new JPanel(cardLayout);

		// Display File Panel
		jPDisplay = new JPanel();
		jPDisplay.setBorder(new EmptyBorder(5, 5, 5, 5));
		jPDisplay.setLayout(new BorderLayout(0, 0));

		jPSearch = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		jPDisplay.add(jPSearch, BorderLayout.NORTH);

		jTFSearch = new JTextField();
		jPSearch.add(jTFSearch);
		jTFSearch.setColumns(10);

		jBSearch = new JButton("Search");
		jBSearch.setActionCommand("jBSearch");
		jBSearch.addActionListener(controller);
		jPSearch.add(jBSearch);

		jPMain = new JPanel();
		jPDisplay.add(jPMain, BorderLayout.CENTER);
		jPMain.setLayout(new GridLayout(0, 1, 0, 0));

		scrollPane = new JScrollPane();
		jPMain.add(scrollPane);

		jTFileDisplay = new JTextArea();
		jTFileDisplay.setEditable(false);
		scrollPane.setViewportView(jTFileDisplay);

		jPLines = new JPanel();
		scrollPane.setRowHeaderView(jPLines);
		jPLines.setLayout(new BoxLayout(jPLines, BoxLayout.Y_AXIS));

		// Add Department Panel
		jPAddDepartment = new JPanel();
		jPAddDepartment.setBorder(new EmptyBorder(5, 5, 5, 5));
		jPAddDepartment.setLayout(new GridLayout(0, 2, 0, 5));

		JLabel jLName = new JLabel("Name :");
		jLName.setHorizontalAlignment(SwingConstants.CENTER);
		jLName.setFont(new Font("Tahoma", Font.BOLD, 12));
		jPAddDepartment.add(jLName);
		jTName = new JTextField();
		jPAddDepartment.add(jTName);

		JLabel jLType = new JLabel("Type :");
		jLType.setHorizontalAlignment(SwingConstants.CENTER);
		jLType.setFont(new Font("Tahoma", Font.BOLD, 12));
		jPAddDepartment.add(jLType);
		jTType = new JTextField();
		jPAddDepartment.add(jTType);

		JLabel jLWeb = new JLabel("Web Address :");
		jLWeb.setHorizontalAlignment(SwingConstants.CENTER);
		jLWeb.setFont(new Font("Tahoma", Font.BOLD, 12));
		jPAddDepartment.add(jLWeb);
		jTWeb = new JTextField();
		jPAddDepartment.add(jTWeb);

		JLabel jLUsername = new JLabel("Username :");
		jLUsername.setHorizontalAlignment(SwingConstants.CENTER);
		jLUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		jPAddDepartment.add(jLUsername);
		jTUsername = new JTextField();
		jPAddDepartment.add(jTUsername);

		JLabel jLPassword = new JLabel("Password :");
		jLPassword.setHorizontalAlignment(SwingConstants.CENTER);
		jLPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		jPAddDepartment.add(jLPassword);
		jTPassword = new JTextField();
		jPAddDepartment.add(jTPassword);

		jBAddDepartment = new JButton("Add");
		jBAddDepartment.setActionCommand("jBAddDepartment");
		jBAddDepartment.addActionListener(controller);
		jPAddDepartment.add(jBAddDepartment);

		// Add Lecturers Panel
		jPAddLecture = new JPanel();
		jPAddLecture.setBorder(new EmptyBorder(5, 5, 5, 5));
		jPAddLecture.setLayout(new BorderLayout(0, 0));

		jPElements = new JPanel();
		jPAddLecture.add(jPElements, BorderLayout.CENTER);
		jPElements.setLayout(new GridLayout(0, 2, 0, 5));
		JLabel jLId = new JLabel("Staff ID :");
		jLId.setHorizontalAlignment(SwingConstants.CENTER);
		jLId.setFont(new Font("Tahoma", Font.BOLD, 12));
		jPElements.add(jLId);
		jTId = new JTextField();
		jPElements.add(jTId);

		JLabel jLecturerName = new JLabel("Name :");
		jLecturerName.setHorizontalAlignment(SwingConstants.CENTER);
		jLecturerName.setFont(new Font("Tahoma", Font.BOLD, 12));
		jPElements.add(jLecturerName);
		jTLecturerName = new JTextField();
		jPElements.add(jTLecturerName);

		JLabel jLAddress = new JLabel("Address :");
		jLAddress.setHorizontalAlignment(SwingConstants.CENTER);
		jLAddress.setFont(new Font("Tahoma", Font.BOLD, 12));
		jPElements.add(jLAddress);
		jTAddress = new JTextField();
		jPElements.add(jTAddress);

		JLabel jLPhone = new JLabel("Phone Number :");
		jLPhone.setHorizontalAlignment(SwingConstants.CENTER);
		jLPhone.setFont(new Font("Tahoma", Font.BOLD, 12));
		jPElements.add(jLPhone);
		jTPhone = new JTextField();
		jPElements.add(jTPhone);

		JLabel jLEmail = new JLabel("Email :");
		jLEmail.setHorizontalAlignment(SwingConstants.CENTER);
		jLEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		jPElements.add(jLEmail);
		jTEmail = new JTextField();
		jPElements.add(jTEmail);

		JLabel jLStartDate = new JLabel("Start Date :");
		jLStartDate.setHorizontalAlignment(SwingConstants.CENTER);
		jLStartDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		jPElements.add(jLStartDate);
		jTStartDate = new JTextField();
		jPElements.add(jTStartDate);

		JLabel jLDepartment = new JLabel("Department :");
		jLDepartment.setHorizontalAlignment(SwingConstants.CENTER);
		jLDepartment.setFont(new Font("Tahoma", Font.BOLD, 12));
		jPElements.add(jLDepartment);
		jCBDepartment = new JComboBox();
		jPElements.add(jCBDepartment);

		JLabel jLSalary = new JLabel("Salary :");
		jLSalary.setHorizontalAlignment(SwingConstants.CENTER);
		jLSalary.setFont(new Font("Tahoma", Font.BOLD, 12));
		jPElements.add(jLSalary);
		jTSalary = new JTextField();
		jPElements.add(jTSalary);
		jLSalary.setVisible(false);
		jTSalary.setVisible(false);

		JLabel jLEndDate = new JLabel("End Date :");
		jLEndDate.setHorizontalAlignment(SwingConstants.CENTER);
		jLEndDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		jPElements.add(jLEndDate);
		jTEndDate = new JTextField();
		jPElements.add(jTEndDate);
		jLEndDate.setVisible(false);
		jTEndDate.setVisible(false);

		jBAddLecturer = new JButton("Add");
		jBAddLecturer.setActionCommand("Submit Lecturer");
		jBAddLecturer.addActionListener(controller);
		jPElements.add(jBAddLecturer);

		jPContract = new JPanel();
		jPAddLecture.add(jPContract, BorderLayout.NORTH);

		jRBPartTime = new JRadioButton("Part-Time");
		jRBPartTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setLecturerType("Part-Time");
				jRBFullTime.setSelected(false);
				jRBContract.setSelected(false);

				jLSalary.setText("Hourly rate :");
				jLSalary.setVisible(true);
				jTSalary.setVisible(true);
				jLEndDate.setVisible(false);
				jTEndDate.setVisible(false);
			}
		});
		jPContract.add(jRBPartTime);

		jRBFullTime = new JRadioButton("Full-Time");
		jRBFullTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setLecturerType("Full-Time");
				jRBPartTime.setSelected(false);
				jRBContract.setSelected(false);

				jLSalary.setText("Salary :");
				jLSalary.setVisible(true);
				jTSalary.setVisible(true);
				jLEndDate.setVisible(false);
				jTEndDate.setVisible(false);
			}
		});
		jPContract.add(jRBFullTime);

		jRBContract = new JRadioButton("Contract");
		jRBContract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setLecturerType("Contract");
				jRBFullTime.setSelected(false);
				jRBPartTime.setSelected(false);

				jLSalary.setText("Salary :");
				jLSalary.setVisible(true);
				jTSalary.setVisible(true);
				jLEndDate.setVisible(true);
				jTEndDate.setVisible(true);
			}
		});
		jPContract.add(jRBContract);

		// Edit Lecture
		jPEditLecture = new JPanel();
		jPEditLecture.setBorder(new EmptyBorder(5, 5, 5, 5));
		jPEditLecture.setLayout(new GridLayout(0, 2, 0, 5));

		JLabel jLectureId = new JLabel("Staff ID :");
		jLectureId.setHorizontalAlignment(SwingConstants.CENTER);
		jLectureId.setFont(new Font("Tahoma", Font.BOLD, 12));
		jPEditLecture.add(jLectureId);
		jCBLectureId = new JComboBox();
		jCBLectureId.setActionCommand("toEditLecturer");
		jCBLectureId.addActionListener(controller);
		jPEditLecture.add(jCBLectureId);

		JLabel jLecturerName2 = new JLabel("Name :");
		jLecturerName2.setHorizontalAlignment(SwingConstants.CENTER);
		jLecturerName2.setFont(new Font("Tahoma", Font.BOLD, 12));
		jPEditLecture.add(jLecturerName2);
		jTLecturerName2 = new JTextField();
		jPEditLecture.add(jTLecturerName2);

		JLabel jLAddress2 = new JLabel("Address :");
		jLAddress2.setHorizontalAlignment(SwingConstants.CENTER);
		jLAddress2.setFont(new Font("Tahoma", Font.BOLD, 12));
		jPEditLecture.add(jLAddress2);
		jTAddress2 = new JTextField();
		jPEditLecture.add(jTAddress2);

		JLabel jLPhone2 = new JLabel("Phone Number :");
		jLPhone2.setHorizontalAlignment(SwingConstants.CENTER);
		jLPhone2.setFont(new Font("Tahoma", Font.BOLD, 12));
		jPEditLecture.add(jLPhone2);
		jTPhone2 = new JTextField();
		jPEditLecture.add(jTPhone2);

		JLabel jLEmail2 = new JLabel("Email :");
		jLEmail2.setHorizontalAlignment(SwingConstants.CENTER);
		jLEmail2.setFont(new Font("Tahoma", Font.BOLD, 12));
		jPEditLecture.add(jLEmail2);
		jTEmail2 = new JTextField();
		jPEditLecture.add(jTEmail2);

		JLabel jLStartDate2 = new JLabel("Start Date :");
		jLStartDate2.setHorizontalAlignment(SwingConstants.CENTER);
		jLStartDate2.setFont(new Font("Tahoma", Font.BOLD, 12));
		jPEditLecture.add(jLStartDate2);
		jTStartDate2 = new JTextField();
		jPEditLecture.add(jTStartDate2);

		JLabel jLDepartmentL = new JLabel("Department :");
		jLDepartmentL.setHorizontalAlignment(SwingConstants.CENTER);
		jLDepartmentL.setFont(new Font("Tahoma", Font.BOLD, 12));
		jPEditLecture.add(jLDepartmentL);
		jCBDepartmentEditL = new JComboBox();
		jPEditLecture.add(jCBDepartmentEditL);

		JLabel jLSalary2 = new JLabel("Hourly rate/Salary :");
		jLSalary2.setHorizontalAlignment(SwingConstants.CENTER);
		jLSalary2.setFont(new Font("Tahoma", Font.BOLD, 12));
		jPEditLecture.add(jLSalary2);
		jTSalary2 = new JTextField();
		jPEditLecture.add(jTSalary2);

		JLabel jLEndDate2 = new JLabel("End Date :");
		jLEndDate2.setHorizontalAlignment(SwingConstants.CENTER);
		jLEndDate2.setFont(new Font("Tahoma", Font.BOLD, 12));
		jPEditLecture.add(jLEndDate2);
		jTEndDate2 = new JTextField();
		jPEditLecture.add(jTEndDate2);

		jBEditLecturer = new JButton("Edit");
		jBEditLecturer.setActionCommand("jBEditLecturer");
		jBEditLecturer.addActionListener(controller);
		jPEditLecture.add(jBEditLecturer);

		jBRemoveLecturer = new JButton("Delete");
		jBRemoveLecturer.setActionCommand("jBRemoveLecturer");
		jBRemoveLecturer.addActionListener(controller);
		jPEditLecture.add(jBRemoveLecturer);

		// Edit Department
		jPEditDepartment = new JPanel();
		jPEditDepartment.setBorder(new EmptyBorder(5, 5, 5, 5));
		jPEditDepartment.setLayout(new GridLayout(0, 2, 0, 5));

		JLabel jLDepartment2 = new JLabel("Department :");
		jLDepartment2.setHorizontalAlignment(SwingConstants.CENTER);
		jLDepartment2.setFont(new Font("Tahoma", Font.BOLD, 12));
		jPEditDepartment.add(jLDepartment2);
		jCBEditDepartment = new JComboBox();
		jCBEditDepartment.setActionCommand("toEditDepartment");
		jCBEditDepartment.addActionListener(controller);
		jPEditDepartment.add(jCBEditDepartment);

		JLabel jLName2 = new JLabel("Name :");
		jLName2.setHorizontalAlignment(SwingConstants.CENTER);
		jLName2.setFont(new Font("Tahoma", Font.BOLD, 12));
		jPEditDepartment.add(jLName2);
		jTName2 = new JTextField();
		jPEditDepartment.add(jTName2);

		JLabel jLType2 = new JLabel("Type :");
		jLType2.setHorizontalAlignment(SwingConstants.CENTER);
		jLType2.setFont(new Font("Tahoma", Font.BOLD, 12));
		jPEditDepartment.add(jLType2);
		jTType2 = new JTextField();
		jPEditDepartment.add(jTType2);

		JLabel jLWeb2 = new JLabel("Web Address :");
		jLWeb2.setHorizontalAlignment(SwingConstants.CENTER);
		jLWeb2.setFont(new Font("Tahoma", Font.BOLD, 12));
		jPEditDepartment.add(jLWeb2);
		jTWeb2 = new JTextField();
		jPEditDepartment.add(jTWeb2);

		JLabel jLUsername2 = new JLabel("Username :");
		jLUsername2.setHorizontalAlignment(SwingConstants.CENTER);
		jLUsername2.setFont(new Font("Tahoma", Font.BOLD, 12));
		jPEditDepartment.add(jLUsername2);
		jTUsername2 = new JTextField();
		jPEditDepartment.add(jTUsername2);

		JLabel jLPassword2 = new JLabel("Password :");
		jLPassword2.setHorizontalAlignment(SwingConstants.CENTER);
		jLPassword2.setFont(new Font("Tahoma", Font.BOLD, 12));
		jPEditDepartment.add(jLPassword2);
		jTPassword2 = new JTextField();
		jPEditDepartment.add(jTPassword2);

		jBEditDepartment = new JButton("Edit");
		jBEditDepartment.setActionCommand("jBEditDepartment");
		jBEditDepartment.addActionListener(controller);
		jPEditDepartment.add(jBEditDepartment);

		jBRemoveDepartment = new JButton("Delete");
		jBRemoveDepartment.setActionCommand("jBRemoveDepartment");
		jBRemoveDepartment.addActionListener(controller);
		jPEditDepartment.add(jBRemoveDepartment);

		// Home panel
		jPHome = new JPanel();
		jPHome.setBackground(SystemColor.activeCaption);

		JLabel jLWelcome = new JLabel("Welcome");
		jLWelcome.setBounds(10, 41, 336, 152);
		jLWelcome.setFont(new Font("Lucida Calligraphy", Font.BOLD, 65));
		jPHome.setLayout(null);

		JLabel jLWelcome1 = new JLabel("to Metropolitan University");
		jLWelcome1.setBounds(65, 176, 375, 35);
		jLWelcome1.setFont(new Font("Lucida Calligraphy", Font.ITALIC, 25));
		jPHome.add(jLWelcome1);
		jPHome.add(jLWelcome);

		cardPanel.add(jPHome, "Home");
		cardPanel.add(jPDisplay, "File Display");
		cardPanel.add(jPAddDepartment, "Add Department");
		cardPanel.add(jPAddLecture, "Add Lecturer");
		cardPanel.add(jPEditLecture, "Edit Lecturer");
		cardPanel.add(jPEditDepartment, "Edit Department");

		// add card panels to the main window
		frame.getContentPane().add(cardPanel, BorderLayout.CENTER);
		
	}
	
	//Login
	public String getjTUser(){
		return jTUser.getText();
	}
			
	public String getjTUserPassword(){
		return jTUserPassword.getText();
	}
	
	public JMenuBar getjMenuBar(){
		return menuBar;
	}
			
	public void setjMenuBarStaff(Controller controller){
		//Menu
		menuBar = new JMenuBar();
		JMenu jMAccount, jMDepartment, jMLetures;
		
		jMIExit = new JMenuItem("Logout");
		jMIViewD = new JMenuItem("View");
		jMIViewL = new JMenuItem("View");
		jMIAddD = new JMenuItem("Add");
		jMIAddL = new JMenuItem("Add");
		jMIEditD = new JMenuItem("Edit");
		jMIEditL = new JMenuItem("Edit");
		
		jMAccount = new JMenu("Account");
		menuBar.add(jMAccount);
		jMAccount.add(jMIExit);
		jMIExit.setActionCommand("Exit");
		jMIExit.addActionListener(controller);
		
		jMDepartment = new JMenu("Department");
		menuBar.add(jMDepartment);
		jMDepartment.add(jMIViewD);
		jMIViewD.setActionCommand("displayDepartment");
		jMIViewD.addActionListener(controller);
		
		jMDepartment.add(jMIAddD);
		jMIAddD.setActionCommand("addDepartment");
		jMIAddD.addActionListener(controller);
		
		jMDepartment.add(jMIEditD);
		jMIEditD.setActionCommand("editDepartment");
		jMIEditD.addActionListener(controller);
		
		jMLetures = new JMenu("Lecturers");
		menuBar.add(jMLetures);
		jMLetures.add(jMIViewL);
		jMIViewL.setActionCommand("displayLecturer");
		jMIViewL.addActionListener(controller);
		
		jMLetures.add(jMIAddL);
		jMIAddL.setActionCommand("addLecturer");
		jMIAddL.addActionListener(controller);
		
		jMLetures.add(jMIEditL);
		jMIEditL.setActionCommand("editLecturer");
		jMIEditL.addActionListener(controller);
	}
	
	public void setjMenuBarSecretaries(Controller controller){
		//Menu
		menuBar = new JMenuBar();
		JMenu jMAccount, jMLetures;
		
		jMIExit = new JMenuItem("Logout");
		jMIViewL = new JMenuItem("View");
		
		jMAccount = new JMenu("Account");
		menuBar.add(jMAccount);
		jMAccount.add(jMIExit);
		jMIExit.setActionCommand("Exit");
		jMIExit.addActionListener(controller);
		
		jMLetures = new JMenu("Lecturers");
		menuBar.add(jMLetures);
		jMLetures.add(jMIViewL);
		jMIViewL.setActionCommand("displayLecturer");
		jMIViewL.addActionListener(controller);
	}
	
	public void setCardLayout(String jpanelName){
		cardLayout.show(cardPanel, jpanelName);
	}
	
	//Display
	public void setjTFileDisplay(String toDisplay){
		jTFileDisplay.setText(toDisplay);
	}
	
	public JTextArea getjTFileDisplay(){
		return jTFileDisplay;
	}
	
	public JTextField getjTFSearch(){
		return jTFSearch;
	}
	
	//Department
	public String getjTName(){
		return jTName.getText();
	}
	
	public String getjTType(){
		return jTType.getText();
	}
	
	public String getjTWeb(){
		return jTWeb.getText();
	}
	
	public String getjTUsername(){
		return jTUsername.getText();
	}
	
	public String getjTPassword(){
		return jTPassword.getText();
	}
	
	public void refreshAddDepartment(){
		jTName.setText("");
		jTType.setText("");
		jTWeb.setText("");
		jTUsername.setText("");
		jTPassword.setText("");
	}
	
	//edit
	public String getjTName2(){
		return jTName2.getText();
	}
	
	public String getjTType2(){
		return jTType2.getText();
	}
	
	public String getjTWeb2(){
		return jTWeb2.getText();
	}
	
	public String getjTUsername2(){
		return jTUsername2.getText();
	}
	
	public String getjTPassword2(){
		return jTPassword2.getText();
	}
	
	public void editDepartment(String name, String type, String web, String username, String password){
		jTName2.setText(name);
		jTType2.setText(type);
		jTWeb2.setText(web);
		jTUsername2.setText(username);
		jTPassword2.setText(password);
	}
	
	public void refreshEditDepartment(){
		jTName2.setText("");
		jTType2.setText("");
		jTWeb2.setText("");
		jTUsername2.setText("");
		jTPassword2.setText("");
	}
	
	//Lecturers
	public void setLecturerType(String lecturerType){
		this.lecturerType = lecturerType;
	}
	
	public String getLecturerType(){
		return lecturerType;
	}
	
	public int getjTId(){
		return  Integer.parseInt(jTId.getText());
	}
	
	public String getjTLecturerName(){
		return jTLecturerName.getText();
	}
	
	public String getjTAddress(){
		return jTAddress.getText();
	}
	
	public String getjTPhone(){
		return jTPhone.getText();
	}
	
	public String getjTEmail(){
		return jTEmail.getText();
	}
	
	public String getjTStartDate(){
		return jTStartDate.getText();
	}
	
	public double getjTSalary(){
		return Double.parseDouble(jTSalary.getText());
	}
	
	public String getjTEndDate(){
		return jTEndDate.getText();
	}
	
	public JComboBox getjCBDepartment(){
		return jCBDepartment;
	}
	
	public JComboBox getjCBEditDepartment(){
		return jCBEditDepartment;
	}
	
	public void refreshAddLecturer(){
		jTId.setText("");
		jTLecturerName.setText("");
		jTAddress.setText("");
		jTPhone.setText("");
		jTEmail.setText("");
		jTStartDate.setText("");
		jTSalary.setText("");
		jTEndDate.setText("");
	}
	
	//edit	
	public String getjTLecturerName2(){
		return jTLecturerName2.getText();
	}
	
	public String getjTAddress2(){
		return jTAddress2.getText();
	}
	
	public String getjTPhone2(){
		return jTPhone2.getText();
	}
	
	public String getjTEmail2(){
		return jTEmail2.getText();
	}
	
	public String getjTStartDate2(){
		return jTStartDate2.getText();
	}
	
	public double getjTSalary2(){
		return Double.parseDouble(jTSalary2.getText());
	}
	
	public String getjTEndDate2(){
		return jTEndDate2.getText();
	}
	
	public JComboBox getjCBLectureId(){
		return jCBLectureId;
	}
	
	public JComboBox getjCBDepartmentEditL(){
		return jCBDepartmentEditL;
	}
	
	public void editLecturer(String name, String address, String phone, String email, String start_date, double salary, String end_date, String department){
		jTLecturerName2.setText(name);
		jTAddress2.setText(address);
		jTPhone2.setText(phone);
		jTEmail2.setText(email);
		jTStartDate2.setText(start_date);
		jTSalary2.setText(String.valueOf(salary));
		jTEndDate2.setText(end_date);
		jCBDepartmentEditL.setSelectedItem(department);
	}
	
}

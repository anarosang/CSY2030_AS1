package assignment;

import javax.swing.*;
import controllers.Controller;
import models.Model;
import views.View;

public class HR extends JFrame {
	
	public static void main(String[] args) {
		Model model = new Model();
		Controller controller = new Controller(model);
		View view = new View(model, controller);
	}
	
/*	public void displayFille(String filename) throws IOException{
		File myFile = new File("Files/" + filename);
		Scanner inputFile;
		String str = "";
		
		try{
			FileReader reader = new FileReader(myFile);
			BufferedReader br = new BufferedReader(reader);
			jTFileDisplay.read(br, null);
			br.close();
			jTFileDisplay.requestFocus();
			
			for(int i = 0;i <= 1000; i++){
				//jTFLine.setText(jTFLine.getText() + i + "\n");
				JLabel lineNumber = new JLabel(i + "\n");
				jPLines.add(lineNumber);
			}
			
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void search(){ //https://stackoverflow.com/questions/17985808/search-text-file-and-display-results-in-a-jpanel/17988175
		jTFileDisplay.getHighlighter().removeAllHighlights();
		
		String find = jTFSearch.getText();
        Document document = jTFileDisplay.getDocument();
        try {
            for (int index = 0; index + find.length() < document.getLength(); index++) {
                String match = document.getText(index, find.length());
                if (find.equalsIgnoreCase(match)) {
                    javax.swing.text.DefaultHighlighter.DefaultHighlightPainter highlightPainter = new javax.swing.text.DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);
                    jTFileDisplay.getHighlighter().addHighlight(index, index + find.length(), highlightPainter);
                }
            }
        } catch (BadLocationException exp) {
            exp.printStackTrace();
        }
	}
	
	public void actionPerformed(ActionEvent event){
		Object jMIAction = event.getSource();
		
		if(jMIAction == jMIViewL){
			try {
				cardLayout.show(cardPanel, "File Display");
				displayFille("Lecturers.txt");
				Lecturers.readLecturers();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
			if(jMIAction == jMIEditL){
				try {
					cardLayout.show(cardPanel, "Edit Lecture");
					Lecturers.readLecturers();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		else
		if(jMIAction == jMIViewD){
			try {
				cardLayout.show(cardPanel, "File Display");
				displayFille("Departments.txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
			if(jMIAction == jBSearch && !jTFSearch.equals(null)){
				search();
            }
		else
			if(jMIAction == jMIAddD){
				cardLayout.show(cardPanel, "Add Department");
			}
		else
			if(jMIAction == jMIAddL){
				cardLayout.show(cardPanel, "Add Lecture");
			}
		else
			if(jMIAction == jBAddLecturer){
				if(jRBPartTime.isSelected()){
					PartTime newLecturer = new PartTime(Integer.parseInt(jTId.getText()), jTLecturerName.getText(), jTAddress.getText(), jTPhone.getText(), jTEmail.getText(), jTStartDate.getText(), null, Double.parseDouble(jTSalary.getText()));
					try {
						newLecturer.add();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(jRBFullTime.isSelected()){
					FullTime newLecturer = new FullTime(Integer.parseInt(jTId.getText()), jTLecturerName.getText(), jTAddress.getText(), jTPhone.getText(), jTEmail.getText(), jTStartDate.getText(), null, Integer.parseInt(jTSalary.getText()));
					try {
						newLecturer.add();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if (jRBContract.isSelected()){
					Contract newLecturer = new Contract(Integer.parseInt(jTId.getText()), jTLecturerName.getText(), jTAddress.getText(), jTPhone.getText(), jTEmail.getText(), jTStartDate.getText(), null, Integer.parseInt(jTSalary.getText()), jTEndDate.getText());
					try {
						newLecturer.add();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		/*else
			if(jMIAction == jMIEditL){
				Lecturers.readLecturers();
			}
			
	}*/

	

}

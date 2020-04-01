package command;

import javax.swing.*;
import java.time.LocalDate;
import model.Document;
import java.awt.event.*; 

public class NewDocument implements ActionListener {
	
	//GUI Components
	JTextArea textArea;
	JFrame frame;
	//Document object carried over from view.
	Document curDocument;
	
	//constructor
	public NewDocument(JTextArea textArea, JFrame frame, Document curDocument) {
		this.textArea = textArea;
		this.frame = frame;
		this.curDocument = curDocument;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		textArea.setText("");
		//Reasons of use of JOptionPane simple popup: 
		//Easy to use/get returned strings, Not alot of code needed, fast to implement and user friendly
		String author = (String)JOptionPane.showInputDialog(frame, "Please enter an author: ","Create new document.",JOptionPane.PLAIN_MESSAGE);
		String title = (String)JOptionPane.showInputDialog(frame, "Please enter a title: ", "Create new document.",JOptionPane.PLAIN_MESSAGE);

		//Change document title,author and creation date.
		curDocument.setAuthor(author);
		curDocument.setTitle(title);
		curDocument.setCreationDate(LocalDate.now());
		
	}
	


}

package command;

import java.awt.event.*;
import java.time.LocalDate;

import javax.swing.*;

import model.Document;

public class NewDocument implements ActionListener {

	//GUI Components
	JTextArea textArea;
	JFrame frame;
	//Document object carried over from view.
	Document curDocument;

	String author = "";
	String title = "";

	//private CommandFactory commandBoolValue = new CommandFactory(null,null,null,null,null,null);

	//if test = 0 then we have not overloaded the constructor so we are not doing a JUnit Test
	int test = 0;

	//constructor
	public NewDocument(JTextArea textArea, JFrame frame, Document curDocument) {
		this.textArea = textArea;
		this.frame = frame;
		this.curDocument = curDocument;
	}
	//overload for testing
	public NewDocument(JTextArea textArea, JFrame frame, Document curDocument, int test) {
		this.textArea = textArea;
		this.frame = frame;
		this.curDocument = curDocument;
		this.test = test;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		createNewDocument();
	}

	public void createNewDocument() {

		//Reasons of use of JOptionPane simple popup:
		//Easy to use/get returned strings, Not alot of code needed, fast to implement and user friendly
		if(test == 0) {
			textArea.setText("");
			author = (String)JOptionPane.showInputDialog(frame, "Please enter an author: ","Create new document.",JOptionPane.PLAIN_MESSAGE);
			title = (String)JOptionPane.showInputDialog(frame, "Please enter a title: ", "Create new document.",JOptionPane.PLAIN_MESSAGE);
			if(author.trim().length() == 0) {
				author = "None";
			}
			if(title.trim().length() == 0) {
				title = "None";
			}
		}

		//Change document title,author and creation date.
		curDocument.setAuthor(author);
		curDocument.setTitle(title);
		curDocument.setCreationDate(LocalDate.now());
		curDocument.getContents().clear();

		//check if we are recording commands
		if(CommandFactory.getStartReplayBool() == true) {
			addCommandToArray();
		}
		if(test == 0) {
			frame.setTitle("Text2Speech Editor" + " Author: " + curDocument.getAuthor() + " Title: " + curDocument.getTitle());

		}
	}



	//add command to command array in ReplayCommand
	public void addCommandToArray() {
		NewDocument replayNewDocument = new NewDocument(textArea, frame, curDocument);
		ReplayCommand.addCommandToArraylist(replayNewDocument);
	}
}

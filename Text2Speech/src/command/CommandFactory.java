package command;

import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import model.Document;
import model.Line;
import javax.swing.*;

public class CommandFactory {

	//constructor passed objects
	JTextArea textArea;
	JFrame frame;
	//document object carried over from view
	Document curDocument;
	//commands
	public ActionListener newListener = null;

	private NewDocument newDocument;
	private SaveDocument saveDocument;
	private OpenDocument openDocument;

	public CommandFactory(JTextArea textArea, JFrame frame, Document curDocument) {
		//GUI Components
		this.textArea = textArea;
		this.frame = frame;
		//Document
		this.curDocument = curDocument;
		//initialize commands
		newDocument = new NewDocument(textArea, frame, curDocument);
		saveDocument = new SaveDocument(textArea, curDocument);
		openDocument = new OpenDocument(textArea, frame, curDocument);
	}

	public ActionListener createCommand(String s) {
		ActionListener temp = null;
		if(s.equals("New")) {
			return newDocument;
		} else if(s.equals("Save")) {
			return saveDocument;
		}
		else if(s.equals("Open...")) {
			return openDocument;
		}
		//add other commands
		return temp;
	}
}

package command;

import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.*;

public class CommandFactory {
	
	JTextArea textArea;
	JFrame frame;
	public ActionListener newListener = null;
	
	private NewDocument newDocument;
	private SaveDocument saveDocument;
	private OpenDocument openDocument;
	
	public CommandFactory(JTextArea textArea, JFrame frame) {
		//GUI Components
		this.textArea = textArea;
		this.frame = frame;
		//initialize commands
		newDocument = new NewDocument(textArea);
		saveDocument = new SaveDocument(textArea);
		openDocument = new OpenDocument(textArea, frame);
		
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

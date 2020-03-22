package command;

import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JTextArea;

public class CommandFactory {
	
	JTextArea textArea;
	JFrame frame;
	public ActionListener newListener = null;
	
	private NewDocument newDocument;
	private OpenDocument openDocument;
	private SaveDocument saveDocument;
	
		//GUI Components
		this.textArea = textArea;
		this.frame = frame;
		
		//initialize commands
		newDocument = new NewDocument(textArea);
		openDocument = new OpenDocument(textArea, frame);
		saveDocument = new SaveDocument(textArea);
		
	}
	
	public ActionListener createCommand(String s) {
		ActionListener temp = null;
		if(s.equals("New")) {
			return newDocument;
		}
		else if(s.equals("Open...")) {
			return openDocument;
		} else if(s.equals("Save")) {
			return saveDocument;
		}
		//add other commands
		return temp;
	}
}

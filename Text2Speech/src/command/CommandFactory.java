package command;

import java.awt.event.ActionListener;
import javax.swing.JTextArea;

public class CommandFactory {
	
	JTextArea textArea;
	public ActionListener newListener = null;
	
	private NewDocument newDocument;
	
	public CommandFactory(JTextArea textArea) {
		//GUI Components
		this.textArea = textArea;
		//initialize commands
		newDocument = new NewDocument(textArea);
		
	}
	
	public ActionListener createCommand(String s) {
		ActionListener temp = null;
		if(s.equals("New")) {
			return newDocument;
		}
		//add other commands
		return temp;
	}
}

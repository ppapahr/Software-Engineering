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
		//Object newDoc = Class.forName(commands.get(s)).newInstance();
		ActionListener temp = null;
		if(s.equals("New")) {
			System.out.println(newDocument);
			return newDocument;
		}
		//add other commands
		return temp;
	}
}

package command;

import javax.swing.*; 
import java.awt.event.*; 

public class NewDocument implements ActionListener {
	
	//GUI Components
	JTextArea textArea;
	
	public NewDocument(JTextArea textArea) {
		this.textArea = textArea;
		System.out.println("New Factory2");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
	}
	


}

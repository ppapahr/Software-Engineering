package command;

import javax.swing.*; 
import java.awt.event.*; 

public class NewDocument implements ActionListener {
	
	//GUI Components
	JTextArea textArea;
	
	public NewDocument(JTextArea textArea) {
		this.textArea = textArea;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		textArea.setText("");
		//TO BE ADDED: DOCUMENT CHANGES
	}
	


}

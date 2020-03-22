package command;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.filechooser.*;
import java.util.Scanner;

public class OpenDocument implements ActionListener{
	
	//GUI Components
	JTextArea textArea;
	JFileChooser fc;
	JFrame frame;
		
	StringBuilder sb = new StringBuilder();
	
	public OpenDocument(JTextArea textArea, JFrame frame) {
		this.textArea = textArea;
		this.frame = frame;
		
		//create file chooser
        fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter("TEXT FILES", "txt", "text"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int returnVal = fc.showOpenDialog(frame);
		
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();            
            Scanner input;
            
			try {
				//reset caret position
	            textArea.setCaretPosition(0);

				input = new Scanner(file);
				
				//load StringBuilder with file
				while(input.hasNext()) {
	            	sb.append(input.nextLine());
	            	sb.append("\n");
	            }
	            input.close();

	            textArea.setText(sb.toString());
	            
	            //reset StringBuilder buffer
	            sb.setLength(0);
			} catch (FileNotFoundException e1) {
				//auto-generated catch block
				textArea.setText("File not found." + "\n");
				e1.printStackTrace();
			}
        }
	}
}

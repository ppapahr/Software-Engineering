package command;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.*;

import model.Document;
import model.Line; 

public class EditDocument implements ActionListener {
	
	private JTextArea textArea;
	private Document curDocument;
	
	public EditDocument(JTextArea textArea, Document curDocument) {
		this.textArea = textArea;
		this.curDocument = curDocument;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("edit");
		//variable for acceptable action performed
		int action = -1;
		
		ArrayList<Line> contents = new ArrayList<Line>();
		ArrayList<String> lines = new ArrayList<String>();

		//for testing pass existing text
		if (e == null) {
			String l[] = "This is the \nedited text".split("\\r?\\n");
			Collections.addAll(lines, l);
			action = 1;
		}
		else {
			String l[] = textArea.getText().split("\\r?\\n"); 
			Collections.addAll(lines, l);
			action = 0;
		}
			
				
		if (action == 0 || action == 1) {
			
			//split each line by whitespace characters and add the split list to line class object which is then added to contents
			for(int i=0; i<lines.size(); i++) {
				ArrayList<String> words = new ArrayList<>(Arrays.asList(lines.get(i).split("\\s+")));
				Line temp = new Line(words);
				contents.add(temp);
			}
			
			//set the curDoc's contents
			curDocument.setContents(contents);
		}
		
		//check if we are recording commands
		if(CommandFactory.getStartReplayBool() == true) {
			addCommandToArray();
		}
	}
	
	//add command to command array in ReplayCommand
	public void addCommandToArray() {
		EditDocument replayEditDocument = new EditDocument(textArea, curDocument);
		ReplayCommand.addCommandToArraylist(replayEditDocument);
	}
}

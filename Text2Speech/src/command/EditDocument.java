package command;

import javax.swing.*;
import model.Document;
import model.Line;
import java.awt.event.*; 
import java.util.ArrayList;
import java.util.Arrays; 

public class EditDocument implements ActionListener {
	
	private JTextArea textArea;
	private Document curDocument;
	
	public EditDocument(JTextArea textArea, Document curDocument) {
		this.textArea = textArea;
		this.curDocument = curDocument;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ArrayList<Line> contents = new ArrayList<Line>();
		//split textArea by lines
		String l[] = textArea.getText().split("\\r?\\n");
	    ArrayList<String> lines = new ArrayList<>(Arrays.asList(l));
	    
	    //System.out.println(lines);
	    
	    //split each line by whitespace characters and add the split list to line class object which is then added to contents
		for(int i=0; i<lines.size(); i++) {
			ArrayList<String> words = new ArrayList<>(Arrays.asList(lines.get(i).split("\\s+")));
			Line temp = new Line(words);
			contents.add(temp);
			//System.out.println(words);
		}
		
		//set the curDoc's contents
		curDocument.setContents(contents);
	}
}

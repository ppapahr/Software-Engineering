package command;

import java.awt.event.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.filechooser.*;

import model.Document;
import model.Line;


public class OpenDocument implements ActionListener{
	
	//GUI Components
	JTextArea textArea;
	JFileChooser fc;
	JFrame frame;
	
	//Document object carried over from view.
	Document curDocument;
	
	StringBuilder sb = new StringBuilder();
	ArrayList<Line> contents = new ArrayList<Line>();
	
	public OpenDocument(JTextArea textArea, JFrame frame, Document curDocument) {
		this.textArea = textArea;
		this.frame = frame;
		this.curDocument = curDocument;
				
		//create file chooser
        fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter("TEXT FILES", "txt", "text"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//variable for acceptable action performed
		int action = -1;
		
		//for testing pass existing file
		if (e == null) {
			fc.setSelectedFile(new File("testFile.txt"));
			action = 1;
		}
		else {
			int returnVal = fc.showOpenDialog(frame);
			 if (returnVal == JFileChooser.APPROVE_OPTION) {
				 action = 0;
			 }
		}
			
				
        if (action == 0 || action == 1) {
            File file = fc.getSelectedFile();            
            Scanner input;
            
			try {
				//reset caret position
				if (action == 0) {
					textArea.setCaretPosition(0);
				}
				input = new Scanner(file);
				
				//load stringBuilder with title,author,saved date and creation date.
				for(int lineNumber=0; lineNumber<4; lineNumber++){
					sb.append(input.nextLine());
	            	sb.append("\n");
				}
				
				/* Header format:
				 * Author: ""
				 * Title: ""
				 * Creation Date: ""
				 * Saved Date: ""
				 */
				String[] files = sb.toString().split("\\r?\\n");
				String author = files[0].substring(8);
				String title = files[1].substring(7);
				String creationDateStr = files[2].substring(15);
				String savedDateStr = files[3].substring(12);
				
				//convert String to LocalDate
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate creationDate = LocalDate.parse(creationDateStr, formatter);
				LocalDate savedDate = LocalDate.parse(savedDateStr, formatter);
				
				//reset StringBuilder buffer
				sb.setLength(0);
				
				//stringBuilder for testing
				StringBuilder tsb = new StringBuilder();
				
				//empty contents from before
				contents = new ArrayList<Line>();
				
				//load StringBuilder and Line class with the rest of the file
				while(input.hasNext()) {
					String nextLine = input.nextLine();
	            	sb.append(nextLine);
	            	sb.append("\n");
	            	
	            	tsb.append(nextLine);
	            	tsb.append("\n");
	            	
	            	//split line in words and append them in an arraylist
	            	ArrayList<String> words = new ArrayList<String>(Arrays.asList(tsb.toString().split("\\s")));
	            	Line curLine = new Line(words, null, null);
	            	
	            	//add word arraylist in Document's content
	            	contents.add(curLine);
	            	
	            	tsb.setLength(0);
	            }
	            input.close();
	            
	            //load document with title,author,creation date,saved date and text.
	            if(author.equals("")) {
	            	curDocument.setAuthor("None");
	            } else {
	            	curDocument.setAuthor(author);
	            }
	            if(title.equals("")) {
	            	curDocument.setTitle("None");
	            } else {
	            	curDocument.setTitle(title);
	            }
				curDocument.setCreationDate(creationDate);
				curDocument.setSavedDate(savedDate);
				curDocument.setContents(contents);
				
				if(action == 0) {
					frame.setTitle("Text2Speech Editor" + " Author: " + curDocument.getAuthor() + " Title: " + curDocument.getTitle());
				}
				
				if (action == 0) {
					textArea.setText(sb.toString());
				}
				
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

package command;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.Document;

import java.awt.event.*;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList; 

public class SaveDocument implements ActionListener {
	
	
	private JTextArea textArea;
	
	private Document curDocument;
	
	public SaveDocument(JTextArea textArea, Document curDocument) {
		this.textArea = textArea;
		this.curDocument = curDocument;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//set savedDate in document
		curDocument.setSavedDate(LocalDate.now());
		
		//savedText is going to be the output to .txt file
		JTextArea savedText = new JTextArea();
		
		//transfer curDocument to savedFile
		savedText.append("Author: " + curDocument.getAuthor() + "\n");
		savedText.append("Title: " + curDocument.getTitle() + "\n");
		savedText.append("Creation Date: " + curDocument.getCreationDate().toString() + "\n");
		savedText.append("Saved Date: " + curDocument.getSavedDate().toString() + "\n");
		
		//transfer curDocument's contents to savedText
		for(int i=0; i<curDocument.getContents().size(); i++) {
			ArrayList<String> line = curDocument.getContents().get(i).getWords();
			for(int j=0; j<line.size(); j++) {
				savedText.append(line.get(j) + " ");
			}
			savedText.append("\n");
		}
		
		//open gui dialog
		FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("Text File", "txt");
	    final JFileChooser saveAsFileChooser = new JFileChooser();
	    saveAsFileChooser.setApproveButtonText("Save");
	    saveAsFileChooser.setFileFilter(extensionFilter);
	    int actionDialog = saveAsFileChooser.showOpenDialog(null);
	    if (actionDialog != JFileChooser.APPROVE_OPTION) {
	         return;
	    }
		
	    File file = saveAsFileChooser.getSelectedFile();
	    if (!file.getName().endsWith(".txt")) {
	       file = new File(file.getAbsolutePath() + ".txt");
	    }
	    
	    //write the buffer to the .txt file
	    BufferedWriter outFile = null;
	    try {
	       outFile = new BufferedWriter(new FileWriter(file));

	       savedText.write(outFile);

	    } catch (IOException ex) {
	       ex.printStackTrace();
	    } finally {
	       if (outFile != null) {
	          try {
	             outFile.close();
	          } catch (IOException ex2) {}
	       }
	    }
	}
	
}

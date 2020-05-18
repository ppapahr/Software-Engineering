package command;

import java.awt.event.*;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.Document; 

public class SaveDocument implements ActionListener {

	private Document curDocument;
	private int TEST_FLAG;
	
	public SaveDocument(Document curDocument) {
		this.curDocument = curDocument;
		this.TEST_FLAG = 0;
	}
	
	public SaveDocument(Document curDocument, int TEST_FLAG) {
		this.curDocument = curDocument;
		this.TEST_FLAG = TEST_FLAG;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("save");
		//check if document has been created first so that saveDocument doesn't return error
		if(curDocument.getCreationDate() == null) {
			return;
		}
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
	    if(TEST_FLAG == 0) {
	    	int actionDialog = saveAsFileChooser.showOpenDialog(null);
		    if (actionDialog != JFileChooser.APPROVE_OPTION) {
		         return;
		    }
	    }
	    
	    File file;
		if(TEST_FLAG == 0) {
			file = saveAsFileChooser.getSelectedFile();
		}else{
			file = new File("test.txt");
		}
	    
	    
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
	   
	    //check if we are recording commands
	    if(CommandFactory.getStartReplayBool() == true) {
	  	    addCommandToArray();
	    }
	}
	
	//add command to command array in ReplayCommand
	public void addCommandToArray() {
		SaveDocument replaySaveDocument = new SaveDocument(curDocument); 
		ReplayCommand.addCommandToArraylist(replaySaveDocument);	
	}
	
}

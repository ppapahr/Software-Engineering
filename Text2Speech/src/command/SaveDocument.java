package command;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.*;
import java.io.*; 

public class SaveDocument implements ActionListener {
	
	
	private JTextArea textArea;
	
	public SaveDocument(JTextArea textArea) {
		this.textArea = textArea;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
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

	    BufferedWriter outFile = null;
	    try {
	       outFile = new BufferedWriter(new FileWriter(file));

	       textArea.write(outFile);

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

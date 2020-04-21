package command;

import java.awt.event.*;
import java.util.Collections;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Utilities;

import model.Document;
import model.Line; 

public class LineToSpeech implements ActionListener{
	
	private Document curDocument;
	private int chosenFunc;
	private JTextArea textArea;
	
	/*
	  chosenFunc can be one of the following numbers:
	  1 --> playDocument
	  2 --> playReverseDocument
	  3 --> playLine
	  4 --> playReverseLine
	*/
	
	public LineToSpeech(JTextArea textArea, Document curDocument, int chosenFunc) {
		this.textArea = textArea;
		this.curDocument = curDocument;
		this.chosenFunc = chosenFunc;
	}
	
	public int getRowNumber() {
		int caretPos = textArea.getCaretPosition();
		int rowNum = (caretPos == 0) ? 1 : 0;
		for (int offset = caretPos; offset > 0;) {
		    try {
				offset = Utilities.getRowStart(textArea, offset) - 1;
			} catch (BadLocationException e1) {
				e1.printStackTrace();
			}
		    rowNum++;
		}
		return rowNum;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(curDocument.getContents().size() == 0) {
			System.out.println("Nothing to read");
			return;
		}
		
		if(chosenFunc == 1) {
			System.out.println("Playing document");
			//curDocument.playContents();
		} else if(chosenFunc == 2) {
			System.out.println("Playing reverse document");
			//curDocument.playReverseContents();
		} else if(chosenFunc == 3) {
			System.out.println("Playing line" + " " + this.getRowNumber());
			//curDocument.playLine(this.getRowNumber());
		} else if(chosenFunc == 4){
			System.out.println("Playing reverse line" + " " + this.getRowNumber());
			//curDocument.playReverseLine(this.getRowNumber());
		}
		
	}

}

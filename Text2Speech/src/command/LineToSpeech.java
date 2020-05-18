package command;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Utilities;

import model.Document;

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
	  5 --> playEncodedDocument
	  6 --> playEncodedLine
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
	
	public void setChosenFunc(int num) {
		this.chosenFunc = num;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(curDocument.getContents().size() == 0) {
			return;
		}
		if(chosenFunc == 1) {
			curDocument.playContents();
			
			//check if we are recording commands
			if(CommandFactory.getStartReplayBool() == true) {
				addCommandToArray(chosenFunc);
			}
		} else if(chosenFunc == 2) {
			curDocument.playReverseContents();
			
			//check if we are recording commands
			if(CommandFactory.getStartReplayBool() == true) {
				addCommandToArray(chosenFunc);
			}
		} else if(chosenFunc == 3) {
			curDocument.playLine(this.getRowNumber());
			
			//check if we are recording commands
			if(CommandFactory.getStartReplayBool() == true) {
				addCommandToArray(chosenFunc);
			}
		} else if(chosenFunc == 4){
			curDocument.playReverseLine(this.getRowNumber());
			
			//check if we are recording commands
			if(CommandFactory.getStartReplayBool() == true) {
				addCommandToArray(chosenFunc);
			}
		}
		else if(chosenFunc == 5) {
			curDocument.playEncodedContents();
			
			//check if we are recording commands
			if(CommandFactory.getStartReplayBool() == true) {
				addCommandToArray(chosenFunc);
			}
		}
		else if(chosenFunc == 6) {
			curDocument.playEncodedLine(getRowNumber());
			
			//check if we are recording commands
			if(CommandFactory.getStartReplayBool() == true) {
				addCommandToArray(chosenFunc);
			}
		}
	}
	
	//add command to command array in ReplayCommand
	public void addCommandToArray(int chosenFunc) {
		LineToSpeech replayLineToSpeech = new LineToSpeech(textArea, curDocument, chosenFunc);
		//LineToSpeech replayLineToSpeech = this.clone();
		ReplayCommand.addCommandToArraylist(replayLineToSpeech);
	}
}
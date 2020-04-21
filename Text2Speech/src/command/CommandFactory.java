package command;

import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JTextArea;

import model.Document;

public class CommandFactory {

	//constructor passed objects
	JTextArea textArea;
	JFrame frame;
	//document object carried over from view
	Document curDocument;
	//commands
	public ActionListener newListener = null;

	private NewDocument newDocument;
	private SaveDocument saveDocument;
	private OpenDocument openDocument;
	private EditDocument editDocument;
	
	private LineToSpeech playContents;
	private LineToSpeech playReverseContents;
	private LineToSpeech playLine;
	private LineToSpeech playReverseLine;

	public CommandFactory(JTextArea textArea, JFrame frame, Document curDocument) {
		//GUI Components
		this.textArea = textArea;
		this.frame = frame;
		//Document
		this.curDocument = curDocument;
		//initialize commands
		newDocument = new NewDocument(textArea, frame, curDocument);
		saveDocument = new SaveDocument(textArea, curDocument);
		openDocument = new OpenDocument(textArea, frame, curDocument);
		editDocument = new EditDocument(textArea, curDocument);
		
		playContents = new LineToSpeech(textArea, curDocument, 1);
		playReverseContents = new LineToSpeech(textArea, curDocument, 2);
		playLine = new LineToSpeech(textArea, curDocument, 3);
		playReverseLine = new LineToSpeech(textArea, curDocument, 4);
	}

	public ActionListener createCommand(String s) {
		ActionListener temp = null;
		if(s.equals("New")) {
			return newDocument;
		} else if(s.equals("Save")) {
			return saveDocument;
		}
		else if(s.equals("Open...")) {
			return openDocument;
		}
		else if(s.equals("Edit")) {
			return editDocument;
		}
		else if(s.equals("Play document")) {
			return playContents;
		}
		else if(s.equals("Play reverse document")) {
			return playReverseContents;
		}
		else if(s.equals("Play line")) {
			return playLine;
		}
		else if(s.equals("Play reverse line")) {
			return playReverseLine;
		}
		//add other commands
		return temp;
	}
}

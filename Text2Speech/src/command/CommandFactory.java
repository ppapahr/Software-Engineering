package command;

import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JTextArea;

import model.Document;

public class CommandFactory {

	//constructor passed objects
	JTextArea textArea;
	JFrame frame;
	JSlider volumeSlider;
	JSlider rateSlider;
	JSpinner pitchSpinner;
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
	private LineToSpeech playEncodedDocument;
	private LineToSpeech playEncodedLine;
	
	private TuneEncoding rot13;
	private TuneEncoding atBash;
	
	private TuneAudio tuneAudio;

	public CommandFactory(JTextArea textArea, JFrame frame, Document curDocument, JSlider volumeSlider, JSlider rateSlider, JSpinner pitchSpinner) {
		//GUI Components
		this.textArea = textArea;
		this.frame = frame;
		this.volumeSlider = volumeSlider;
		this.rateSlider = rateSlider;
		this.pitchSpinner = pitchSpinner;
		//Document
		this.curDocument = curDocument;
		//Sound related GUI
		
	}

	public ActionListener createCommand(String s) {
		ActionListener temp = null;
		if(s.equals("New")) {
			newDocument = new NewDocument(textArea, frame, curDocument);
			//can be added to arraylist here
			return newDocument;
		} else if(s.equals("Save")) {
			saveDocument = new SaveDocument(curDocument);
			return saveDocument;
		}
		else if(s.equals("Open...")) {
			openDocument = new OpenDocument(textArea, frame, curDocument);
			return openDocument;
		}
		else if(s.equals("Edit")) {
			editDocument = new EditDocument(textArea, curDocument);
			return editDocument;
		}
		else if(s.equals("Play document")) {
			playContents = new LineToSpeech(textArea, curDocument, 1);
			return playContents;
		}
		else if(s.equals("Play reverse document")) {
			playReverseContents = new LineToSpeech(textArea, curDocument, 2);
			return playReverseContents;
		}
		else if(s.equals("Play reverse line")) {
			playReverseContents = new LineToSpeech(textArea, curDocument, 4);
			return playReverseContents;
		}
		else if(s.equals("Play line")) {
			playLine = new LineToSpeech(textArea, curDocument, 3);
			return playLine;
		}
		else if(s.equals("Play encoded document")) {
			playEncodedDocument = new LineToSpeech(textArea, curDocument, 5);
			return playEncodedDocument;
		}
		else if(s.equals("Play encoded line")) {
			playEncodedLine = new LineToSpeech(textArea, curDocument, 6);
			return playEncodedLine;
		}
		else if(s.equals("Rot13")) {
			rot13 = new TuneEncoding(curDocument, 2);
			return rot13;
		}
		else if(s.equals("AtBash")) {
			atBash = new TuneEncoding(curDocument, 1);
			return atBash;
		}
		else if(s.equals("TuneAudio")) {
			tuneAudio = new TuneAudio(curDocument, volumeSlider, rateSlider, pitchSpinner);
			return tuneAudio;
		}
		//add other commands
		return temp;
	}
}

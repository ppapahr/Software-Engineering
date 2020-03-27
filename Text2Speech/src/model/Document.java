package model;

import java.util.ArrayList;
import encodingstrategies.*;
import text2speechapis.*;

public class Document {
	
	private ArrayList<Line> contents;
	private EncodingStrategy encodingStrategy;
	private TextToSpeechAPI audioManager;
	
	
	public Document(ArrayList<Line> contents, EncodingStrategy encodingStrategy, TextToSpeechAPI audioManager) {
		this.contents = contents;
		this.encodingStrategy = encodingStrategy;
		this.audioManager = audioManager;
	}
	
	public void playContents() {
		
	}
	
	public void playReverseContents() {
		
	}
	
	public void playEncodedContents() {
		
	}
	
	public void playLine(int num) {
		
	}
	
	public void playReverseLine(int num) {
		
	}
	
	public void playEncodedLine(int num) {
		
	}
	
	public void tuneEncodingStrategy(EncodingStrategy encodingStrategy) {
		this.encodingStrategy = encodingStrategy; 
	}
}

package model;

import java.util.ArrayList;
import encodingstrategies.*;
import text2speechapis.*;

public class Line {
	private ArrayList<String> words;
	private EncodingStrategy encodingStrategy;
	private TextToSpeechAPI audioManager;
	
	public Line(ArrayList<String> words, EncodingStrategy encodingStrategy, TextToSpeechAPI audioManager) {
		this.words = words;
		this.encodingStrategy = encodingStrategy;
		this.audioManager = audioManager;
	}
	
	public Line(ArrayList<String> words) {
		this.words = words;
	}
	
	//getters
	
	public ArrayList<String> getWords() {
		return words;
	}
	
	// Text2Speech & Encoding functions
	
	public void playLine() {
		
	}
	
	public void playReverseLine() {
		
	}
	
	public void playEncodedLine() {
		
	}
	
	public void tuneEncodingStrategy(EncodingStrategy encodingStrategy) {
		this.encodingStrategy = encodingStrategy;
	}
}
